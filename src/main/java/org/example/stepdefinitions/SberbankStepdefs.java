package org.example.stepdefinitions;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.*;
import org.example.pages.sberbank.SelectDepositPage;
import org.example.pages.sberbank.TopMenu;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class SberbankStepdefs {
    @Дано("пользователь переходит на сайт  {string}")
    public void openSite(String arg0) {
        Selenide.open(arg0);
    }

    @Тогда("название страницы содержит {string}")
    public void pageTitle(String arg0) {
        Assert.assertTrue(Selenide.title().contains(arg0));
    }

    @Затем("пользователь через верхнее меню переходит во {string}")
    public void menuDeposits(String arg0) {
        TopMenu topMenu = new TopMenu();
        topMenu.selectTopMenu(arg0);
        topMenu.selectSubMenu("Вклады");
    }

    @Когда("пользователь переходит на вкладку {string}")
    public void selectDeposit(String arg0) {
        new SelectDepositPage().selectSubMenu(arg0);
    }

    @Тогда("отображаются 4 чек-бокса")
    public void checkboxesView(List<String> dataTable) {
        SelectDepositPage selectDepositPage = new SelectDepositPage();
        Selenide.switchTo().frame(selectDepositPage.getIframeChoice());
        for (String element : dataTable) {
            selectDepositPage.getCheckbox(element).shouldBe(Condition.enabled);
        }
    }

    @И("установлен чекбокс {string}")
    public void checkboxIsChecked(String checkboxName) {
        SelectDepositPage selectDepositPage = new SelectDepositPage();
        selectDepositPage.getCheckbox(checkboxName).shouldBe(Condition.checked);
    }

    @И("отображается 3 вклада")
    public void depositsView(List<String> dataTable) {
        SelectDepositPage selectDepositPage = new SelectDepositPage();
        Assert.assertTrue(selectDepositPage.getDeposits().texts().containsAll(dataTable));
    }

    @Когда("пользователь выбирает чек-боксы")
    public void checkboxesCheck(List<String> dataTable) {
        SelectDepositPage selectDepositPage = new SelectDepositPage();
        for (String element : dataTable) {
            selectDepositPage.getCheckbox(element).click();
        }
    }

    @Тогда("исчезают вклады Сохраняй и Пополняй. Остался только {string}")
    public void depositCheck(String depositName) {
        SelectDepositPage selectDepositPage = new SelectDepositPage();
        selectDepositPage.getDeposits()
                .shouldHaveSize(1)
                .shouldHave(CollectionCondition.texts(depositName));
    }

    @Затем("пользователь нажимает на кнопку Подробнее вклада Управляй")
    public void buttonDetails() {
        new SelectDepositPage().ButtonDetailsClick();
    }

    @Тогда("в новом окне открылось окно с названием {string}")
    public void newWindow(String windowTitle) {
        Assert.assertTrue(Selenide.title().contains(windowTitle));
    }

    @И("на странице отображается надпись {string}")
    public void textOnPage(String text) {
        Selenide.$(By.xpath(".//*[text()='" + text + "']")).shouldBe(Condition.exist);
    }

}
