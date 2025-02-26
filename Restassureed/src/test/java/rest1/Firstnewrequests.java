package rest1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Firstnewrequests {
	
	
	@Test
	void request()
	{
		given()
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test
	void putrequest()
	{
		HashMap data = new HashMap();
		data.put("name","rohith");
		data.put("job", "trainer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all();
	}

}
