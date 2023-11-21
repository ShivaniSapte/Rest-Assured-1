package getRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestGet {

	@Test  
	void test_01()
	{
		get("https://reqres.in/api/users?page=2");
	
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7));
		
	}
	@Test
	void test_02()
	{
		given().get("https://reqres.in/api/users?page=2").then().body("data.first_name", hasItems("Lindsay"));

	}
	
	@Test
	public void test_03()
	{
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			log().all();
	}
	
}
