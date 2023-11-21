package getRequest;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Post {
	
	@Test
	public void test_01()
	{
		//Map <String, Object> map=new HashMap<String, Object>();
		
//		map.put("name", "S Emp1");
//		map.put("job", "Tester");
		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "S Emp1");
		request.put("job", "Tester");

		System.out.println(request);
	}

}
