package org.example.pages.autoru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NativeFrame {
    private SelenideElement frameClose = Selenide.$(By.xpath("/html/body/div[3]/div/div/div[2]"));

    public void closeFrame() {
        if (frameClose.exists()) {
            frameClose.click();
        }

    }

}
