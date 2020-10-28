package com.olympus.model;

import barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES;
import bloomberg.BLOOMBERG_TZERO_OUT;
import bloomberg_futures.SHARE_FUTURES_PRICING_RPX;
import bloomberg.BLOOMBERG_TZERO_PX_OUT_ADJUSTED;
import bloomberg_fi.CORP_PFD_OUT;
import bpipe_rt.PartitionedTable;
import bpipe_rt.REAL_TIME;
import bpipe_rt.REAL_TIME_FUTURES;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static final int SIZE = 100; //todo 100000 for real world test
    private static final Random rand = new Random(System.currentTimeMillis());
    private static final long startDate = 20200101;
    private static final long endDate = 20200601;
    private static final BigDecimal delta = new BigDecimal("0.001").setScale(6, BigDecimal.ROUND_FLOOR);

    public static void main(String[] args) {
        String table = args[0];
        GigaSpace gigaSpace = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo").lookupGroups("xap-15.5.1")).create();
        Generator gen = new Generator();

        try {
            if(table.equals("FX_RATES"))
                gen.writeBARRA_FX_RATES_WITH_MINOR_CURRENCIES(gigaSpace);
            if(table.equals("FUTURES")) {
                gen.writeREAL_TIME_FUTURES(gigaSpace);
                gen.writeREAL_TIME(gigaSpace);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feed(GigaSpace gigaSpace) throws IOException {
        writeBARRA_FX_RATES_WITH_MINOR_CURRENCIES(gigaSpace);
        writeREAL_TIME(gigaSpace);
        writeREAL_TIME_FUTURES(gigaSpace);
    }

    public void writeBARRA_FX_RATES_WITH_MINOR_CURRENCIES(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateBARRA_FX_RATES_WITH_MINOR_CURRENCIES(fxCode));
            break;
        }
    }

    public void writeREAL_TIME_FUTURES(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateREAL_TIME_FUTURES(fxCode));
            break;
        }
    }

    public void writeREAL_TIME(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateREAL_TIME(fxCode));
            break;
        }
    }

    public void writeBLOOMBERG_TZERO_OUT(GigaSpace gigaSpace) {
        BLOOMBERG_TZERO_OUT[] objects = TablesCreator.BLOOMBERG_TZERO_OUT_TABLE.generate(SIZE);
        gigaSpace.writeMultiple(objects);
    }

    public void writeCORP_PFD_OUT(GigaSpace gigaSpace) {
        CORP_PFD_OUT[] objects = TablesCreator.CORP_PFD_OUT_TABLE.generate(SIZE);
        gigaSpace.writeMultiple(objects);
    }

    public void writeBLOOMBERG_TZERO_PX_OUT_ADJUSTED(GigaSpace gigaSpace) {
        BLOOMBERG_TZERO_PX_OUT_ADJUSTED[] objects = TablesCreator.BLOOMBERG_TZERO_PX_OUT_ADJUSTED_TABLE.generate(SIZE);
        gigaSpace.writeMultiple(objects);
    }

    public void writeSHARE_FUTURES_PRICING_RPX(GigaSpace gigaSpace) {
        SHARE_FUTURES_PRICING_RPX[] objects = TablesCreator.SHARE_FUTURES_PRICING_RPX_TABLE.generate(SIZE);
        gigaSpace.writeMultiple(objects);
    }

    private BARRA_FX_RATES_WITH_MINOR_CURRENCIES[] generateBARRA_FX_RATES_WITH_MINOR_CURRENCIES(String fxCode){
        BARRA_FX_RATES_WITH_MINOR_CURRENCIES[] entries = new BARRA_FX_RATES_WITH_MINOR_CURRENCIES[Long.valueOf(endDate - startDate).intValue()];
        for (long i = 0; i < endDate - startDate; i++) {
            BARRA_FX_RATES_WITH_MINOR_CURRENCIES one = new BARRA_FX_RATES_WITH_MINOR_CURRENCIES();
            one.setCURRENCY_CODE(fxCode);
            one.setDDATE(startDate + i);
            one.setFX_RATE(rand.nextDouble());
            one.setRF_RATE(rand.nextDouble());
            one.setRouting(Long.valueOf(i).intValue());
            entries[Long.valueOf(i).intValue()] = one;
        }
        return entries;
    }

    private REAL_TIME_FUTURES[] generateREAL_TIME_FUTURES(String fxCode){
        REAL_TIME_FUTURES[] realTimeFutures = new REAL_TIME_FUTURES[SIZE];
        for (int i = 0; i < SIZE; i++){
            REAL_TIME_FUTURES rtf = new REAL_TIME_FUTURES();
            long timestamp = System.currentTimeMillis() - Math.abs(rand.nextInt());
            initEntry(rtf, fxCode, timestamp, i);
            rtf.setLAST_TRADE_PRICE_TIME_TODAY_RT(rtf.getLAST_PRICE_TIME_TODAY_REALTIME() - rand.nextInt(100));
            rtf.setASK(rtf.getLAST_PRICE().add(delta));
            rtf.setBID(rtf.getLAST_PRICE().subtract(delta));
            rtf.setVOLUME(rtf.getVOLUME_TDY().setScale(6, BigDecimal.ROUND_FLOOR));
            realTimeFutures[i] = rtf;
        }

        return realTimeFutures;
    }

    private REAL_TIME[] generateREAL_TIME(String fxCode){
        REAL_TIME[] realTimes = new REAL_TIME[SIZE];
        for (int i = 0; i < SIZE; i++){
            long timestamp = System.currentTimeMillis() - Math.abs(rand.nextInt());
            REAL_TIME rt = new REAL_TIME();
            initEntry(rt, fxCode, timestamp, i);
            rt.setPX_YEST_CLOSE(rt.getLAST_PRICE());
            realTimes[i] = rt;
        }

        return realTimes;
    }


    private String getRandomFruitId() {
        String[] fruitNames = new String[]{
                "APPLE",
                "BANANA",
                "KIWI",
                "LEMON",
                "ORANGE",
                "PINEAPPLE",
                "COCONUT",
                "WATERMELON",
                "MELON",
                "STRAWBERRY",
                "BLUEBERRY",
                "DRAGON_FRUIT"
        };
        int fruitIndex = Math.abs(rand.nextInt()) % fruitNames.length;
        return fruitNames[fruitIndex];
    }


    private void initEntry(PartitionedTable partitionedTable, String fxCode, long timestamp, int i){
        Date d = new Date(timestamp);
        LocalDateTime localDateTime = LocalDateTime.now();
        long date = d.getYear() + d.getMonth()*10000 + d.getDay() * 1000000;
        final Date sqlDate = Date.valueOf(localDateTime.toLocalDate().minusDays(i % 20));
        partitionedTable.setCRNCY(fxCode);
        partitionedTable.setDATA_DATE(sqlDate);
        partitionedTable.setDATA_RECEIVED_TIMESTAMP(timestamp);
        partitionedTable.setDBTIMESTAMP(timestamp);
        partitionedTable.setPX_YEST_DT(date -1);
        partitionedTable.setTICKER(fxCode + " elec " + date);
        partitionedTable.setLAST_PRICE(BigDecimal.valueOf(rand.nextDouble()).setScale(6, BigDecimal.ROUND_FLOOR));
        partitionedTable.setLAST_PRICE_TIME_TODAY_REALTIME(timestamp - rand.nextInt(10000));
        BigDecimal vol = new BigDecimal(Math.abs(rand.nextLong())).setScale(6, BigDecimal.ROUND_FLOOR);
        partitionedTable.setAVERAGE_VOLUME_AT_TIME_RT_5_DAYS(vol);
        partitionedTable.setAVERAGE_VOLUME_AT_TIME_RT_20_DAYS(vol.multiply(new BigDecimal(4)));
        partitionedTable.setAVERAGE_VOLUME_AT_TIME_RT_30_DAYS(vol.multiply(new BigDecimal(6)));
        partitionedTable.setTRADING_DT_REALTIME(date - rand.nextInt(1));
        vol = vol.setScale(0, BigDecimal.ROUND_FLOOR);
        partitionedTable.setVOLUME_TDY(vol);
        partitionedTable.setSIZE_LAST_TRADE(vol);
    }

    private String[] loadFXCodes() throws IOException {
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
        }
        return result.toArray(new String[0]);
    }
}
