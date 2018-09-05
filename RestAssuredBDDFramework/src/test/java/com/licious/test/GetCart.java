package com.licious.test;

//import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.assertion.BodyMatcher;
//import io.restassured.response.Response;

public class GetCart 

 {
 
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://node.licious.in:3001";
		RestAssured.basePath="/cart/v1";
	}
	 
	
//	@Test
	public void verifyemptycart()
	{
		RestAssured.given().
         		queryParam("customer_key","c_jhx4tley").
	        	header("access-token","tk_jkl8squs").
	         	header("source" , "msite").
		when().
	        	get("/get-cart").
		
		then().
		        statusCode(202).
		
	        	body("statusCode",equalTo(200)).
		
	          	body("statusMessage",equalTo("success"));
				
		
	}
	
	
	@Test
	public void verifythenumberofproductincart() 
	{
        
		RestAssured.given().
	          	queryParam("customer_key","c_jhx4tley").
	        	header("access-token","tk_jkl8squs").
	        	header("source" , "msite").
		when().
	         	get("/get-cart").
		
		then().
	        	statusCode(200).
		
		        body("data.products[0].product_name", equalTo("Chicken Breast (Boneless)"));
		
		        System.out.println("Chicken Breast (Boneless) is there in the cart ");
		
	}

	
//	@Test
	public void verifythe699freedeliverymessages()
	{

		
		RestAssured.given().
		
	       	queryParam("customer_key","c_jhx4tley").
    		header("access-token","tk_jkl8squs").
	    	header("source","msite").
			
		when().
	           get("http://node.licious.in:3001/cart/v1/get-cart").
		then().
               statusCode(200).
		       
               body("data.messages[0].message",equalTo("Free delivery on all orders above ₹599")).
		       
               body("data.messages[0].priority",equalTo(3)).
		       
               body("data.messages[0].type",equalTo("static")).
		       
               body("data.messages[0].style",equalTo("success_block")).
		       
               body("data.messages[0].condition",equalTo("free_delivery")).
		       
               body("data.messages[0].whichEvent",equalTo("general")).

		       log().all();
		
//		       body("statusCode", arg1);
		       
		
		/*
			      extract().response();
	    String response = res.asString();
	    System.out.println(response);*/
		
}
}