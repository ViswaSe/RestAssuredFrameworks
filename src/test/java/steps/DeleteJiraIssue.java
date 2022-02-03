package steps;

import hooks.BaseRequest;
import io.cucumber.java.en.And;

public class DeleteJiraIssue extends BaseRequest{
	
	@And("Place the request to delete the issue using chaining")
	public void place_the_request_to_delete_the_issue_using_chaining()
	{
		request.pathParam("issue_key", issueKey)
		.delete("issue/{issue_key}");
	}

}
