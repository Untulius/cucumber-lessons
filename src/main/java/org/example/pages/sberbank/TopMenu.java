package org.example.pages.sberbank;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class TopMenu {
    public void selectTopMenu(String menuTitle){
        Selenide.$(By.xpath(".//li[@class='lg-menu__item']/button[@aria-label='Меню " + menuTitle + "']")).doubleClick();
    }

    public void selectSubMenu(String subMenuTitle) {
        Selenide.$(By.xpath(".//li[@class='lg-menu__sub-item']/a[.='" + subMenuTitle + "']")).click();
    }
}
