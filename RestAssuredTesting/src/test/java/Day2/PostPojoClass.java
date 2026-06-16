package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PostPojoClass {
	
	@Test
	void testPostUsingPojo() {
		PojoGettingRequest data = new PojoGettingRequest();
		data.setId("5");
		data.setName("Visa");
		data.setLocation("Neyveli");
		data.setPhone("8974568789");
		
		String[] coursesArray  = {"C","C++"};
		data.setCourses(coursesArray);
		
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
	
	@Test
	void testPostUsingExternalJSON() throws FileNotFoundException {
		
		File f = new File("C:\\Users\\Asus\\eclipse-workspace\\RestAssuredTesting\\src\\main\\resources\\body.json");
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/courses")
		.then()
			.statusCode(201)
			.body("name",equalTo("Aravind"))
			//.header("Content-Type","application/json; charset=utf-8")
			.log().all();	
	}
}
