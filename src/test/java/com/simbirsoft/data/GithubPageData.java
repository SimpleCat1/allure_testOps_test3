package com.simbirsoft.data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GithubPageData {
    public String url = "https://github.com";
    public String textForSearch = "eroshenkoam/allure-example";
    public String textIssues = "#66";
    public String numberIssues = "span.opened-by";
    public SelenideElement inputSearch = $("input[type='text']");
    public SelenideElement hrefRepository = $("a[href='/eroshenkoam/allure-example']");
    public SelenideElement elementIssues = $("a[id='issues-tab']");
}
