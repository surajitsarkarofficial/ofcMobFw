package com.globant.qe.in.travelNEXT.mobile.listeners;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.collections.Lists;
import org.testng.ISuite;

import org.testng.ISuiteResult;


import org.testng.xml.XmlSuite;

import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;
import com.globant.qe.in.travelNEXT.mobile.tests.TravelNEXTMobileBaseTestSuite;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import java.util.*;
 


public class MobilePDFReportGenerator implements IReporter{
	
	@Autowired
	TravelNEXTWelcomePage welcomePage;
	
	private final String outputDirectory = "./";
	protected List<SuiteResult> suiteResults = Lists.newArrayList();

	// PDF
	private Document document = new Document();
	PdfPTable testSummaryTable= null;
	Paragraph p = null;
	PdfPCell cell = null;
	int totalPassedTests = 0;
	int totalSkippedTests = 0;
	int totalFailedTests = 0;
	long totalDuration = 0;
	int totalTestcases = 0;
	PdfWriter writer=null;
	
    @Override
    /**
     * This method will generate PDF Report
     */
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    	outputDirectory = this.outputDirectory + TravelNEXTMobileBaseTestSuite.exePlatform+
    			"_"+TravelNEXTMobileBaseTestSuite.executionEnvironment.toUpperCase()+"_TestReport.pdf";
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(outputDirectory));
			writer.setFullCompression();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.document.open();
		for (ISuite suite : suites) {
			suiteResults.add(new SuiteResult(suite));
		}

		writeHeader();
		writeExecutionSummary();
		writeChartToPdf();
		if(totalFailedTests>0)
		{
			Paragraph p = new Paragraph("TEST DETAILS", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));
		p.setAlignment("Center");
		try {
			this.document.add(p);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		for (ISuite suite : suites) {
			writeFailedAndSkippedReport(suite);
		}
		this.document.close();
        

    }
    
    /**
	 * This method will Write the PDF Report Header
	 */
	private void writeHeader() {
		Paragraph p = new Paragraph("MOBILE EXECUTION REPORTS", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));
		p.setAlignment("Center");
		try {
			document.add(p);
			p = new Paragraph(new Date().toString(),
					FontFactory.getFont(FontFactory.TIMES_ITALIC, 15, Font.NORMAL, new Color(211, 84, 0)));
			p.setAlignment("Center");
			document.add(p);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * This method will Write the execution Summary table
	 */
	protected void writeExecutionSummary() {
		// Construct the headers
		if (this.testSummaryTable == null) {
			this.testSummaryTable = new PdfPTable(new float[] { .32f, .14f, .11f, .12f, .10f, .21f });
			testSummaryTable.setWidthPercentage(100f);
			Paragraph p = new Paragraph("EXECUTION SUMMARY",
					new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setMinimumHeight(20f);
			cell.setBackgroundColor(new Color(21, 67, 96));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			this.testSummaryTable.addCell(cell);
			p = new Paragraph("EXECUTION ENVIRONMENT - " + TravelNEXTMobileBaseTestSuite.executionEnvironment.toUpperCase(),
					new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
			cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setMinimumHeight(20f);
			cell.setBackgroundColor(new Color(21, 67, 96));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			this.testSummaryTable.addCell(cell);
			p = new Paragraph("EXECUTION PLATFORM - " + TravelNEXTMobileBaseTestSuite.exePlatform,
					new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
			cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setMinimumHeight(20f);
			cell.setBackgroundColor(new Color(21, 67, 96));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			this.testSummaryTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Test Name"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Total Test Cases"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Passed"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Skipped"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Failed"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Execution Time (In Seconds)"));
			cell.setBackgroundColor(new Color(127, 140, 141));
			this.testSummaryTable.addCell(cell);
		}

		// Print the Test wise results
		int testIndex = 0;
		for (SuiteResult suiteResult : suiteResults) {
			Paragraph p = new Paragraph(suiteResult.getSuiteName().toUpperCase(),
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLDITALIC, new Color(252, 252, 252)));
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setMinimumHeight(20f);
			cell.setBackgroundColor(new Color(31, 97, 141));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			this.testSummaryTable.addCell(cell);

			for (TestResult testResult : suiteResult.getTestResults()) {
				int totalTests = testResult.gettotalTestCount();
				int passedTests = testResult.getPassedTestCount();
				int skippedTests = testResult.getSkippedTestCount();
				int failedTests = testResult.getFailedTestCount();
				long duration = testResult.getDuration();

				cell = new PdfPCell(new Paragraph(testResult.getTestName()));
				this.testSummaryTable.addCell(cell);

				cell = new PdfPCell(new Paragraph(String.valueOf(totalTests)));
				this.testSummaryTable.addCell(cell);

				cell = new PdfPCell(new Paragraph(String.valueOf(passedTests)));

				this.testSummaryTable.addCell(cell);

				cell = new PdfPCell(new Paragraph(String.valueOf(skippedTests)));
				this.testSummaryTable.addCell(cell);

				cell = new PdfPCell(new Paragraph(String.valueOf(failedTests)));
				this.testSummaryTable.addCell(cell);

				cell = new PdfPCell(new Paragraph(CommonUtilities.convertMiliSecondsToHourMinSecMilliSec(duration)));
				this.testSummaryTable.addCell(cell);

				totalPassedTests += passedTests;
				totalSkippedTests += skippedTests;
				totalFailedTests += failedTests;
				totalDuration += duration;
				totalTestcases = totalPassedTests + totalSkippedTests + totalFailedTests;
				testIndex++;
			}
		}

		// Print totals if there was more than one test
		if (testIndex >= 1) {
			PdfPCell cell = new PdfPCell(new Paragraph("TOTAL"));
			cell.setBackgroundColor(new Color(189, 195, 199));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(totalTestcases)));
			cell.setBackgroundColor(new Color(133, 193, 233));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(totalPassedTests)));
			cell.setBackgroundColor(new Color(34, 153, 84));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(totalSkippedTests)));
			cell.setBackgroundColor(new Color(247, 220, 111));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(totalFailedTests)));
			cell.setBackgroundColor(new Color(231, 76, 60));
			this.testSummaryTable.addCell(cell);
			cell = new PdfPCell(new Paragraph(CommonUtilities.convertMiliSecondsToHourMinSecMilliSec(totalDuration)));
			cell.setBackgroundColor(new Color(189, 195, 199));
			this.testSummaryTable.addCell(cell);
		}
		// Write the test summary table into the pdf document
		try {
			if (this.testSummaryTable != null) {
				this.testSummaryTable.setSpacingBefore(15f);
				this.document.add(this.testSummaryTable);
				this.testSummaryTable.setSpacingAfter(15f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will create the Chart
	 * 
	 * @param totalPassed
	 * @param totalFailed
	 * @param totalSkipped
	 * @return
	 */
	public JFreeChart createChart(int totalPassed, int totalFailed, int totalSkipped) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		if(totalPassed>0)			
			dataSet.setValue("Passed", totalPassed);
			
			if(totalFailed>0)
			dataSet.setValue("Failed", totalFailed);
			
			if(totalSkipped>0)
			dataSet.setValue("Skipped", totalSkipped);
		JFreeChart chart = ChartFactory.createPieChart("Execution Report", dataSet, true, false, false);
		return chart;
	}

	/**
	 * This method will write the chart
	 */
	public void writeChartToPdf() {
		JFreeChart chart = createChart(totalPassedTests, totalFailedTests, totalSkippedTests);
		final PiePlot plot = (PiePlot) chart.getPlot();
		plot.setNoDataMessage("No data to display");
		if(totalPassedTests>0)
			plot.setSectionPaint("Passed", new Color(34, 153, 84));
			if(totalFailedTests>0)
			plot.setSectionPaint("Failed", new Color(231, 76, 60));
			if(totalSkippedTests>0)
			plot.setSectionPaint("Skipped", new Color(247, 220, 111));
		plot.setToolTipGenerator(null);
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");
		plot.setLabelGenerator(labelGenerator);
		chart.setTitle(new TextTitle("Execution Summary Chart"));
		PdfContentByte pdfContentByte = writer.getDirectContent();
		PdfTemplate pdfTemplateChartHolder = pdfContentByte.createTemplate(350, 225);
		Graphics2D graphicsChart = pdfTemplateChartHolder.createGraphics(350, 225, new DefaultFontMapper());
		Rectangle2D chartRegion = new Rectangle2D.Double(0, 0, 350, 225);
		chart.draw(graphicsChart, chartRegion);
		graphicsChart.dispose();
		Image chartImage = null;
		try {
			chartImage = Image.getInstance(pdfTemplateChartHolder);
		} catch (BadElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			chartImage.setAlignment(Element.ALIGN_CENTER);
			document.add(chartImage);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * This method will write the failed and skipped tests details
	 * 
	 * @param iSuite
	 */
	public void writeFailedAndSkippedReport(ISuite iSuite) {
		PdfPTable suiteTable = null;
		Map<String, ISuiteResult> results = iSuite.getResults();

		// Get the key of the result map

		Set<String> keys = results.keySet();

		// Go to each map value one by one

		for (String key : keys) {

			// The Context object of current result

			ITestContext context = results.get(key).getTestContext();			

			// Get Map for only failed test cases

			IResultMap resultMap = context.getFailedTests();

			// Get method detail of failed test cases

			Collection<ITestResult> failedMethods = resultMap.getAllResults();

			if(failedMethods.size()>0)
			{
				if (suiteTable == null) {
					suiteTable = new PdfPTable(new float[] { .20f, .20f,.30f, .30f });
					suiteTable.setWidthPercentage(100f);
					constructSuiteNameHeader(suiteTable, context.getSuite().getName().toString());

				}
				constructTestNameHeader(suiteTable, context.getName().toString());
			// Failed Test Header
			contructFailureTypeHeader(suiteTable, "Failed Test Cases");

			// Column Headers
			constructTestDetailsColumnHeaders(suiteTable);

			constructResultData(suiteTable, failedMethods);
			}

			// Get Map for only Skipped test cases

			resultMap = context.getSkippedTests();

			Collection<ITestResult> skippedMethods = resultMap.getAllResults();
			
			if(skippedMethods.size()>0)
			{
				if (suiteTable == null) {
					suiteTable = new PdfPTable(new float[] { .20f, .20f,.30f, .30f });
					suiteTable.setWidthPercentage(100f);
					constructSuiteNameHeader(suiteTable, context.getSuite().getName().toString());

				}
			// Skipped Test Header
			contructFailureTypeHeader(suiteTable, "Skipped Test Cases");
			// Column Headers
			constructTestDetailsColumnHeaders(suiteTable);

			constructResultData(suiteTable, skippedMethods);
			}			
		} 
		if(suiteTable!=null)
		{
		suiteTable.setSpacingBefore(15f);
		try {
			this.document.add(suiteTable);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		suiteTable.setSpacingAfter(15f);
		}
		
	}
	/**
	 * This method will create the Column Header of Failure Type
	 * 
	 * @param suiteTable
	 * @param header
	 */
	public void contructFailureTypeHeader(PdfPTable suiteTable, String header) {
		cell = null;
		p = new Paragraph(header, new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
		cell = new PdfPCell(p);
		cell.setColspan(5);
		cell.setMinimumHeight(20f);
		if (header.contains("Skipped")) {
			cell.setBackgroundColor(new Color(241, 196, 15));
		} else {
			cell.setBackgroundColor(new Color(231, 76, 60));
		}
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		suiteTable.addCell(cell);
	}

	/**
	 * This method will create the Column Header of Test Details
	 * 
	 * @param suiteTable
	 */
	public void constructTestDetailsColumnHeaders(PdfPTable suiteTable) {
		cell = null;
		// Column Headers
		cell = new PdfPCell(new Paragraph("Class Name"));
		cell.setBackgroundColor(new Color(127, 140, 141));
		suiteTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Test Case Name"));
		cell.setBackgroundColor(new Color(127, 140, 141));
		suiteTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Failure Reason"));
		cell.setBackgroundColor(new Color(127, 140, 141));
		suiteTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Screesnshot"));
		cell.setBackgroundColor(new Color(127, 140, 141));
		suiteTable.addCell(cell);
	}

	/**
	 * This method will create the Result data
	 * 
	 * @param suiteTable
	 * @param resultMethods
	 */
	public void constructResultData(PdfPTable suiteTable, Collection<ITestResult> resultMethods) {
		cell = null;
		for (ITestResult result : resultMethods) {

			String[] cPaths = result.getTestClass().getName().toString().split("\\.");
			int len = cPaths.length;
			String className = cPaths[len - 1];
			cell = new PdfPCell(new Paragraph(className));
			suiteTable.addCell(cell);

			String testName = result.getMethod().getMethodName();
			cell = new PdfPCell(new Paragraph(testName.toString()));
			suiteTable.addCell(cell);

			Throwable throwable = result.getThrowable();
			if (throwable != null) {
				Paragraph excep = new Paragraph(
						new Chunk(throwable.toString(), new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))
								.setLocalGoto("" + throwable.hashCode()));
				cell = new PdfPCell(excep);
				suiteTable.addCell(cell);
			} else {
				suiteTable.addCell(new PdfPCell(new Paragraph("")));
			}
			boolean isScreenshotFound =false;
			for(Map<String,Object> map : TravelNEXTMobileBaseTestSuite.failedTestScreenShotPaths)
			{
				if((map.get("TestName").equals(result.getTestContext().getName()))
					&& (map.get("MethodName").equals(testName))  
					&& (map.get("ClassName").equals(className)))
					{
					isScreenshotFound=true;
					Image img=null;
					try {
					img = (Image)map.get("Image");
					cell = new PdfPCell(img,true);
					suiteTable.addCell(cell);
					}catch(Exception e)
					{
						suiteTable.addCell(new PdfPCell(new Paragraph("")));
					}
					break;
					}
			}
			if(!isScreenshotFound)
			{
				suiteTable.addCell(new PdfPCell(new Paragraph("")));
			}

		}
	}

	/**
	 * This method will create the Column Header of Test Name
	 * 
	 * @param suiteTable
	 * @param testName
	 */
	public void constructTestNameHeader(PdfPTable suiteTable, String testName) {
		cell = null;

		p = new Paragraph("Test Name : " + testName,
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
		cell = new PdfPCell(p);
		cell.setColspan(5);
		cell.setMinimumHeight(20f);
		cell.setBackgroundColor(new Color(21, 67, 96));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		suiteTable.addCell(cell);

	}

	/**
	 * This method will create the Column Header of Suite Name
	 * 
	 * @param suiteTable
	 * @param suiteName
	 */
	public void constructSuiteNameHeader(PdfPTable suiteTable, String suiteName) {
		cell = null;

		p = new Paragraph(suiteName, new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD, new Color(252, 252, 252)));
		cell = new PdfPCell(p);
		cell.setColspan(5);
		cell.setMinimumHeight(20f);
		cell.setBackgroundColor(new Color(21, 67, 96));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		suiteTable.addCell(cell);
	}
	
	
	/**
	 * Map the suite results
	 * 
	 * @author surajit.sarkar
	 *
	 */
	protected static class SuiteResult {
		private final String suiteName;
		private final List<TestResult> testResults = Lists.newArrayList();

		public SuiteResult(ISuite suite) {
			suiteName = suite.getName();
			for (ISuiteResult suiteResult : suite.getResults().values()) {
				testResults.add(new TestResult(suiteResult.getTestContext()));
			}
		}

		public String getSuiteName() {
			return suiteName;
		}

		public List<TestResult> getTestResults() {
			return testResults;
		}
	}

	/**
	 * Map the Test Results
	 * 
	 * @author surajit.sarkar
	 *
	 */
	protected static class TestResult {

		protected static final Comparator<ITestResult> RESULT_COMPARATOR = new Comparator<ITestResult>() {
			@Override
			public int compare(ITestResult o1, ITestResult o2) {
				int result = o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
				if (result == 0) {
					result = o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
				}
				return result;
			}
		};

		private final String testName;
		private final List<ClassResult> totalTestResults;
		private final List<ClassResult> passedTestResults;
		private final List<ClassResult> failedConfigurationResults;
		private final List<ClassResult> failedTestResults;
		private final List<ClassResult> skippedConfigurationResults;
		private final List<ClassResult> skippedTestResults;

		private final int passedTestCount;
		private final int totalTestCount;
		private final long duration;
		private final int failedTestCount;
		private final int skippedTestCount;

		public TestResult(ITestContext context) {
			testName = context.getName();

			Set<ITestResult> failedConfigurations = context.getFailedConfigurations().getAllResults();
			Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
			Set<ITestResult> skippedConfigurations = context.getSkippedConfigurations().getAllResults();
			Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();

			Set<ITestResult> passedTests = context.getPassedTests().getAllResults();
			Set<ITestResult> totalTests = context.getPassedTests().getAllResults();

			failedConfigurationResults = groupResults(failedConfigurations);
			failedTestResults = groupResults(failedTests);
			skippedConfigurationResults = groupResults(skippedConfigurations);
			skippedTestResults = groupResults(skippedTests);
			totalTestResults = groupResults(totalTests);

			passedTestResults = groupResults(passedTests);

			failedTestCount = failedTests.size();

			skippedTestCount = skippedTests.size();

			passedTestCount = passedTests.size();

			totalTestCount = skippedTestCount + passedTestCount + failedTestCount;

			duration = context.getEndDate().getTime() - context.getStartDate().getTime();

		}

		/**
		 * Map Group Results
		 * 
		 * @param results
		 * @return
		 */
		protected List<ClassResult> groupResults(Set<ITestResult> results) {
			List<ClassResult> classResults = Lists.newArrayList();
			if (!results.isEmpty()) {
				List<MethodResult> resultsPerClass = Lists.newArrayList();
				List<ITestResult> resultsPerMethod = Lists.newArrayList();

				List<ITestResult> resultsList = Lists.newArrayList(results);
				Collections.sort(resultsList, RESULT_COMPARATOR);
				Iterator<ITestResult> resultsIterator = resultsList.iterator();
				assert resultsIterator.hasNext();

				ITestResult result = resultsIterator.next();
				resultsPerMethod.add(result);

				String previousClassName = result.getTestClass().getName();
				String previousMethodName = result.getMethod().getMethodName();
				while (resultsIterator.hasNext()) {
					result = resultsIterator.next();

					String className = result.getTestClass().getName();
					if (!previousClassName.equals(className)) {
						// Different class implies different method
						assert !resultsPerMethod.isEmpty();
						resultsPerClass.add(new MethodResult(resultsPerMethod));
						resultsPerMethod = Lists.newArrayList();

						assert !resultsPerClass.isEmpty();
						classResults.add(new ClassResult(previousClassName, resultsPerClass));
						resultsPerClass = Lists.newArrayList();

						previousClassName = className;
						previousMethodName = result.getMethod().getMethodName();
					} else {
						String methodName = result.getMethod().getMethodName();
						if (!previousMethodName.equals(methodName)) {
							assert !resultsPerMethod.isEmpty();
							resultsPerClass.add(new MethodResult(resultsPerMethod));
							resultsPerMethod = Lists.newArrayList();

							previousMethodName = methodName;
						}
					}
					resultsPerMethod.add(result);
				}
				assert !resultsPerMethod.isEmpty();
				resultsPerClass.add(new MethodResult(resultsPerMethod));
				assert !resultsPerClass.isEmpty();
				classResults.add(new ClassResult(previousClassName, resultsPerClass));
			}
			return classResults;
		}

		public String getTestName() {
			return testName;
		}

		public List<ClassResult> getFailedConfigurationResults() {
			return failedConfigurationResults;
		}

		public List<ClassResult> getFailedTestResults() {
			return failedTestResults;
		}

		public List<ClassResult> getSkippedConfigurationResults() {
			return skippedConfigurationResults;
		}

		public List<ClassResult> getSkippedTestResults() {
			return skippedTestResults;
		}

		public List<ClassResult> getPassedTestResults() {
			return passedTestResults;
		}

		public List<ClassResult> gettotalTestResults() {
			return totalTestResults;
		}

		public int getPassedTestCount() {
			return passedTestCount;
		}

		public int gettotalTestCount() {
			return totalTestCount;
		}

		public long getDuration() {
			return duration;
		}

		public int getFailedTestCount() {
			return failedTestCount;
		}

		public int getSkippedTestCount() {
			return skippedTestCount;
		}

	}

	/**
	 * Map Class Results
	 * 
	 * @author surajit.sarkar
	 *
	 */
	protected static class ClassResult {
		private final String className;
		private final List<MethodResult> methodResults;

		public ClassResult(String className, List<MethodResult> methodResults) {
			this.className = className;
			this.methodResults = methodResults;
		}

		public String getClassName() {
			return className;
		}

		public List<MethodResult> getMethodResults() {
			return methodResults;
		}
	}

	/**
	 * Map Method results
	 * 
	 * @author surajit.sarkar
	 *
	 */
	protected static class MethodResult {
		private final List<ITestResult> results;

		public MethodResult(List<ITestResult> results) {
			this.results = results;
		}

		public List<ITestResult> getResults() {
			return results;
		}
	}
}
