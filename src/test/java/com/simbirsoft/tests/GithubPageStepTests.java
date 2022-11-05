package com.simbirsoft.tests;

import com.simbirsoft.data.GithubPageData;
import com.simbirsoft.page.BasePageDemoQA;
import com.simbirsoft.page.PageDemoQASteps;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class GithubPageStepTests extends BasePageDemoQA {
    PageDemoQASteps steps = new PageDemoQASteps();
    GithubPageData data = new GithubPageData();

    @Epic("Неавторизованный пользователь")
    @Feature("Проверка номера Isseus")
    @Story("Проверка номера Isseus в репозитории")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка номера Isseus в репозитории")
    @DisplayName("Проверка номера Isseus в репозитории")
    @Tag("critical")
    @Test
    public void LookForIssuesSelenideSteps() {
        step("Зайти на \"" + data.url + "\"", () -> {
            steps.openPage(data.url);
        });
        step("В header сайта в input ввести \"" + data.textForSearch + "\" и нажать Enter", () -> {
            steps.clickOnLocator(data.inputSearch).inputWords(data.inputSearch, data.textForSearch);
        });
        step("На странице repository results нажать на \"" + data.textForSearch + "\"", () -> {
            steps.clickOnLocator(data.hrefRepository);
        });
        step("Нажать на вкладку Issues", () -> {
            steps.clickOnLocator(data.elementIssues);
        });
        step("Найти Isseu с \"" + data.textIssues + "\" номером", () -> {
            steps.checkTextLocator(data.numberIssues, data.textIssues);
        });
    }
}

