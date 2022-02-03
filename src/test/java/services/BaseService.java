package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	public static RequestSpecification request;
	public static Response response;
	public static int size;
	
	@BeforeSuite
	public void prerun() throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/config.properties"));
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		RestAssured.baseURI="https://"+prop.getProperty("server")+"/"+prop.getProperty("resources");
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
		
		request = RestAssured.given().log().all().accept(ContentType.JSON)
					.contentType(ContentType.JSON);
	}
	
	@AfterMethod
	public void afterRun()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}
	
	@AfterSuite
	public void afterSuiteRun()
	{
		System.out.println("Total number of issues in the response body: "+size);
	}

}
