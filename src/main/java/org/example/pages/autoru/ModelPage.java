package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class ModelPage {
    public String buttonShowGetText() {
        return Selenide.$(By.xpath(".//span[contains(@class, 'ButtonWithLoader__content') and contains(text(), 'Показать')]")).getText();
    }
}
