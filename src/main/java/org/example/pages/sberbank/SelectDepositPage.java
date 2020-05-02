package org.example.pages.sberbank;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SelectDepositPage {

    private SelenideElement iframeChoice = Selenide.$(By.xpath("//div[@data-id='podobrat']//iframe"));
    private SelenideElement buttonDetails = Selenide.$(By.xpath(".//div[@id='depositSelection']//a[@data-test-id='Button-white'] "));

    public void buttonDetailsClick() {
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        Set<String> oldWindowsSet = webDriver.getWindowHandles();
        buttonDetails.click();
        String newWindow = (new WebDriverWait(webDriver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }

                );
        Selenide.switchTo().window(newWindow);
    }

    public SelenideElement getIframeChoice() {
        return iframeChoice;
    }

    public void selectSubMenu(String subMenuTitle) {
        Selenide.$(By.xpath(".//li[@class='tabs-container__tab']/a[.='" + subMenuTitle + "']")).click();
    }

    public SelenideElement getCheckbox(String checkboxName) {
        return Selenide.$(By.xpath("//div[@id='depositSelection']/descendant::div[.='" + checkboxName + "']/preceding-sibling::input"));
    }

    public ElementsCollection getDeposits() {
        return Selenide.$$(By.xpath(".//div[@id='depositSelection']//h3[@class='offered-products__header']"));
    }
}
