package com.licious.test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

//import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

public class Genaratetoken 

 {
		
	@Test
	public void gettoken()
	{

	    Response res=given().
//	    		contentType(ContentType.JSON).
		//header("Content-Type","application/json").
	    		
		multiPart("deviceid", "19c0a82bb7a1ccc3").
//		multiPart("hashkey", "7c533a38a4791a5eea1c83d6ba44b149").
        multiPart("hashkey", "7c533a38a4791a5eea1c83d6ba44b149").
		when().
		post("https://node.licious.in/api/generate_token").
		
		then().
		extract().response();
	    String response = res.asString();
	    System.out.println(response);
	    
	    JsonPath jpath= new JsonPath(response);
	    final String token=jpath.get("token");
	    System.out.println("Token generated: "+ token);
	    

}
	
//	@Test
	public void test()
	{
		Response res = RestAssured.given().
				multiPart("deviceid", "19c0a82bb7a1ccc3").	
		    	 multiPart("hashkey", "7c533a38a4791a5eea1c83d6ba44b149").
		    	 post("https://node.licious.in/api/generate_token");
		
		System.out.println(res.asString());
				
		
	}
	
	
	
	
}
