package com.olympus.model;

import bloomberg.BLOOMBERG_TZERO_OUT;
import bloomberg_futures.SHARE_FUTURES_PRICING_RPX;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class TablesCreator {
    private static Random random = new Random();

    private static String generateString() {
        return UUID.randomUUID().toString().substring(0, 11);
    }

    public static class BLOOMBERG_TZERO_OUT_TABLE {
        private static BLOOMBERG_TZERO_OUT firstEntry;

        public static BLOOMBERG_TZERO_OUT[] generate(int count) {
            BLOOMBERG_TZERO_OUT[] objects = new BLOOMBERG_TZERO_OUT[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                final Date date = Date.valueOf(localDateTime.toLocalDate().plusDays(count % (i + 1)));
                objects[i] = new BLOOMBERG_TZERO_OUT(date,
                        generateString(), generateString(), generateString(), generateString(),
                        generateString(), generateString(), generateString(), generateString(),
                        generateString(), generateString(), generateString(), generateString());

            }
            firstEntry = objects[0];
            return objects;
        }

        public static BLOOMBERG_TZERO_OUT getFirstEntry() {
            return firstEntry;
        }
    }

    public static class SHARE_FUTURES_PRICING_RPX_TABLE {

        public static SHARE_FUTURES_PRICING_RPX[] generate(int count) {
            SHARE_FUTURES_PRICING_RPX[] objects = new SHARE_FUTURES_PRICING_RPX[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                final Date date = Date.valueOf(localDateTime.toLocalDate().minusDays(i % 20));
                objects[i] = new SHARE_FUTURES_PRICING_RPX(generateString(), generateString(), random.nextLong(), date);

            }
            return objects;
        }

    }
}
