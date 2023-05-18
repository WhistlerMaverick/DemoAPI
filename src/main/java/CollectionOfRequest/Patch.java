package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch {

	@Test
	public void TC1() {

//		Base URL
		RestAssured.baseURI = "http://localhost:3001/";

//		Posting the data
		Response patchRes = RestAssured.given().contentType(ContentType.JSON)
				.body("{\n" + "    \"name\" : \"Akash Kannan\"\n" + "}").patch("/User/1");

//		Get data
		Response getData = RestAssured.given().get("/User/1").then().statusCode(200).extract().response();

		assertEquals(patchRes.statusCode(), 200);
		assertEquals(getData.statusCode(), 200);
		assertEquals(getData.jsonPath().getString("id"), "1");
		assertEquals(getData.jsonPath().getString("name"), "Akash Kannan");

	}

}
