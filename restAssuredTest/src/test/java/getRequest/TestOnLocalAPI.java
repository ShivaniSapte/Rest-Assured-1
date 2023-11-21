package getRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class TestOnLocalAPI {

//	@Test
	public void get()
	{
		baseURI = "http://localhost:3000/";
		given().get("/users")
		.then().statusCode(200).log().all();
		
	}
	
	//@Test(priority = 2)
	public void post()
	{
		JSONObject request = new JSONObject();
		request.put("firstName", "Auto3");
		request.put("lastName", "Emp");
		request.put("subjectId", "3");
		
		baseURI = "http://localhost:3000";
		
		given() 
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(request.toJSONString())
		
		.when()
		   .post("/users")
		
		.then()
		   .statusCode(201)
		   .log().all();
		
	}
	
	@Test(priority = 3)
	void testPostUsingHashmap()
	{
		HashMap data = new HashMap();
		data.put("fistName", "Auto4");
		data.put("lastName", "Emp");
		data.put("subjectId", "3");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/users")
			
		.then()
			.statusCode(201)
			.body("firstName", equals("Auto4"))
			.body("lastName", equals("Emp"))
			.body("subjectId", equals("3"))
			.header("content-type","application/json; charset=utf-8")
			.log().all();
		
	}
	
	@Test(priority = 4)
	void delete()
	{
		when()
		   .delete("http://localhost:3000/users/7")
		.then()
		   .statusCode(200);
	}
	
	
}
