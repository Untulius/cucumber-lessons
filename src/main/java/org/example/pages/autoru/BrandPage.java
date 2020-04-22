package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BrandPage {
    private SelenideElement buttonShow = Selenide.$(By.xpath(".//span[@class='ButtonWithLoader__content']"));
    public static String numberOfCars;

    public String buttonShowGetText() {
        return buttonShow.getText();
    }

    public void saveNumberOfCars(String nameOfModel) {
        SelenideElement carsCount = Selenide.$(By.xpath(".//a[.='" + nameOfModel + "']/following-sibling::div"));
        numberOfCars = carsCount.getText();
    }

    public void openModelPage(String nameOfModel) {
        Selenide.$(By.xpath(".//a[.='" + nameOfModel + "']")).click();
    }
}
