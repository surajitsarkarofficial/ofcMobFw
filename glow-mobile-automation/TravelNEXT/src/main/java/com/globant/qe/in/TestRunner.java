package com.globant.qe.in;

import java.io.FileNotFoundException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globant.qe.in.testrunner.SpringBootTestNGRunner;

@SpringBootApplication
public class TestRunner extends SpringBootTestNGRunner {

	public static void main(String args[]) throws FileNotFoundException {
		if (args.length > 0) {
			testNGXMLRunner(args);
		} else {
			testNGXMLRunner(new String[] { "test-project/src/main/resources/testng.xml" });
		}
	}
}
