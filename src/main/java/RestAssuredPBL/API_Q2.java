package RestAssuredPBL;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class API_Q2 {

//	Get method
	@Test
	public void TC2() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.given().get("/api/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8))
				.body("data[4].first_name", equalTo("George")).body("data.first_name", hasItems("George", "Rachel"));
	}

}
