package practice.FE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.ConfigurationMain;
import practice.FE.steps.MainPageSteps;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static practice.utils.TestConstants.SomeProduct;

@ContextConfiguration(classes = ConfigurationMain.class)
@Features("Employee")
@Stories("Employee")
@Test
public class SearchTest extends AbstractTestNGSpringContextTests {

    @Autowired
    MainPageSteps mainPageSteps;

    @Value("${ui.address}")
    private String uiAddress;

    @BeforeMethod(groups = {"FETestsGroup", "Search"})
    public void beforeTestsPageInitialization() throws IOException {
        mainPageSteps.openMainPage(uiAddress);
    }

    @AfterMethod(groups = {"FETestsGroup", "Search"})
    public void afterCloseBrowser() {
        close();
    }

    @Test(groups = {"FETestsGroup", "Search"})
    @Title("Search an element and verify it")
    public void checkSearch() {
        mainPageSteps.searchProduct(SomeProduct);
        mainPageSteps.checkProductValid();
    }
}
