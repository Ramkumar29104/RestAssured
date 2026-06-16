package Day04;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJSONResponseData {
	
	//@Test
	void TestJsonResponse() {
		
		//Approach1
		given()
			.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/courses")
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("[3].location",equalTo("Neyveli"));
	}	
	
	@Test
	void TestJsonResponse2() {
		
		//Approach2
		Response res = given()
			.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/courses");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		String name = res.jsonPath().get("[2].name").toString();
		Assert.assertEquals(name, "Kalai1");
				
	}	
}