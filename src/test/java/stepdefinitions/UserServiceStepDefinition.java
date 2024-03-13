package stepdefinitions;

import Tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class UserServiceStepDefinition {


    @When("the user sends a request to the create user service")
    public void theUserSendsRequestCreateUserService(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(LoginUsser.successful(dataTable));
    }

    @When("the user sends a request to get user by user name")
    public void theUserSendsARequestToGetUserByUserName(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(GetUsser.ofPetStore(dataTable));
    }
    @When("the user sends a request to delete user by user name")
    public void theUserSendsARequestToDeleteUserByUserName(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(DeleteUsser.ofPetStore(dataTable));
    }
    @Then("The user should see a successful response from the user creation")
    public void theUserShouldSeeASuccessfulResponseFromTheUserCreation() {
      theActorInTheSpotlight().attemptsTo(ResponseSuccessLogin.deUsuario());

    }

    @Then("The user should see a successful response user by user name")
    public void theUserShouldSeeASuccessfulResponseUserByUserName() {
        theActorInTheSpotlight().attemptsTo(ResponseSuccessValidationName.deUsuario());
    }


    @Then("The user should see a successful response delete by user name")
    public void theUserShouldSeeASuccessfulResponseDeleteByUserName() {
        theActorInTheSpotlight().attemptsTo(ResponseSuccessDelete.deUsuario());
    }
}
