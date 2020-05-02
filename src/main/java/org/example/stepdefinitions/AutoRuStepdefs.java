package org.example.stepdefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.*;
import org.example.pages.autoru.BrandPage;
import org.example.pages.autoru.MainPage;
import org.example.pages.autoru.ModelPage;
import org.example.pages.autoru.NativeFrame;
import org.testng.Assert;

public class AutoRuStepdefs {
    private MainPage mainPage = new MainPage();
    private BrandPage brandPage = new BrandPage();

    @Дано("пользователь переходит на сайт {string}")
    public void openSite(String siteUrl) {
        Selenide.open(siteUrl);
    }

    @Тогда("название страницы содержит  {string}")
    public void pageTitleContains(String pageTitle) {
        new NativeFrame().closeFrame();
        Assert.assertTrue(Selenide.title().contains(pageTitle), "Некорректное наименование страницы");
    }

    @Затем("пользователь сохраняет количество объявлений, отображаемых перед названием {string} автомобиля")
    public void saveAds(String nameOfBrand) {
        mainPage.showAllBrands();
        mainPage.saveNumberOfAds(nameOfBrand);
    }

    @И("пользователь переходит на страницу с объявлениями {string} автомобилей из п.2")
    public void openBrandPage(String nameOfBrand) {
        mainPage.openBrandPage(nameOfBrand);
    }

    @Тогда("отображается кнопка с текстом, содержащим количество объявлений из п.2")
    public void showsButtonWithCountOfModels() {
        String buttonText = brandPage.buttonShowGetText();
        Assert.assertTrue(buttonText.contains(MainPage.numberOfAds), "Некорректное количество объявлений на кнопке");
    }

    @Затем("пользователь сохраняет количество объявлений конкретной {string} автомобиля")
    public void saveNumberOfCars(String nameOfModel) {
        brandPage.saveNumberOfCars(nameOfModel);
    }

    @Затем("пользователь переходит на страницу {string} из предыдущего пункта")
    public void openModelPage(String nameOfModel) {
        brandPage.openModelPage(nameOfModel);
    }

    @Тогда("отображается кнопка с текстом, содержащим количество объявлений из предыдущего пункта")
    public void showsButtonWithCountOfCars() {
        ModelPage modelPage = new ModelPage();
        String buttonText = modelPage.buttonShowGetText();
        Assert.assertTrue(buttonText.contains(BrandPage.numberOfCars), "Некорректное количество объявлений на кнопке");
    }
}

