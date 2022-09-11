package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationStep {
    @Step("Open the main page")
    public void openMainPage(String url){
        open(url);
    }

    @Step("Searching for a {repo}")
    public void repositorySearch(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Click on the repository {repo}")
    public void repositoryClick(){
        $("a[href='/selenide/selenide").click();

    }
    @Step("Open the issues tab")
    public void openIssuesTab(){
        $("#issues-tab").click();

    }
    @Step("Check the issue name")
    public void checkIssueName(String name){
        $("#issue_1927_link").shouldHave(text(name));

    }


}
