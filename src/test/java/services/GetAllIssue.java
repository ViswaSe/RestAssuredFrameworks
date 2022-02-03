package services;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllIssue extends BaseService {
	
	@Test
	public void getAllIssue()
	{
		response = request.queryParam("jql", "project = \"RA\"")
		.queryParam("fields","issue,key,summary,description")
		.when()
		.get("search")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.extract().response();
		
		//To print the total number of issues in jira board
		size = response.jsonPath().getList("issues.key").size();
	}

}
