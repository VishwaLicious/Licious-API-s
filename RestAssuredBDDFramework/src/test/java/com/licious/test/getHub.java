package com.licious.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class getHub
{ 
/*	
	@Test
    public void basicPingTest()
	{
		RestAssured.baseURI="node.licious.in";
		
        given().param("lat", "12.9712").param("&lng", "77.6409").header("token", "tk_25dc9c2c9399").when().get("/api/homepage/hub/get").then().assertThat().statusCode(200) ;
        System.out.println("pass ");
    }
	*/
	
	
	@Test
	public void Test_numberofcircuitsFor2017_season()
	{
		given().
		when().
		   get("http://ergast.com/api/f1/2017/circuits.json").
		   then().
		   statusCode(200).
		   and().
		   body("MRData.CircuitTable.Circuits.circuitId[0]",equalTo("albert_park")).
		   and().
		   header("Content-Length",equalTo("4551"));
		
	}
	
	
	
	@Test
	public void test_serviceablelatlong()
	{
		Response res = given().		
	    given().
		header("token","tk_25dc9c2c9399").
//		and().		
		queryParam("lat","12.9712").
		queryParam("lng","77.6409").
		
		when().
		get("http://node.licious.in/api/homepage/hub/get").
		then().statusCode(200).
		and().
		body("status", equalTo("success")).
		and().
		header("Content-Length",equalTo("583"))./*).log().all().*/
		extract().response();
		System.out.println(res);
		
		String resStr=res.asString();
		System.out.println(resStr );
		
		
		JsonPath jpath = new JsonPath(resStr);
		String hub = jpath.getString("hub"); 
	
		System.out.println(hub);
	}
	
	
	
}