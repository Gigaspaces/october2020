package com.olympus.model;

import bloomberg.BLOOMBERG_TZERO_OUT;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

public class TablesCreator {

    private static String generateString() {
        return UUID.randomUUID().toString().substring(0, 11);
    }

    public static class BLOOMBERG_TZERO_OUT_TABLE {
        private static BLOOMBERG_TZERO_OUT firstEntry;

        public static String create = "CREATE TABLE BLOOMBERG_TZERO_OUT (\n" +
                "ID_BB_PARSEKEY VARCHAR(2000000),\n" +
                "EXCH_CODE VARCHAR(2000000),\n" +
                "NAME VARCHAR(2000000),\n" +
                "CRNCY VARCHAR(2000000),\n" +
                "FLEX_ID VARCHAR(2000000),\n" +
                "ID_BB_GLOBAL VARCHAR(40),\n" +
                "ID_SEDOL1 VARCHAR(12),\n" +
                "ID_SEDOL2 VARCHAR(12),\n" +
                "SECURITY_TYP VARCHAR(2000000),\n" +
                "EQY_SH_OUT VARCHAR(2000000),\n" +
                "REGION VARCHAR(2000000),\n" +
                "DDATE DATE,\n" +
                "ID_BB_GLOBAL_COMPANY VARCHAR(2000000)\n" +
                ");";

        public static String randomInsert() {
            return String.format("INSERT INTO BLOOMBERG_TZERO_OUT (ID_BB_PARSEKEY, " +
                            "EXCH_CODE, " +
                            "NAME, " +
                            "CRNCY, " +
                            "FLEX_ID, " +
                            "ID_BB_GLOBAL, " +
                            "ID_SEDOL1, " +
                            "ID_SEDOL2, " +
                            "SECURITY_TYP, " +
                            "EQY_SH_OUT, " +
                            "ID_BB_GLOBAL_COMPANY, " +
                            "DDATE, " +
                            "REGION) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                    generateString(), generateString(), generateString(), generateString(),
                    generateString(), generateString(), generateString(), generateString(),
                    generateString(), generateString(), generateString(), generateString()/*, generateString()*/);
            //todo add date
        }

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
}
