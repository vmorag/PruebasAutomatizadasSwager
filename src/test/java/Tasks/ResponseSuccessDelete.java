package Tasks;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.http.HttpStatus;


public class ResponseSuccessDelete implements Task {

    private ValidatableResponse json;

    public static ResponseSuccessDelete deUsuario() {


        return Tasks.instrumented(ResponseSuccessDelete.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        json= DeleteUsser.response.then().statusCode(HttpStatus.SC_OK).log().all();
        System.out.println(json);
    }
}
