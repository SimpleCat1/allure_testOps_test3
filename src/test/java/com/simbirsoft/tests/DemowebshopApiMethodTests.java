package com.simbirsoft.tests;

import com.simbirsoft.config.Layer;
import com.simbirsoft.config.Microservice;
import com.simbirsoft.data.AddWishApiData;
import com.simbirsoft.lombok.LombokUserData;
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

import static com.simbirsoft.filters.CustomLogFilter.customLogFilter;
import static com.simbirsoft.specs.Specs.methodRequest;
import static com.simbirsoft.specs.Specs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("api")
public class DemowebshopApiMethodTests extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем api добавления товара")
    @AllureId("12611")
    @DisplayName("Добавление товара")
    @Tag("critical")
    @Microservice("staging")
    @Story("Добавление товара api")
    @Feature("Добавление товара")
    @Epic("Неавторизованный пользователь")
    @Owner("SimplePerson")
    @Test
    void addingProductToTheCart() {
        step("Добавляем товар", () -> {
            AddWishApiData data = new AddWishApiData();

            LombokUserData response = given()
                    .filter(customLogFilter().withCustomTemplates())
                    .spec(methodRequest(data.url, data.contentType, data.body))
                    .when()
                    .post()
                    .then()
                    .spec(responseSpec(data.statusCode))
                    .log().body().extract().as(LombokUserData.class);

            assertEquals(data.textSuccessBuy, response.isSuccess());
            assertEquals(data.textAnswer, response.getMessage());
            assertEquals(data.textCountItem, response.getUpdatetopcart());
        });
    }
}
