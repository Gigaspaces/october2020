package com.olympus.model;

import barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import bpipe_rt.PartitionedTable;
import bpipe_rt.REAL_TIME;
import bpipe_rt.REAL_TIME_FUTURES;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

public class Generator {
    private static final int SIZE = 100;
    private static final Random rand = new Random(System.currentTimeMillis());
    private static final long startDate = 20200101;
    private static final long endDate = 20200601;
    private static final BigDecimal delta = new BigDecimal(0.001);

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

    public void writeBARRA_FX_RATES_WITH_MINOR_CURRENCIES(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateBARRA_FX_RATES_WITH_MINOR_CURRENCIES(fxCode));
        }
    }

    public void writeREAL_TIME_FUTURES(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateREAL_TIME_FUTURES(fxCode));
        }
    }

    public void writeREAL_TIME(GigaSpace gs) throws IOException {
        String[] codes = loadFXCodes();
        for (String fxCode: codes) {
            gs.writeMultiple(generateREAL_TIME(fxCode));
        }
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
            initEntry(rtf, fxCode, timestamp);
            rtf.setLAST_TRADE_PRICE_TIME_TODAY_RT(rtf.getLAST_PRICE_TIME_TODAY_REALTIME() - rand.nextInt(100));
            rtf.setASK(rtf.getLAST_PRICE().add(delta));
            rtf.setBID(rtf.getLAST_PRICE().subtract(delta));
            rtf.setVOLUME(rtf.getVOLUME_TDY());
            realTimeFutures[i] = rtf;
        }

        return realTimeFutures;
    }

    private REAL_TIME[] generateREAL_TIME(String fxCode){
        REAL_TIME[] realTimes = new REAL_TIME[SIZE];
        for (int i = 0; i < SIZE; i++){
            long timestamp = System.currentTimeMillis() - Math.abs(rand.nextInt());
            REAL_TIME rt = new REAL_TIME();
            initEntry(rt, fxCode, timestamp);
            rt.setPX_YEST_CLOSE(rt.getLAST_PRICE());
            realTimes[i] = rt;
        }

        return realTimes;
    }


    private void initEntry(PartitionedTable partitionedTable, String fxCode, long timestamp){
        Date d = new Date(timestamp);
        long date = d.getYear() + d.getMonth()*10000 + d.getDay() * 1000000;
        partitionedTable.setCRNCY(fxCode);
        partitionedTable.setDATA_DATE(date);
        partitionedTable.setDATA_RECEIVED_TIMESTAMP(timestamp);
        partitionedTable.setDBTIMESTAMP(timestamp);
        partitionedTable.setPX_YEST_DT(date -1);
        partitionedTable.setTICKER(fxCode + " elec " + date);
        partitionedTable.setLAST_PRICE(new BigDecimal(rand.nextDouble()));
        partitionedTable.setLAST_PRICE_TIME_TODAY_REALTIME(timestamp - rand.nextInt(10000));
        BigDecimal vol = new BigDecimal(Math.abs(rand.nextLong()));
        partitionedTable.set_5_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol);
        partitionedTable.set_20_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol.multiply(new BigDecimal(4)));
        partitionedTable.set_30_DAY_AVERAGE_VOLUME_AT_TIME_RT(vol.multiply(new BigDecimal(6)));
        partitionedTable.setTRADING_DT_REALTIME(date - rand.nextInt(1));
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
