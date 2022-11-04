package com.simbirsoft.tests;

import com.simbirsoft.data.AddWishApiData;
import com.simbirsoft.lombok.LombokUserData;
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

public class DemowebshopApiMethodTests extends TestBase {

    @Epic("Неавторизованный пользователь")
    @Feature("Добавление товара")
    @Story("Добавление товара api")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавление товара")
    @Description("Проверяем api добавления товара")
    @Tag("critical")
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
