package com.w2a.APITestingFramework.testcases;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.listerners.ExtentListeners;
import com.w2a.APITestingFramework.setup.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class , dataProvider = "data" )
	public void validateCustomerAPIWithVSK(Hashtable<String, String> data)
	
	{
		
		
		Response response = CreateCustomerAPI.sendPOSTRequestToCustomerAPIWithValidAPI(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	}
	
	@Test(dataProviderClass = DataUtil.class , dataProvider = "data" )
	public void InValidCustomerAPIWithVSK(Hashtable<String, String> data)
	
	{
		
		
		Response response = CreateCustomerAPI.sendPOSTRequestToCustomerAPIWithInValidAPI(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	

}
