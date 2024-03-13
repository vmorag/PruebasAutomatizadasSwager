package Tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import stepdefinitions.Base;

import static utils.Endpoints.User;

public class DeleteUsser implements Task {

    public static Response response;
    private DataTable dataTable;

    public DeleteUsser(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static DeleteUsser ofPetStore(DataTable dataTable) {

        return Tasks.instrumented(DeleteUsser.class,dataTable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String username = dataTable.cell(0, 1);
        String url = User + username;

        response = Base.request.header("username", username)
                .when()
                .delete(url);
    }
}
