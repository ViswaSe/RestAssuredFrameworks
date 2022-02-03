package hooks;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification request;
	public static Response response;
	public static String issueKey;
}
