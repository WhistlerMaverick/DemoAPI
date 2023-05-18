package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {

	@Test
	public void TC1() {

//		Base URL
		RestAssured.baseURI = "http://localhost:3001/";
		Response response = RestAssured.given().get("/User/1").then().statusCode(200).extract().response();
		int res = response.getStatusCode();
		assertEquals(res, 200);
		assertEquals(response.jsonPath().getString("id"),"1");
	}
	

}
