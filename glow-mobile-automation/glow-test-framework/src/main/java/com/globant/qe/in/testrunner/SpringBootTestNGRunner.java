package com.globant.qe.in.testrunner;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.util.ResourceUtils;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class SpringBootTestNGRunner implements CommandLineRunner {

	public static void testNGXMLRunner(String args[]) throws FileNotFoundException {
		SpringApplication app = new SpringApplication(SpringBootTestNGRunner.class);
		app.setBannerMode(Banner.Mode.OFF);
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(ResourceUtils.getFile(args[0]).getAbsolutePath());
		testng.setTestSuites(suites);
		testng.run();
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
