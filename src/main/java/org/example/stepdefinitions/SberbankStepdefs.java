package org.example.stepdefinitions;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.*;
import org.example.pages.sberbank.SelectDepositPage;
import org.example.pages.sberbank.TopMenu;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class SberbankStepdefs {
    private SelectDepositPage selectDepositPage = new SelectDepositPage();

    @Дано("пользователь переходит на сайт  {string}")
    public void openSite(String siteUrl) {
        Selenide.open(siteUrl);
    }

    @Тогда("название страницы содержит {string}")
    public void pageTitle(String pageTitle) {
        Assert.assertTrue(Selenide.title().contains(pageTitle), "Некорректное наименование страницы");
    }

    @Затем("пользователь через верхнее меню переходит во {string}")
    public void menuDeposits(String menuTitle) {
        TopMenu topMenu = new TopMenu();
        topMenu.selectTopMenu(menuTitle);
        topMenu.selectSubMenu(menuTitle);
    }

    @Когда("пользователь переходит на вкладку {string}")
    public void selectDeposit(String depositName) {
        selectDepositPage.selectSubMenu(depositName);
    }

    @Тогда("отображаются 4 чек-бокса")
    public void checkboxesView(List<String> dataTable) {
        Selenide.switchTo().frame(selectDepositPage.getIframeChoice());
        for (String element : dataTable) {
            selectDepositPage.getCheckbox(element).shouldBe(Condition.enabled);
        }
    }

    @И("установлен чекбокс {string}")
    public void checkboxIsChecked(String checkboxName) {
        selectDepositPage.getCheckbox(checkboxName).shouldBe(Condition.checked);
    }

    @И("отображается 3 вклада")
    public void depositsView(List<String> dataTable) {
        Assert.assertTrue(selectDepositPage.getDeposits().texts().containsAll(dataTable), "Отображаются не все вклады");
    }

    @Когда("пользователь выбирает чек-боксы")
    public void checkboxesCheck(List<String> dataTable) {
        for (String element : dataTable) {
            selectDepositPage.getCheckbox(element).click();
        }
    }

    @Тогда("исчезают вклады Сохраняй и Пополняй. Остался только {string}")
    public void depositCheck(String depositName) {
        selectDepositPage.getDeposits()
                .shouldHaveSize(1)
                .shouldHave(CollectionCondition.texts(depositName));
    }

    @Затем("пользователь нажимает на кнопку Подробнее вклада Управляй")
    public void buttonDetails() {
        selectDepositPage.buttonDetailsClick();
    }

    @Тогда("в новом окне открылось окно с названием {string}")
    public void newWindow(String windowTitle) {
        Assert.assertTrue(Selenide.title().contains(windowTitle), "Некорректное наименование страницы");
    }

    @И("на странице отображается надпись {string}")
    public void textOnPage(String text) {
        Selenide.$(By.xpath(".//*[text()='" + text + "']")).shouldBe(Condition.exist);
    }

}
