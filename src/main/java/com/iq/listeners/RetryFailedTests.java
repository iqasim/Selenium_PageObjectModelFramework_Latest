package com.iq.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.iq.enums.ConfigProperties;
import com.iq.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int maxRetries = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count<maxRetries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
