package com.iq.constants;

import com.iq.enums.ConfigProperties;
import com.iq.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static final String TESTMANAGERFILEPATH = RESOURCEPATH+"/excel/TestManager.xlsx";
	private static final String TESTDATASHEET = "TESTDATA";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	
	private static String extentReportFilePath = "";

	public static String getTestManagerFilePath() {
		return TESTMANAGERFILEPATH;
	}

	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createExtentReportPath();
		}
		return extentReportFilePath;
	}

	private static String createExtentReportPath() {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getTestDataSheet() {
		return TESTDATASHEET;
	}

	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}
	

}
