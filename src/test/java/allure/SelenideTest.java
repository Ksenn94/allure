package allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    public void testSelenideSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        String issueName = "Add caching API into standard API";

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide/selenide");
        $(".header-search-input").submit();
        $("a[href='/selenide/selenide").click();
        $("#issues-tab").click();
        $("#issue_1927_link").shouldHave(text(issueName));
    }

}
