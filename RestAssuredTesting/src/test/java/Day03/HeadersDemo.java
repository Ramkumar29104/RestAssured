package Day03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
		@Test
		void testHeaders() {
			
			given()
			
			.when()
				.get("https://www.google.com/")
			
			.then()
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding","gzip");
		}
		
		@Test(priority = 1)
		void testGetHeader() {
			String headerName = "Content-Type";
			Response res = given()
								.when()
									.get("https://www.google.com/");
			String header = res.getHeader(headerName);
			System.out.println(headerName +  " : " + header);
				
		}
		
		@Test(priority = 2)
		void testGetAllHeaders() {
			Response res = given()
								.when()
									.get("https://www.google.com/");
			Headers headers = res.getHeaders();
			
			for(Header hd : headers) {
				System.out.println(hd.getName() + " : " + hd.getValue());
			}
				
		}
	

}
