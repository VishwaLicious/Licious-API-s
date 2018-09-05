package com.licious.test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;



public class Login 
 {
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in";
//		RestAssured.basePath="/api";
	}
	
	@DataProvider(name="credentials")
    public Object[][] getDataFromDataprovider()
	{
    return new Object[][] 
    	{
            {"arun.kumar@licious.in", "arun@123" },
            { "arunkumar@licious.in", "123456" },
            { "madan.k@gmail.com", "arun@123" },
            { "ankitharinsha@licious.in", "123456"}
        };

    }

	
	@Test(dataProvider = "credentials")

	public void verifyloginwithdiffcrds(String username , String password)

	{
		System.out.println();
		
		
        System.out.println("Username is " + username);
		
		System.out.println("password is " +password);
		
		Response res=RestAssured.given().
		
		          header("token", "tk_jkrxko98").
	
	              multiPart("email", username ).
		 
	              multiPart("password",password).
	
		when().
		
		       post("/api/login").
		
		then().
		
	           statusCode(200).
		
	           body("message",equalTo("Login Successfull")).

	    and().
	    
	           body("status",equalTo("success")).extract().response();
		
	           System.out.println("Response time is "+res.getTime());	
	 
	           System.out.println("Content-Type value:"+res.header("Content-Type"));
		
        	   System.out.println("Server value:" +res.header("Server"));
		
		
 }
	
	@Test
	public void verifybasicinfoofuser()
	{
		
        RestAssured.given().		
	          	header("token", "tk_jkrxko98").
             	multiPart("email","arun.kumar@licious.in").	
		        multiPart("password","arun@123").		
		when().		
	        	post("/api/login").		
		then().		 
	            statusCode(200).
	    
                body("data.customer_key",equalTo("c_jhx4tley")).
	    
         	    body("data.name",equalTo("Arunkumar")).
	    
	            body("data.email",equalTo("arun.kumar@licious.in"));
	
	        	System.out.println("Login API working successfully");
	  
		
	}
	
	
	
}