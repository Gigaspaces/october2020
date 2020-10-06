package com.olympus.model;

import com.gigaspaces.internal.io.BootIOUtils;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

public class Generator {
    private static final int SIZE = 100;
    public static void main(String[] args) {
        String table = args[0];
        GigaSpace gigaSpace = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo")).create();
        Generator gen = new Generator();

        try {
            if(table.equals("FX_RATES"))
                gen.generateFxRates(gigaSpace);
            if(table.equals("FUTURES"))
                gen.generateFutures(gigaSpace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void generateFxRates(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        Random rand = new Random(System.currentTimeMillis());
        long startDate = 20200101;
        long endDate = 20200111;
//        long endDate = 20200601;
        BARRA_FX_RATES_WITH_MINOR_CURRENCIES[] entries = new BARRA_FX_RATES_WITH_MINOR_CURRENCIES[Long.valueOf(endDate - startDate).intValue()];
        for (String fxCode: codes) {
            for (long i = 0; i < endDate - startDate; i++) {
                BARRA_FX_RATES_WITH_MINOR_CURRENCIES one = new BARRA_FX_RATES_WITH_MINOR_CURRENCIES();
                one.setCURRENCY_CODE(fxCode);
                one.setDDATE(startDate + i);
                one.setFX_RATE(rand.nextDouble());
                one.setRF_RATE(rand.nextDouble());
                one.setRouting(Long.valueOf(i).intValue());
                entries[Long.valueOf(i).intValue()] = one;
            }
            gs.writeMultiple(entries);
        }
    }

    void generateFutures(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        Random rand = new Random(System.currentTimeMillis());
        REAL_TIME_FUTURES[] realTimeFutures = new REAL_TIME_FUTURES[SIZE];
        BigDecimal delta = new BigDecimal(0.001);
        for (String fxCode: codes) {
            for (int i = 0; i < SIZE; i++){
                REAL_TIME_FUTURES rtf = new REAL_TIME_FUTURES();
                long timestamp = rand.nextLong();
                Date d = new Date(timestamp);
                long date = d.getYear() + d.getMonth()*10000 + d.getDay() * 1000000;
                rtf.setCRNCY(fxCode);
                rtf.setDATA_DATE(date);
                rtf.setDATA_RECEIVED_TIMESTAMP(timestamp);
                rtf.setPX_YEST_DT(date -1);
                rtf.setTICKER(fxCode + " elec " + date);
                rtf.setLAST_PRICE_TIME_TODAY_REALTIME(timestamp - rand.nextInt(10000));
                rtf.setLAST_TRADE_PRICE_TIME_TODAY_RT(rtf.getLAST_PRICE_TIME_TODAY_REALTIME() - rand.nextInt(100));
                rtf.setLAST_PRICE(new BigDecimal(rand.nextDouble()));
                BigDecimal vol = new BigDecimal(rand.nextLong());
                rtf.set_5_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol);
                rtf.set_20_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol.multiply(new BigDecimal(4)));
                rtf.set_30_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol.multiply(new BigDecimal(6)));
                rtf.setASK(rtf.getLAST_PRICE().add(delta));
                rtf.setBID(rtf.getLAST_PRICE().subtract(delta));
                rtf.setVOLUME(new BigDecimal(rand.nextInt()));
                rtf.setVOLUME_TDY(rtf.getVOLUME().longValue());
                rtf.setTRADING_DT_REALTIME(rtf.getDATA_DATE() - rand.nextInt(1));
                realTimeFutures[i] = rtf;
            }
            gs.writeMultiple(realTimeFutures);
        }
    }

    String[] loadFXCodes() throws IOException {
        List<String> result = new ArrayList<>();
        InputStream in = getClass().getResourceAsStream("/codes-all_csv.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        // read and skip header
        reader.readLine();
        String str;
        while ((str = reader.readLine()) != null) {

            String[] cols = str.split(",");
            if(cols.length>3)
                result.add(cols[2]);
//           else
//               System.out.println(str);
        }
        return result.toArray(new String[0]);
    }
}
