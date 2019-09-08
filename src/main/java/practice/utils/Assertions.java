package practice.utils;

import practice.BE.models.EmployeeResponse;
import feign.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import practice.BE.models.EmployeeResponseUpdateCreate;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Component
public class Assertions {

    @Step("Compare that the response status is equal to the 200")
    public void checkResponseCodeAllOk(Response response) {
        assertThat(response.status()).isEqualTo(HttpStatus.SC_OK);
    }

    @Step("Compare that the {0} is equal to the {1}")
    public void compareIfEqual(String injected, String expected) {
        assertThat(injected).isEqualTo(expected);
    }

    @Step("Check if exist")
    public void checkExist(EmployeeResponseUpdateCreate e, List<EmployeeResponse> employees) {
        assertThat(employees).as("Employee wasnt found").contains(e.toEmployeeResponse());
    }

    @Step("Check if string {0} contains string {1}")
    public void checkIfContain(String s1, String s2) {
        assertThat(s1).as("String %s doesnt contain string %s", s1, s2).contains(s2);
    }

}
