import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Demo5_Get_verifybody
{
	@Test
	 void googleMapTestDetails()
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Goa");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	Assert.assertEquals(responseBody.contains("Goa"), true);   //to check weather city is available in  response or not
	 }
}
