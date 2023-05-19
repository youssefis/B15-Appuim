package step_defs;

import io.cucumber.java.en.*;

public class EcomStepDef {

    @Given("user launched the ecommerce application")
    public void user_launched_the_ecommerce_application() {
        System.out.println("Lunching App");
    }

    @When("user logs in with valid username")
    public void user_logs_in_with_valid_username() {
        System.out.println("Logging in");
    }

    @Then("user should see the list of products")
    public void user_should_see_the_list_of_products() {
        System.out.println("Validating the list of products");
    }

}
