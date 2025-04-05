package com.qacart.tasky.mocker;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TodosMocker {

    public static void mockTodosForRegularUser() {
        stubFor(
                get(urlEqualTo("/api/todos?page=1&limit=5"))
                        .willReturn(
                                aResponse()
                                        .withBodyFile("todos_regualr_user.json")
                        )
        );
    }
}
