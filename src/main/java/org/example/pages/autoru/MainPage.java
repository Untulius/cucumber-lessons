package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MainPage {
    public static String numberOfAds;

    public void showAllBrands() {
        Selenide.$(By.xpath(".//div[@class='IndexMarks__show-all']")).click();
    }

    public void saveNumberOfAds(String nameOfBrand) {
        SelenideElement modelsCount = Selenide.$(By.xpath(".//div[.='" + nameOfBrand + "']/following-sibling::div"));
        numberOfAds = modelsCount.getText();
    }

    public void openBrandPage(String nameOfBrand) {
        Selenide.$(By.xpath(".//div[.='" + nameOfBrand + "']")).click();
    }
}
