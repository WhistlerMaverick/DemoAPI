package RestAssuredPBL;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class API_Q3 {

//	Post method
	@Test
	public void TC3() {
		RestAssured.useRelaxedHTTPSValidation();

		JSONObject request = new JSONObject();
		request.put("name", "kajal");
		request.put("job", "Engineer");
		System.out.println(request.toString());
		RestAssured.baseURI = "https://reqres.in";

		RestAssured.given().header("Content-Type", "application/json").body(request.toString()).when().post("/api/users").then()
				.statusCode(201).log().all();
	}

}
