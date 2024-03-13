package Tasks;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;


public class ResponseSuccessLogin implements Task {

    private ValidatableResponse json;

    public static ResponseSuccessLogin deUsuario() {


        return Tasks.instrumented(ResponseSuccessLogin.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= LoginUsser.response.then().statusCode(HttpStatus.SC_OK).log().all();

    }
}
