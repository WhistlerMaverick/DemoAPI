package RestAssuredPBL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Q1 {

//	Request and Response method
	@Test
	public void TC1() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
}
