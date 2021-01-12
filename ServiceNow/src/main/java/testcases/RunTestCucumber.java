package testcases;

import cucumber.api.CucumberOptions;
import testng.api.base.ProjectSpecificMethods;

@CucumberOptions(features = "src/test/java/features",
					glue = "testcases",  //Step definition package name
					monochrome = true  //remove junk char
					)

public class RunTestCucumber extends ProjectSpecificMethods {

	
	public void setValues() {
		testCaseName = "Login using cucumber";
		testDescription = "Create new incident and validate the incident present in incodent page";
		nodes = "Incident";
		authors = "JP";
		category = "Smoke";

	}
}
