package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ModelPage {
    private SelenideElement buttonShow = Selenide.$(By.xpath(".//span[contains(@class, 'ButtonWithLoader__content') and contains(text(), 'Показать')]"));


    public String buttonShowGetText() {
        return buttonShow.getText();
    }
}
