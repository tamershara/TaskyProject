package com.qacart.tasky.mocker;

import io.qameta.allure.Step;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TodosMocker {

    @Step
    public static void mockTodosForRegularUser() {
        stubFor(get(urlEqualTo("/api/todos?page=1&limit=5")).willReturn(aResponse().withBodyFile("todos_regualr_user.json")));
    }
}
