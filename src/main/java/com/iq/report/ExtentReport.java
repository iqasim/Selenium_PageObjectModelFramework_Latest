package com.iq.report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iq.constants.FrameworkConstants;
import com.iq.enums.CategoryTypes;
import com.iq.exceptions.InvalidInputOutputException;

public final class ExtentReport {

	private ExtentReport() {}

	private static ExtentReports extReports;

	public static void initReport() {

		if(Objects.isNull(extReports)) {
			extReports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setReportName("Imran Qasim");
			extReports.attachReporter(sparkReporter);
		}
	}

	public static void flushReport() {

		if(Objects.nonNull(extReports)) {
			try {
				extReports.flush();
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extReports.createTest(testCaseName));
	}

	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	public static void addCategories(CategoryTypes[] categories) {
		for(CategoryTypes temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}


}
