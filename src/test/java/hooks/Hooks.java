package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks extends BaseRequest{
	
	@Before
	public void setup() throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		String endpoint= "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		RestAssured.baseURI=endpoint;
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
	}
	
	@After
	public void tearDown(Scenario sc)
	{
		System.out.println(sc.getName()+":"+sc.getStatus());
	}

}
