package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class PageDemoQASteps {

    public PageDemoQASteps clickOnLocator(SelenideElement locator) {
        locator.scrollTo().click();
        return new PageDemoQASteps();
    }

    public void inputWords(SelenideElement locator, String text) {
        locator.setValue(text).pressEnter();
    }

    public void openPage(String text) {
        open(text);
    }

    public void checkTextLocator(String locator, String text) {
        $$(locator).findBy(text(text)).shouldHave(text(text));
    }
}
