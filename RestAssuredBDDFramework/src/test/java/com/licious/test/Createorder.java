package com.licious.test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;

public class Createorder 
{
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in";
//		RestAssured.basePath="/cart/v1";
	}
	
	@Test
	public void verifycreateorder()
	{
		
         ValidatableResponse res = RestAssured.given().
		
		header("token", "tk_jkxogza5").
		
		multiPart("source","mobilesite").
	
		multiPart("cart_id" , "5b51e57a1a012293708792fd").
		
		multiPart("address_id","100500").
		
		multiPart("order_type","COD").
		
		multiPart("hub_id","2").
		
		when().
		
		post("/api/order/create/v3").
		
		then().
		 
	    statusCode(200) ; 
        
	}
	
  }
