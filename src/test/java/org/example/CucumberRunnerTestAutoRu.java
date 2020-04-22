package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/main/resources/features.autoru",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"org/example/stepdefinitions/autoru"}
)
public class CucumberRunnerTestAutoRu extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void selenideConfigure() {
        Configuration.timeout = 5_000;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
