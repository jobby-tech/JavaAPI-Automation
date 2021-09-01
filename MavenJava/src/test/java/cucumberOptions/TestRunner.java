package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(      //Annotation which take the feature file location
		
		features ="src/test/java/features",
		glue = "stepDefinitions"    // parameter to define the stepdefinition files
		)
public class TestRunner {
	
	

}
