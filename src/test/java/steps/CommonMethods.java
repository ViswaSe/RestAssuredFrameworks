package steps;

import hooks.BaseRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CommonMethods extends BaseRequest {
	
	@Given("Add the necessary request specification")
	public void add_the_necessary_request_specification()
	{
		request = given().accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.log().all();
	}

	@Then("Validate the status code of the response as {int}")
	public void validate_the_status_code_of_the_response(int expectedStatusCode)
	{
		response = response.then().assertThat().statusCode(expectedStatusCode).extract().response();
	}
	
	@And("Validate the content type of the response")
	public void validate_the_content_type_of_the_response()
	{
		response = response.then().assertThat().contentType(ContentType.JSON).extract().response();
	}
	
	@And("Print the response body and status code")
	public void print_the_response_body_and_status_code()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}
}
