package myTestRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:target/cucumberHtmlReport", "json:target/cucumber-report.json" }, 
	
		features = "/Users/leenikha/eclipse-workspace/cucumberAPI/src/main/java/features/employee.feature", 
		glue = { "stepDefinations" }
//		tags = {"@leena"}
		)
public class myRunner {

	
	
}
