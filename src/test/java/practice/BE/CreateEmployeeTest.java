package practice.BE;

import practice.BE.models.EmployeeResponse;
import practice.BE.models.EmployeeResponseUpdateCreate;
import practice.BE.steps.EmployeeSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import practice.ConfigurationMain;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.List;

import static practice.utils.TestConstants.*;


@ContextConfiguration(classes = ConfigurationMain.class)
@Features("Employee")
@Stories("Employee")
@Test
public class CreateEmployeeTest extends AbstractTestNGSpringContextTests {

    @Value("${server.address}")
    private String addressServer;

    @Autowired
    private EmployeeSteps employeeSteps;


    @Test(groups = {"BETestsGroup", "CreateEmployee"})
    @Title("Check correct creation")
    public void checkEmployeeCreated() throws IOException {
        EmployeeResponseUpdateCreate e = employeeSteps.creteUser(someName, someSalary, someAge);
        List<EmployeeResponse> employeeList = employeeSteps.getAllEmployee();
        employeeSteps.checkEmployee(e, employeeList);
    }

    @Test(groups = {"BETestsGroup", "CreateEmployee"})
    @Title("Check correct updating")
    public void checkEmployeeUpdated() throws IOException {
        List<EmployeeResponse> employeeList = employeeSteps.getAllEmployee();
        int lastId = employeeList.get(employeeList.size() - 1).getId();
        EmployeeResponseUpdateCreate newE = employeeSteps.updateEmployee(lastId, someName, someSalary, someAge);
        employeeSteps.checkUpdatedEmployee(lastId, newE);
    }
}
