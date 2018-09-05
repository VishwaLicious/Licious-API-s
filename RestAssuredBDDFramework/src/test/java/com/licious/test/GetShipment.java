package com.licious.test;



import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;

public class GetShipment
 {
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in:3001";
		RestAssured.basePath="/cart/v1";
	}
	
	@Test
	public void verifytheshipment()
	{
	
		ValidatableResponse res =RestAssured.given().
				queryParam("customer_key","c_jhx4tley").
				header("access-token","tk_jkwjbs3y").
				header("source" , "msite").
				when().
				get("/get-shipments").
				
				then().
				
				statusCode(200).
				
				body("statusCode",equalTo(200)).
				
				body("statusMessage" , equalTo("success")).
				
				body("data.shipment_summary[0].products[0].product_name" ,  equalTo("Chicken Breast (Boneless)"));
		
		
	
	}
	
}