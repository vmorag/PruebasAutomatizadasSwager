package Tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import static utils.Endpoints.Login;

public class LoginUsser implements Task {

    public static Response response;
    private DataTable dataTable;

    public LoginUsser(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static LoginUsser successful(DataTable dataTable) {

        return Tasks.instrumented(LoginUsser.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        response = Base.request
                .when()
                .queryParam("username", dataTable.cell(0,1))
                .queryParam("password", dataTable.cell(1,1))
                .get(Login);

    }
}
