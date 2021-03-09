package com.iq.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.iq.annotation.FrameworkAnnotation;
import com.iq.report.ExtentLogger;
import com.iq.report.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.initReport();
		
	}

	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().
				getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
				
				//getMethod().
				//getAnnotation(FrameworkAnnotation.class).author());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentLogger.pass(result.getMethod().getMethodName()+" is passed.", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed.", true);
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped.", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * This is not used as of now
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * This is not used as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * This is not used as of now
		 */
	}
	
	

}
