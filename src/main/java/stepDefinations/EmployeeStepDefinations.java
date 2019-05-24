package stepDefinations;

import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeStepDefinations {
	
	
	public Response response;
	public RequestSpecification httpRequest;

	@Before
	public void setUp() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

	}

	@Given("^The endpoint is already configured$")
	public void the_endpoint_is_already_configured() {
		httpRequest = RestAssured.given();
	}

	@When("^I get all employees$")
	public void i_get_all_employees() throws InterruptedException {
		response = httpRequest.request(Method.GET, "/employees");
		System.out.println(response);
		Thread.sleep(3000);
	}

	@Then("^I should have the status code \"([^\"]*)\"$")
	public void i_should_see_valid_status_code(String statusCode) {
		int code = response.getStatusCode();

		System.out.println("status code is: " + code);
		Assert.assertEquals(code, Integer.parseInt(statusCode));
	}

}
