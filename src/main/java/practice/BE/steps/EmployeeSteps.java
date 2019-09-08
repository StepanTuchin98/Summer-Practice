package practice.BE.steps;

import practice.BE.clients.EmployeeClient;
import practice.BE.models.EmployeeRequest;
import practice.BE.models.EmployeeRequestUpdateCreate;
import practice.BE.models.EmployeeResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.BE.models.EmployeeResponseUpdateCreate;
import ru.yandex.qatools.allure.annotations.Step;
import practice.utils.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import static practice.utils.AllureUtils.getBodyAsString;
import static practice.utils.AllureUtils.saveText;
import static practice.utils.TestConstants.R;

@Component
public class EmployeeSteps {
    @Autowired
    private Assertions assertions;

    @Autowired
    private ObjMapper objMapper;

    @Autowired
    private EmployeeClient employeeClient;

    private static final TypeReference<List<EmployeeResponse>> PROJECT_TYPE_REF = new TypeReference<List<EmployeeResponse>>() {
    };

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Step("Create employee")
    public EmployeeResponseUpdateCreate creteUser(String name, Integer salary, Integer age) throws IOException {
        EmployeeRequestUpdateCreate employee = new EmployeeRequestUpdateCreate(name + random(), salary, age);
        Response response = employeeClient.createEmployee(employee);
        EmployeeResponseUpdateCreate employeeResp = objMapper.body2Object(response, EmployeeResponseUpdateCreate.class);
        saveText(R, getBodyAsString(response, employeeResp));
        assertions.checkResponseCodeAllOk(response);
        return employeeResp;
    }

    @Step("Search employee")
    public EmployeeResponse getSingleEmployee(Integer id) throws IOException {
        Response response = employeeClient.getSingleEmployee(id);
        EmployeeResponse employeeResp = objMapper.body2Object(response, EmployeeResponse.class);
        saveText(R, getBodyAsString(response, employeeResp));
        assertions.checkResponseCodeAllOk(response);
        return employeeResp;
    }

    @Step("Get all employees")
    public List<EmployeeResponse> getAllEmployee() throws IOException {
        Response response = employeeClient.getAllEmployee();
        List<EmployeeResponse> employees = objectMapper.readValue(Util.toString(response.body().asReader()), PROJECT_TYPE_REF);
        saveText(R, getBodyAsString(response, employees));
        assertions.checkResponseCodeAllOk(response);
        return employees;
    }

    @Step("Update employee")
    public EmployeeResponseUpdateCreate updateEmployee(Integer id, String name, Integer salary, Integer age) throws IOException {
        EmployeeRequestUpdateCreate employee = new EmployeeRequestUpdateCreate(name + random(), salary, age);
        Response response = employeeClient.updateEmployee(id, employee);
        EmployeeResponseUpdateCreate employeeResp = objMapper.body2Object(response, EmployeeResponseUpdateCreate.class);
        saveText(R, getBodyAsString(response, employeeResp));
        assertions.checkResponseCodeAllOk(response);
        return employeeResp;
    }

    @Step("Delete employee")
    public EmployeeResponse deleteEmployee(Integer id) throws IOException {
        Response response = employeeClient.deleteEmployee(id);
        EmployeeResponse employeeResp = objMapper.body2Object(response, EmployeeResponse.class);
        saveText(R, getBodyAsString(response, employeeResp));
        assertions.checkResponseCodeAllOk(response);
        return employeeResp;
    }

    @Step("Check employee")
    public void checkEmployee(EmployeeResponseUpdateCreate e, List<EmployeeResponse> employees) {
        assertions.checkExist(e, employees);
    }
    @Step("Check employee")
    public void checkUpdatedEmployee(Integer id, EmployeeResponseUpdateCreate e) throws IOException {
        assertions.compareIfEqual(e.getName(), getSingleEmployee(id).getEmployee_name());
    }

    public String random(){
        Instant instant = Instant.now();
        return Long.toString(instant.toEpochMilli());
    }
}




