package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testResponseCode()
	{
		Response resp = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/");
		
		int code = resp.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code,200);
		System.out.println(resp.asString());
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getTime());
		
	}
	
	

}
