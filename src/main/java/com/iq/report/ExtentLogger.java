package com.iq.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.iq.enums.ConfigProperties;
import com.iq.utils.PropertyUtils;
import com.iq.utils.ScreenshotUtils;

public final class ExtentLogger {

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
			ExtentManager.getExtentTest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot())
					.build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
			ExtentManager.getExtentTest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot())
					.build());
		} else {
			fail(message);
		}
	}	

	public static void skip(String message, boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
			ExtentManager.getExtentTest().skip(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot())
					.build());
		} else {
			skip(message);
		}
	}	

}
