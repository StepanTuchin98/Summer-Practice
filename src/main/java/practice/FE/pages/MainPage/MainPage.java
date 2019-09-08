package practice.FE.pages.MainPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;

@Component
public class MainPage {
    private SelenideElement searchField = $("#global_search");
    private SelenideElement productHeader = $("#content > div > div.product_header");


    public void initializePage(String uiAddress) {
        open(uiAddress);
    }

    public void search(String searchElement) {
        searchField.setValue(searchElement).pressEnter();
    }

    public String getProductHeaderContent() {
        return productHeader.$(By.tagName("h1")).innerHtml();
    }
}
