package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    String issueName = "Add caching API into standard API";
    String repository = "selenide/selenide";
    String url = "https://github.com";
    @Feature("Issue in repository")
    @Story("Create Issue")
    @Owner("ksenn")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Check the issue exists - Lambda steps")
    @Test
    public void testLambdaStep() {


        step("Open the main page", () -> {
            open(url);
        });
        step("Searching fot the repository " + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        });
        step("Clicking on the repository  " + repository, () -> {
            $("a[href='/selenide/selenide").click();
        });
        step("Open the Issues tab", () -> {
            $("#issues-tab").click();
        });
        step("Check the issueName equals " + issueName, () -> {
            $("#issue_1927_link").shouldHave(text(issueName));
        });
    }

    @Feature("Issue in repository")
    @Story("Create Issue")
    @Owner("ksenn")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Check the issue exists - Annotations")
    @Test
    public void annotationTest(){
        AnnotationStep steps = new AnnotationStep();
        steps.openMainPage(url);
        steps.repositorySearch(repository);
        steps.repositoryClick();
        steps.openIssuesTab();
        steps.checkIssueName(issueName);


    }


}
