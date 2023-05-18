package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {
	
	@Test
	public void TC1() {

//		Base URL
		RestAssured.baseURI = "http://localhost:3001/";

//		Posting the data
		Response delReq = RestAssured.given().delete("/User/4");


		assertEquals(delReq.statusCode(), 200);
	}
	
}
