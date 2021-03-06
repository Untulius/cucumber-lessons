package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.config.ConfigReader;
import org.example.config.PropertiesConfigReader;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/main/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"org/example/stepdefinitions"},
        tags = "@all"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void selenideConfigure() {
        ConfigReader configReader = new PropertiesConfigReader();
        Configuration.browser = configReader.getValue("browser");
        Configuration.timeout = 5_000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
