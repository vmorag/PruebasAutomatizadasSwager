package stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static utils.Constantes.BASE_SERVICIOS;

public class Base {

    public  static RequestSpecification request;

   @Before
    public void seCreaElRequestDeLaPeticionDelServicio() {
        request=given()
                .baseUri("https://petstore3.swagger.io/api/v3/")
               .contentType(ContentType.JSON)
               .log()
               .all();

    }



    @Before
    public void sePreparaElActor(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("viviana").whoCan(CallAnApi.at(BASE_SERVICIOS));

    }


}
