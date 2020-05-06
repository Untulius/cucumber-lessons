package org.example.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.example.config.ConfigReader;
import org.example.config.PropertiesConfigReader;
import org.example.pages.bspbru.LoginPage;
import org.example.pages.bspbru.OverviewPage;
import org.example.pages.bspbru.SmsPage;
import org.example.pages.bspbru.TopMenu;
import org.openqa.selenium.By;
import org.testng.Assert;

/*
Переделать автотест из 8-го задания блока «Автоматизации тестирования вебприложений» с использованием библиотеки Cucumber
 */

public class BspbRuStepdefs {
    private OverviewPage overviewPage = new OverviewPage();
    private ConfigReader configReader = new PropertiesConfigReader();

    @Дано("пользователь открывает сайт {string}")
    public void openSite(String siteUrl) {
        Selenide.open(siteUrl);
    }

    @Тогда("открывается форрма ввода логина и пароля")
    public void loginFormOpens() {
        Selenide.$(By.xpath("//form[@action='/auth/login']")).shouldBe(Condition.visible);
    }

    @Затем("пользователь входит в систему под учетной записью")
    public void loginFormEnter() {
        new LoginPage().login(configReader.getValue("login"), configReader.getValue("pass"));
    }

    @Тогда("отображается форма двухфакторнаой аутентификации")
    public void smsFormOpens() {
        Selenide.$(By.xpath("//form[@action='/auth/otp']")).shouldBe(Condition.visible);
    }

    @Затем("пользователь вводит в поле ввода код подтверждения и нажимает кнопку \"Войти\"")
    public void smsFormEnter() {
        new SmsPage().enterCode(configReader.getValue("code"));
    }

    @Тогда("осуществляется вход в систему")
    public void authSuccess() {
        Assert.assertTrue(Selenide.title().contains("Старт - Интернет банк"), "Некорректное наименование страницы");
    }

    @Затем("пользователь переходит через верхнее меню в раздел \"Обзор\"")
    public void menuChange() {
        new TopMenu().selectTopMenu("overview");
    }

    @Тогда("открывается страница {string}")
    public void pageOpens(String pageName) {
        Assert.assertTrue(Selenide.title().contains(pageName), "Некорректное наименование страницы");
    }

    @И("на странице отображается блок {string} с указанием суммы в формате \"123 456 789.00 ₽\"")
    public void checkAmount(String text) {
        overviewPage.getFinfreedom().shouldHave(Condition.text(text));
        overviewPage.getAmount().should(Condition.matchText("\\d{0,3}\\s\\d{0,3}\\s\\d{1,3}\\.\\d{2}\\s."));
    }

    @Затем("пользователь наводит курсор на сумму в блоке \"Финансовая свобода\"")
    public void moveCursor() {
        overviewPage.moveCursor();
    }

    @Тогда("появляется надпись {string} с указанием суммы в формате \"123 456 789.00 ₽\"")
    public void checkMyAssets(String text) {
        overviewPage.getMyAssets().shouldHave(Condition.text(text));
        overviewPage.getMyAssets().should(Condition.matchText("\\d{0,3}\\s\\d{0,3}\\s\\d{1,3}\\.\\d{2}\\s."));
    }

}
