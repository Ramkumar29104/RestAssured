package Day03;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	//@Test
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","AaJma5u4QT5C3VSR7CLDcD2Pt8Wacp8SIYEaj7eerGUXgw0mVeIAjntFM38")
			.log().all();
	}
	
	@Test(priority = 1)
	void testGetCookie() {
		Response res = given()
							.when()
								.get("https://www.google.com/");
		String cookie = res.getCookie("AEC");
		System.out.println("Value of cookie : " + cookie);
			
	}
	
	@Test(priority = 2)
	void testGetAllCookies() {
		Response res = given()
							.when()
								.get("https://www.google.com/");
		Map<String, String> cookies = res.getCookies();
		System.out.println(cookies.keySet());
		
		for(String k : cookies.keySet()) {
			String cookie = res.getCookie(k);
			System.out.println(k + " : "+ cookie);
		}
			
	}
}
