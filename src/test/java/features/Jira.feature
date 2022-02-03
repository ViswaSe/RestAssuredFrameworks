Feature: JIRA - Atlassian.net

Scenario Outline: TS_001_Create a new JIRA issues using multiple files
Given Add the necessary request specification
And Add the file for the create request using the filename as "<filename>"
When Place the request for create jira issue
Then Validate the status code of the response as 201
And Validate the content type of the response
And Print the response body and status code
And Store the issue key into a variable
And Validate the below response
#datatable
|key|RA|

Examples:
|filename|
|createissue1.json|
|createissue2.json|

Scenario Outline: TS_002_Update the JIRA issue using chaining
Given Add the necessary request specification 
And Update the issue using the filename as "<filename>"
When Place the request to update the issue using chaining
Then Validate the status code of the response as 204
And Validate the content type of the response
And Print the response body and status code

Examples:
|filename|
|updateissue1.json|

Scenario: TS_003_Delete the JIRA issue using chaining
Given Add the necessary request specification
And Place the request to delete the issue using chaining
Then Validate the status code of the response as 204
And Validate the content type of the response
And Print the response body and status code
