package data_driven_testing;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Add_new_employees
{
@Test(dataProvider="empdataprovider")
public void postNewEmployees(String ename,String esal,String eage)throws Exception

{
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	
	//request object
			RequestSpecification httpRequest=RestAssured.given();
			
			 //Request paylaod sending along with post request
			  JSONObject requestParams=new JSONObject();
			  
			  requestParams.put("name",ename);
			  requestParams.put("salary",esal);
			  requestParams.put("age",eage);
		
			  
			  httpRequest.header("Content-Type","application/json");
			  
			  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
			  
			  //Response object
			  Response response=httpRequest.request(Method.POST,"/create");
			  
			//capture response body to perform validation
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:" +responseBody);

			  
			  Assert.assertEquals(responseBody.contains(ename), true);
			  Assert.assertEquals(responseBody.contains(esal), true);

			  Assert.assertEquals(responseBody.contains(eage), true);
			 


			  //status code validation
			  int statusCode=response.getStatusCode();
			  System.out.println("Status code is: "+statusCode);
			  Assert.assertEquals(statusCode, 200);
			    

}


/*@DataProvider(name="empdataprovider")
String [][] getEmpData() throws IOException
{
	String path="C:\\Users\\sanjay\\Documents\\Book1.xlsx";
	 int rowCount = Utils1.getRowCount(path, "Sheet2");
	 int columnCount = Utils1.getCellCount(path, "Sheet2",1);
     
     String empdata[][] = new String [rowCount][columnCount];
     for (int i = 0;i <= rowCount; i++){
         for(int j = 0; j <= columnCount; j++)
         {
        	 empdata[i][j]=Utils1.getCellData(path, "Sheet2", i, j);
         }
     }
     return empdata;

}*/

@DataProvider(name = "empdataprovider")
public Object[][] testDataGenerator2() throws IOException 
{
	String path="C:\\Users\\sanjay\\Documents\\Book1.xlsx";
	FileInputStream file = new FileInputStream(path);

	XSSFWorkbook book = new XSSFWorkbook(file);
	XSSFSheet loginsheet = book.getSheet("Sheet2");
	int numberOfRow = loginsheet.getPhysicalNumberOfRows();
	Object [][] testData = new Object [numberOfRow][3];
	
	for(int i = 0; i < numberOfRow;i++)
	{
		XSSFRow row = loginsheet.getRow(i);
		XSSFCell ename = row.getCell(0);
		XSSFCell esal =row.getCell(1);
		XSSFCell eage =row.getCell(2);
	
		DataFormatter formatter = new DataFormatter();
		testData[i][0] = formatter.formatCellValue(ename);
		testData[i][1] = formatter.formatCellValue(esal);
		testData[i][2] = formatter.formatCellValue(eage);


		
		
	}
return testData;

}

}
