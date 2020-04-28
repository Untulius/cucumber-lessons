package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NativeFrame {
    private SelenideElement frameClose = Selenide.$(By.xpath("(//div[contains(@class, 'Modal__closer')])[5]"));

    public void closeFrame() {
        if (frameClose.exists()) {
            frameClose.click();
        }

    }

}
