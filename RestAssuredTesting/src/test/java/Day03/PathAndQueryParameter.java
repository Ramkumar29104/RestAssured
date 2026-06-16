package Day03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	//https://jsonplaceholder.typicode.com/todos?userId=1&id=7
	
	@Test
	void testPathAndQueryParameter() {
		
		given()
			.pathParam("myPath", "todos")		//path parameter
			.queryParam("userId", "1")
			.queryParam("id", "7")
		
		.when()
			.get("https://jsonplaceholder.typicode.com/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
}
