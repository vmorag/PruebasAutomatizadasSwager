package Tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import static utils.Endpoints.User;

public class GetUsser implements Task {

    public static Response response;
    private DataTable dataTable;

    public GetUsser(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static GetUsser ofPetStore(DataTable dataTable) {

        return Tasks.instrumented(GetUsser.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String username = dataTable.cell(0, 1);
        String url = User + username;
        response = Base.request.header("username",dataTable.cell(0,1))
                .when()
                .get(url);

    }
}
