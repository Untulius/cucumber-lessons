package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BrandPage {
    public static String numberOfCars;

    public String buttonShowGetText() {
        return Selenide.$(By.xpath(".//span[contains(@class, 'ButtonWithLoader__content') and contains(text(), 'Показать')]")).getText();
    }

    public void saveNumberOfCars(String nameOfModel) {
        SelenideElement carsCount = Selenide.$(By.xpath(".//a[.='" + nameOfModel + "']/following-sibling::div"));
        numberOfCars = carsCount.getText();
    }

    public void openModelPage(String nameOfModel) {
        Selenide.$(By.xpath(".//a[.='" + nameOfModel + "']")).click();
    }
}
