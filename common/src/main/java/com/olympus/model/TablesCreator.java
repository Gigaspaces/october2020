package com.olympus.model;

import bloomberg.BLOOMBERG_TZERO_OUT;
import bloomberg.BLOOMBERG_TZERO_PX_OUT_ADJUSTED;
import bloomberg_fi.CORP_PFD_OUT;
import bloomberg_futures.SHARE_FUTURES_PRICING_RPX;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class TablesCreator {
    private static Random random = new Random();

    private static String generateUUIDString() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public static class BLOOMBERG_TZERO_OUT_TABLE {
        private static BLOOMBERG_TZERO_OUT firstEntry;

        public static BLOOMBERG_TZERO_OUT[] generate(int count) {
            BLOOMBERG_TZERO_OUT[] objects = new BLOOMBERG_TZERO_OUT[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                final Date date = Date.valueOf(localDateTime.toLocalDate().plusDays(count % (i + 1)));
                objects[i] = new BLOOMBERG_TZERO_OUT(date,
                        (i % 5) == 0 ? "SOME_REGION" : generateUUIDString(), generateUUIDString(), generateUUIDString(), generateUUIDString(),
                        generateUUIDString(), generateUUIDString(), generateUUIDString(), generateUUIDString(),
                        generateUUIDString(), generateUUIDString(), generateUUIDString(), generateUUIDString());

            }

            if (firstEntry == null) {
                firstEntry = objects[0];
            }
            return objects;
        }

        public static BLOOMBERG_TZERO_OUT getFirstEntry() {
            if (null == firstEntry) {
                generate(1);
            }
            return firstEntry;
        }

    }

    public static class CORP_PFD_OUT_TABLE {
        private static CORP_PFD_OUT firstEntry;
        private static Random random = new Random();

        public static CORP_PFD_OUT[] generate(int count) {
            CORP_PFD_OUT[] objects = new CORP_PFD_OUT[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                Date date = Date.valueOf(localDateTime.toLocalDate().plusDays(count % (i + 1)));
                objects[i] = new CORP_PFD_OUT(
                        generateUUIDString(), generateUUIDString(), generateUUIDString(), generateUUIDString(),
                        generateUUIDString(), generateUUIDString(), generateUUIDString(), generateUUIDString(),
                        (i % 5) == 0 ? "Pfd" : generateUUIDString(),
                        (i % 5) == 0 ? "US" : generateUUIDString(),
                        (i % 5) == 0 ? "N" : generateUUIDString(),
                        generateUUIDString(), generateUUIDString(), random.nextDouble(), date);

            }

            if (firstEntry == null) {
                firstEntry = objects[0];
            }
            return objects;
        }

        public static CORP_PFD_OUT getFirstEntry() {
            if (null == firstEntry) {
                generate(1);
            }
            return firstEntry;
        }
    }

    public static class BLOOMBERG_TZERO_PX_OUT_ADJUSTED_TABLE {
        private static BLOOMBERG_TZERO_PX_OUT_ADJUSTED firstEntry;

        public static BLOOMBERG_TZERO_PX_OUT_ADJUSTED[] generate(int count) {
            BLOOMBERG_TZERO_PX_OUT_ADJUSTED[] objects = new BLOOMBERG_TZERO_PX_OUT_ADJUSTED[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                Date date = Date.valueOf(localDateTime.toLocalDate().plusDays(count % (i + 1)));
                BLOOMBERG_TZERO_OUT bloomberg_tzero_out = BLOOMBERG_TZERO_OUT_TABLE.getFirstEntry();
                objects[i] = new BLOOMBERG_TZERO_PX_OUT_ADJUSTED(
                        ((i + 1) % 5) == 0 ? bloomberg_tzero_out.getDDATE() : date,
                        ((i + 1) % 5) == 0 ? bloomberg_tzero_out.getID_BB_GLOBAL() : generateUUIDString(),
                        generateUUIDString());
            }

            if (firstEntry == null) {
                firstEntry = objects[0];
            }
            return objects;
        }

        public static BLOOMBERG_TZERO_PX_OUT_ADJUSTED getFirstEntry() {
            if (null == firstEntry) {
                generate(1);
            }
            return firstEntry;
        }
    }

    public static class SHARE_FUTURES_PRICING_RPX_TABLE {
        public static SHARE_FUTURES_PRICING_RPX[] generate(int count) {
            SHARE_FUTURES_PRICING_RPX[] objects = new SHARE_FUTURES_PRICING_RPX[count];
            for (int i = 0; i < count; i++) {
                LocalDateTime localDateTime = LocalDateTime.now();
                final Date date = Date.valueOf(localDateTime.toLocalDate().minusDays(i % 20));
                objects[i] = new SHARE_FUTURES_PRICING_RPX(generateUUIDString(), generateUUIDString(), random.nextLong(), date);

            }
            return objects;
        }

    }

}
