package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {

	@Test
	public void TC1() {

//		Base URL
		RestAssured.baseURI = "http://localhost:3001/";

//		Posting the data
		Response postRes = RestAssured.given().contentType(ContentType.JSON)
				.body("{\n" + "    \"name\" : \"Logan\",\n" + "    \"age\" : 30\n" + "}").post("/User");

//		Get data
		Response getData = RestAssured.given().get("/User/4").then().statusCode(200).extract().response();

		assertEquals(postRes.statusCode(), 201);
		assertEquals(getData.statusCode(), 200);
		assertEquals(getData.jsonPath().getString("id"), "4");
		assertEquals(getData.jsonPath().getString("name"), "Mohan");

	}

}
