package org.example.stepdefinitions.autoru;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.*;
import org.example.pages.autoru.BrandPage;
import org.example.pages.autoru.MainPage;
import org.example.pages.autoru.ModelPage;
import org.example.pages.autoru.NativeFrame;
import org.testng.Assert;

public class AutoRuStepdefs {
    @Дано("пользователь переходит на сайт {string}")
    public void openSite(String arg0) {
        Selenide.open(arg0);
    }

    @Тогда("название страницы содержит {string}")
    public void pageTitle(String arg0) {
        NativeFrame nativeFrame = new NativeFrame();
        nativeFrame.closeFrame();
        Assert.assertTrue(Selenide.title().contains(arg0));
    }

    @Затем("пользователь сохраняет количество объявлений, отображаемых перед названием {string} автомобиля")
    public void saveAds(String nameOfBrand) {
        MainPage mainPage = new MainPage();
        mainPage.showAllBrands();
        mainPage.saveNumberOfAds(nameOfBrand);
        System.out.println("Всего объявлений: " + MainPage.numberOfAds);
    }

    @И("пользователь переходит на страницу с объявлениями {string} автомобилей из п.2")
    public void openBrandPage(String nameOfBrand) {
        MainPage mainPage = new MainPage();
        mainPage.openBrandPage(nameOfBrand);
    }

    @Тогда("отображается кнопка с текстом, содержащим количество объявлений из п.2")
    public void showsButtonWithCountOfModels() {
        BrandPage brandPage = new BrandPage();
        String buttonText = brandPage.buttonShowGetText();
        Assert.assertTrue(buttonText.contains(MainPage.numberOfAds));
    }

    @Затем("пользователь сохраняет количество объявлений конкретной {string} автомобиля")
    public void saveNumberOfCars(String nameOfModel) {
        BrandPage brandPage = new BrandPage();
        brandPage.saveNumberOfCars(nameOfModel);
        System.out.println("Число авто: " + BrandPage.numberOfCars);
    }

    @Затем("пользователь переходит на страницу {string} из предыдущего пункта")
    public void openModelPage(String nameOfModel) {
        BrandPage brandPage = new BrandPage();
        brandPage.openModelPage(nameOfModel);
    }

    @Тогда("отображается кнопка с текстом, содержащим количество объявлений из предыдущего пункта")
    public void showsButtonWithCountOfCars() {
        ModelPage modelPage = new ModelPage();
        String buttonText = modelPage.buttonShowGetText();
        Assert.assertTrue(buttonText.contains(BrandPage.numberOfCars));
    }
}

