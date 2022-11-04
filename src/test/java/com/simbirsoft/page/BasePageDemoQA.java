package com.simbirsoft.page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class BasePageDemoQA {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    @BeforeAll
    public static void helperDriver() {
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/",
                credentials.login(),
                credentials.password());
    }
}
