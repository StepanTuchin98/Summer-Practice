package practice.FE.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import practice.FE.pages.MainPage.MainPage;
import practice.utils.Assertions;
import ru.yandex.qatools.allure.annotations.Step;

import static practice.utils.TestConstants.productValue;

@Component
public class MainPageSteps {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private Assertions assertions;

    @Step("Search some element {0}")
    public void openMainPage(String uiAddress) {
        mainPage.initializePage(uiAddress);
    }

    @Step("Search some element {0}")
    public void searchProduct(String product) {
        mainPage.search(product);
    }

    @Step("check product is valid")
    public void checkProductValid() {
        String headerEl = mainPage.getProductHeaderContent();
        assertions.checkIfContain(headerEl, productValue);
    }
}
