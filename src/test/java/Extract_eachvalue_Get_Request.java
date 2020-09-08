import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Extract_eachvalue_Get_Request
{
	@Test
	void getweatherDetails()
	{
		//specify base url
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//response object
		Response response=httpRequest.request(Method.GET,"/Goa");
		
		//extracting all values in json format
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));

		System.out.println(jsonpath.get("Humidity"));

		System.out.println(jsonpath.get("WeatherDescription"));

		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));


		
		
		
		
		
	}
}
