package com.w2a.APITestingFramework.testcases;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.APIs.DeleteCustomerAPI;
import com.w2a.APITestingFramework.listerners.ExtentListeners;
import com.w2a.APITestingFramework.setup.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFramework.utilities.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class , dataProvider = "data" )
	public void deleteCustomer(Hashtable<String, String> data)
	
	{
		Response response = DeleteCustomerAPI.sendDELETERequestToDeleteCustomerAPIWithValidAPI(data);
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		System.out.println(response.statusCode());
//		System.out.println("Gettinf ID from JSON Path" + response.jsonPath().get("id"));
//		String actualID = response.jsonPath().get("id").toString();
//		Assert.assertEquals(actualID, data.get("id"), "ID not Match");
		Assert.assertEquals(response.statusCode(), 200);
		
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID key is not present in the response"); 
		
		//Assert.assertTrue(object.has("id"), "ID key is not present in the response");
		
		String actual_ID = TestUtil.getJsonKeyValue(response.asString(), "id");
    	System.out.println(actual_ID);
 	    Assert.assertEquals(actual_ID, data.get("id"));
		System.out.println("Object Key value is: " + TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted Key value is: " + TestUtil.getJsonKeyValue(response.asString(), "deleted"));
		System.out.println("Presence check for object Key" + TestUtil.jsonHasKey(response.asString(), "object"));
		System.out.println("Presence check for deketed Key" + TestUtil.jsonHasKey(response.asString(), "deleted"));
	}
	
	
	

}
