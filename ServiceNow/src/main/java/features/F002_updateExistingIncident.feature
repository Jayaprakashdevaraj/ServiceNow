Feature: Leaftab login functionality


@smoke
Scenario Outline: test the login function with positive credential
Given Enter username as <username>
And Enter password as <password>
And Click on the Login
And Enter search incident
And Select the required incident
And Search existing incident with incident number
Then Verify the new incident
#Then Homepage should be displayed as <user>

Examples:
|username|password|
|admin|India@123|
