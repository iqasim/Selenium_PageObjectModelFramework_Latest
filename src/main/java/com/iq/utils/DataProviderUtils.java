package com.iq.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.iq.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {}
	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testCaseName = m.getName();
		if(list.isEmpty()) {
			list = ExcelUtils.getTestManager(FrameworkConstants.getTestDataSheet());
		}

		List<Map<String, String>> testCaseList = new ArrayList<>();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testCaseName) &&
					list.get(i).get("execute").equalsIgnoreCase("yes")){
				testCaseList.add(list.get(i));
			}
		}
		return testCaseList.toArray();
	}
}