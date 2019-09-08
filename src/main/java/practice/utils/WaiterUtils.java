package practice.utils;

import com.codeborne.selenide.impl.Waiter;
import com.google.common.base.Predicates;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WaiterUtils {

    @Step("Wait until the page loads")
    public static void wait(int count) {
        new Waiter().wait(getWebDriver(), Predicates.alwaysFalse(), count, 1000);
    }
}
