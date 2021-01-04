package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

import com.w2a.APITestingFramework.listerners.ExtentListeners;

public class TestUtil {

	public static boolean jsonHasKey(String json, String key)
	
	{
		JSONObject object = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presense of the Key  " + key);
		return object.has(key);
		
	}
	
	public static String getJsonKeyValue(String json, String key)
	
	{
		JSONObject object = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the value of the Key  " + key);
		return object.get(key).toString();
	}
}
