package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put {

	@Test
	public void TC1() {

//		Base URL
		RestAssured.baseURI = "http://localhost:3001/";

//		Posting the data
		Response putRes = RestAssured.given().contentType(ContentType.JSON)
				.body("{\n" + "    \"id\" : 1,\n" + "    \"name\" : \"Akash RP\",\n" + "    \"age\" : 30\n" + "}")
				.put("/User/1");

//		Get data
		Response getData = RestAssured.given().get("/User/1").then().statusCode(200).extract().response();

		assertEquals(putRes.statusCode(), 200);
		assertEquals(getData.statusCode(), 200);
		assertEquals(getData.jsonPath().getString("id"), "1");
		assertEquals(getData.jsonPath().getString("name"), "Akash RP");

	}

}
