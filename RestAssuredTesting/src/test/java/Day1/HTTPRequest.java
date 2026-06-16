package Day1;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {
	
	public int id;

    @Test(priority = 1)
	void getUsers() {
    	
    	
    	 given()
         
         .when()
             .get("https://fakestoreapi.com/products")

         .then()
             .statusCode(200)
             //.body("id", equalTo(1))
             .log().all();
    }
    
    @Test(priority=2)
    void createUser() {
    	
    	HashMap data = new HashMap();
    	data.put("userId",2);
    	data.put("title","Michael");
    	System.out.println(data);
    	
    	
    	id = given()
    		.contentType("application/json")
    		.body(data)
  
        .when()
            .post("https://jsonplaceholder.typicode.com/albums")
            .jsonPath().getInt("id");
    }
    
    @Test(priority = 3,dependsOnMethods = {"createUser"})
    void updateUser() {
    	
    	HashMap data = new HashMap();
    	data.put("userId",3);
    	data.put("title","Jackson");
    	
    	
    	given()
    		.contentType("application/json")
    		.body(data)
  
        .when()
            .put("https://jsonplaceholder.typicode.com/albums/" + id)
            
        .then()
        	.statusCode(200)
        	.log().all();
    }
    
    @Test(priority = 4,dependsOnMethods = {"createUser"})
    void deletUser() {
    	given()
    	
    	.when()
    		.delete("https://jsonplaceholder.typicode.com/albums/"+id)
    	.then()
    		.statusCode(200)
    		.log().all();
    }
}
