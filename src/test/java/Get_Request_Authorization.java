import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_Authorization
{
@Test
public void Authorization()
{
	//specify base url
			RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
			
			//Basic Authentication
			PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
			authscheme.setUserName("ToolsQA");
			authscheme.setPassword("TestPassword");
			
			RestAssured.authentication=authscheme;
	
			
			//request object
			RequestSpecification httpRequest=RestAssured.given();
			
			//response object
			Response response=httpRequest.request(Method.GET,"/");
			  
			    //print response in console window
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:" +responseBody);
			  
			  //status code validation
			  int statusCode=response.getStatusCode();
			  System.out.println("Status code is: "+statusCode);
			  Assert.assertEquals(statusCode, 200);
			  
}
}
