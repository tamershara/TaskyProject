package com.qacart.tasky.utilites;

import java.time.Instant;

public final class RandomDataUtil {
    private RandomDataUtil() {}

    public static String getRandomEmail() {
        long currentTimeStamp = Instant.now().getEpochSecond();
        return "test" + currentTimeStamp + "automation@qacart.com";
    }
}
