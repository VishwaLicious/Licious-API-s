package com.licious.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SampleTest 
{
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in:3001";
		RestAssured.basePath="/cart/v1";
	}
	
	@Test
	public void test()
	{
		RestAssured.given().
		log().
		all().
		when().get("/get-cart").
		then().
		log().
		all();
			
	}
	
	
	
	

}
