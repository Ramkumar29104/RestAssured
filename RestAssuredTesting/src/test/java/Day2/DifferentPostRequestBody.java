package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DifferentPostRequestBody {
	
	public String id;	
	
	
	//HashMap
	//@Test(priority = 1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("id", "4");
		data.put("name", "Visa");
		data.put("location", "Neyveli");
		data.put("phone", "8974568789");
		
		String[] coursesArray  = {"C","C++"};
		
		data.put("courses",coursesArray);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/courses")
		.then()
			.statusCode(201)
			.body("name",equalTo("Visa"))
			//.header("Content-Type","application/json; charset=utf-8")
			.log().all();		
	}
	
	@Test(priority = 4, enabled = true)
	void testDelete() {
		given()
		
		.when()
			.delete("http://localhost:3000/courses/4")
		.then()
			.statusCode(200);
	}
	
	//Post using org.json library
	//@Test(priority = 3)
	void testPostUsingOrgJson() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Kalai1");
		data.put("location", "MAdurai1");
		data.put("phone", "8225986588");
		
		String[] courses = {"Banking","Java"};
		data.put("courses", courses);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/courses")
		.then()
			.statusCode(201)
			.body("name",equalTo("Kalai1"))
			//.header("Content-Type","application/json; charset=utf-8")
			.log().all();	
	}
}








