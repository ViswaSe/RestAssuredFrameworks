package steps;

import java.io.File;

import hooks.BaseRequest;
import io.cucumber.java.en.And;

public class UpdateJiraIssue extends BaseRequest{
	
	@And("Update the issue using the filename as {string}")
	public void add_the_stored_issue_key_to_the_request(String filename)
	{
		request = request.body(new File("./data/"+filename));
	}
	
	@And("Place the request to update the issue using chaining")
	public void place_the_request_to_update_the_issue_using_chaining()
	{
		response = request.pathParam("issue_key", issueKey)
			.put("issue/{issue_key}");
	}

}
