package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setup.BaseTest;

import io.restassured.response.Response;



public class CreateCustomerAPI extends BaseTest{
	
	
	public static Response sendPOSTRequestToCustomerAPIWithValidAPI(Hashtable<String, String> data)
	
	{
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "").
				formParam("email", data.get("email")).formParam("description", data.get("description")).
				formParam("name", data.get("name")).
				post(config.getProperty("customerAPIEndPoint"));
		
		return response;
	}
	
	
public static Response sendPOSTRequestToCustomerAPIWithInValidAPI (Hashtable<String, String> data)
	
	{
		
	Response response = given().auth().basic(config.getProperty("validSecretKey"), "").
			formParam("email", data.get("email")).formParam("description", data.get("description")).
			formParam("name", data.get("name")).
			post(config.getProperty("customerAPIEndPoint"));
	
	return response;
	}

}
