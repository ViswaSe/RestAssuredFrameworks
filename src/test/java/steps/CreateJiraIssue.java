package steps;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import static org.hamcrest.Matchers.containsString;

import hooks.BaseRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CreateJiraIssue extends BaseRequest {
	
	@Given("Add the file for the create request using the filename as {string}")
	public void add_the_file_for_the_create_request_using_the_filename_as(String filename)
	{
		request = request.body(new File("./data/"+filename));
	}
	
	@And("Place the request for create jira issue")
	public void place_the_request_for_create_jira_issue()
	{
		response = request.when().post("issue");
	}
	
	@And("Store the issue key into a variable")
	public void store_the_issue_key_into_a_variable()
	{
		issueKey=response.jsonPath().get("key");
	}
	
	@And("Validate the below response")
	public void validate_the_below_response(Map<String,String> map)
	{
		for(Entry<String,String> eachEntry:map.entrySet())
		{
			response.then().assertThat().body(eachEntry.getKey(), containsString(eachEntry.getValue()));
		}
	}
}
