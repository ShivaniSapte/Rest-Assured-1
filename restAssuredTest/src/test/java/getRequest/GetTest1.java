package getRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class GetTest1 {
	int id;
	//@Test
	void getUser()
	{
		//given().
		
		when().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("page", equalTo(2)).
			log().all();
		
	}
	
	@Test
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("name","Emp 1");
		data.put("job", "Testing");
		
		given().
			contentType(ContentType.JSON)
			.body(data).
		when().
			post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}

}
