package org.example.stepdefinitions.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ModelPage {
    private SelenideElement buttonShow = Selenide.$(By.xpath(".//span[@class='ButtonWithLoader__content']"));


    public String buttonShowGetText() {
        return buttonShow.getText();
    }
}
