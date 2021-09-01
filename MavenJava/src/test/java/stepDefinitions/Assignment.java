package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment {

	

	@Given("^start the script$")

	public void start_the_script(){

		System.out.println("script execution started");

	}

	

	@Then("^script execution in progress$")

	public void script_execution_in_progress (){

		System.out.println("script execution in progress");

	}

	

	@And("^Execution completed$")

	 public void Executioncompleted(){

		System.out.println("Execution completed");

	}


	
	
	
}
