package com.licious.test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ProductAddToCart 
 {
     
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in";
//		RestAssured.basePath="";
	}
	
	
	@Test
	public void VerifyProductAddtoCart()
	{
     	RestAssured.given().
		
	        	header("token", "tk_jkrxko98").
		
	        	multiPart("customer_key","c_jhx4tley").
	
	        	multiPart("product_id","pr_57234a4f6f77b").
		
        		multiPart("hub_id","2").
		
        		multiPart("quantity","1").
		
		when().
		
	        	post("/api/cart/update/v2").
		
		then().
		 
	            statusCode(200).
	   
	            body("status",equalTo("success")).
	    
	            body("product_id",equalTo("pr_57234a4f6f77b")).
	    
	            body("quantity",equalTo("1"));
	
        		System.out.println("Product added successfully to cart ");
	
		
	}
	
}