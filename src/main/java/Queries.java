public class Queries {

    public static String QUERY_1 = "SELECT REGION, \n" +
            "       ID_BB_PARSEKEY, \n" +
            "       EXCH_CODE, \n" +
            "       NAME, \n" +
            "       CRNCY, \n" +
            "       FLEX_ID, \n" +
            "       ID_BB_GLOBAL, \n" +
            "       ID_SEDOL1, \n" +
            "       ID_SEDOL2, \n" +
            "       SECURITY_TYP, \n" +
            "       EQY_SH_OUT, \n" +
            "       ID_BB_GLOBAL_COMPANY \n" +
            "FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg.BLOOMBERG_TZERO_OUT \n" +
            "WHERE  REGION = ? \n" +
            "       AND DDATE = ?";

    public static String QUERY_2 = "SELECT TICKER, \n" +
            "       LAST_PRICE, \n" +
            "       DBTIMESTAMP \n" +
            "FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME T1 \n" +
            "WHERE  TICKER LIKE '%CURNCY%' \n" +
            "       AND DATA_RECEIVED_TIMESTAMP = (SELECT MAX(DATA_RECEIVED_TIMESTAMP) \n" +
            "                                      FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME T2 \n" +
            "                                      WHERE  T1.TICKER = T2.TICKER \n" +
            "                                             AND LAST_PRICE IS NOT NULL) \n" +
            "ORDER  BY DATA_RECEIVED_TIMESTAMP DESC;";

    public static String QUERY_3 = "SELECT COUNTRY, \n" +
            "       CRNCY, \n" +
            "       ID_BB_GLOBAL, \n" +
            "       ID_BB_SEC_NUM_DES, \n" +
            "       EXCH_CODE, \n" +
            "       ID_SEDOL1, \n" +
            "       ID_SEDOL2, \n" +
            "       NAME, \n" +
            "       ID_BB_GLOBAL_COMPANY, \n" +
            "       AMT_OUTSTANDING, \n" +
            "       SECURITY_TYP \n" +
            "FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg_fi.CORP_PFD_OUT \n" +
            "WHERE  REGION = ? \n" +
            "       AND DATA_DATE = ? \n" +
            "       AND MARKET_SECTOR_DES = 'Pfd' \n" +
            "       AND COUNTRY IN ( 'US', 'CA' ) \n" +
            "       AND CALLED_BOOL = 'N' \n" +
            "       AND EXCH_CODE <> 'NOT LISTED'";

    public static String QUERY_4 = "SELECT *\n" +
            "FROM   (SELECT REPLACE(X.TICKER, ' elec ' , ' ') AS TICKER,\n" +
            "               MAX(CRNCY)                       AS CRNCY,\n" +
            "               MAX(DATA_RECEIVED_TIMESTAMP)     AS DATA_RECEIVED_TIMESTAMP\n" +
            "        FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME_FUTURES AS X\n" +
            "               INNER JOIN (SELECT TICKER,\n" +
            "                                  MAX(DATA_RECEIVED_TIMESTAMP) AS MAX_TIMESTAMP\n" +
            "                           FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME_FUTURES\n" +
            "                           WHERE  CRNCY IS NOT NULL\n" +
            "                           GROUP  BY TICKER) AS Y\n" +
            "                       ON X.DATA_RECEIVED_TIMESTAMP = MAX_TIMESTAMP\n" +
            "                          AND X.TICKER = Y.TICKER\n" +
            "        GROUP  BY X.TICKER) RT\n" +
            "       LEFT JOIN (SELECT X.FX_RATE,\n" +
            "                         X.CURRENCY_CODE,\n" +
            "                         X.DDATE AS FX_DATE\n" +
            "                  FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES AS X\n" +
            "                         INNER JOIN\n" +
            "                         (SELECT CURRENCY_CODE,\n" +
            "                                 MAX(DDATE) AS DDATE\n" +
            "                          FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES\n" +
            "                          GROUP  BY CURRENCY_CODE) Y\n" +
            "                                 ON X.CURRENCY_CODE = Y.CURRENCY_CODE\n" +
            "                                    AND X.DDATE = Y.DDATE) FX\n" +
            "              ON RT.CRNCY = FX.CURRENCY_CODE\n" +
            "                 AND CRNCY IS NOT NULL\n" +
            "ORDER  BY DATA_RECEIVED_TIMESTAMP";

    public static String QUERY_5 = "SELECT REPLACE(X.PARSEKYABLE_DES_SOURCE, ' ELEC ', ' ') AS TICKER, \n" +
            "       MAX(PX_YEST_CLOSE)                               AS PX_YEST_CLOSE, \n" +
            "       MAX(X.DBTIMESTAMP)                               AS DBTIMESTAMP \n" +
            "FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg_futures.SHARE_FUTURES_PRICING_RPX AS X \n" +
            "       INNER JOIN (SELECT PARSEKYABLE_DES_SOURCE, \n" +
            "                          MAX(DBTIMESTAMP) AS MAX_TIMESTAMP \n" +
            "                   FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg_futures.SHARE_FUTURES_PRICING_RPX \n" +
            "                   WHERE  PX_YEST_CLOSE IS NOT NULL \n" +
            "                          AND DATA_DATE > CURRENT_DATE - 10 \n" +
            "                   GROUP  BY PARSEKYABLE_DES_SOURCE) AS Y \n" +
            "               ON X.DBTIMESTAMP = MAX_TIMESTAMP \n" +
            "                  AND X.PARSEKYABLE_DES_SOURCE = Y.PARSEKYABLE_DES_SOURCE \n" +
            "WHERE  PX_YEST_CLOSE IS NOT NULL \n" +
            "GROUP  BY REPLACE(X.PARSEKYABLE_DES_SOURCE, ' ELEC ', ' ')";

    public static String QUERY_6 = "SELECT BTZ.FLEX_ID, \n" +
            "       BADJ.CLOSE_PX_ADJ \n" +
            "FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg.BLOOMBERG_TZERO_OUT BTZ, \n" +
            "       com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bloomberg.BLOOMBERG_TZERO_PX_OUT_ADJUSTED BADJ \n" +
            "WHERE  BTZ.REGION = ? \n" +
            "       AND BTZ.DDATE = ? \n" +
            "       AND BTZ.DDATE = BADJ.OPEN_DATE \n" +
            "       AND BTZ.ID_BB_GLOBAL = BADJ.ID_BB_GLOBAL";

    public static String QUERY_7 = "SELECT M.TICKER, \n" +
            "       M.LAST_PRICE \n" +
            "FROM   (SELECT X.TICKER, \n" +
            "               MAX(LAST_PRICE) AS LAST_PRICE \n" +
            "        FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME AS X \n" +
            "               INNER JOIN (SELECT TICKER, \n" +
            "                                  MAX(DATA_RECEIVED_TIMESTAMP) AS MAX_TIMESTAMP \n" +
            "                           FROM   com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME \n" +
            "                           WHERE  LAST_PRICE IS NOT NULL \n" +
            "                                  AND LAST_PRICE > 0 \n" +
            "                                  AND DATA_DATE > CURRENT_DATE - 10 \n" +
            "                           GROUP  BY TICKER) AS Y \n" +
            "                       ON X.DATA_RECEIVED_TIMESTAMP = MAX_TIMESTAMP \n" +
            "                          AND X.TICKER = Y.TICKER \n" +
            "        GROUP  BY X.TICKER) M \n" +
            "WHERE  M.TICKER IN ( 'EPRA Index', 'F3MNG Index', 'F3RETG Index', 'GSCBLUXL Index', \n" +
            "                     'GSCBMUAE Index', 'GSCBOSA1 Index', 'GSCBOSAU Index', 'GSCBQTAR Index', \n" +
            "                     'GSCBSUDN Index', 'GSCBUKD1 Index', 'GSEXACOR Index', 'GSEXADIS Index', \n" +
            "                     'GSEXCINT Index', 'GSEXCRP1 Index', 'GSEXNPTC Index', 'GSEXRGAS Index', \n" +
            "                     'GSEXRUS1 Index', 'GSEXSF8X Index', 'JP55BOV5 Index', 'JPEPEMMC Index', \n" +
            "                     'JPEPJPMC Index', 'JPEPKRMC Index', 'JPEPTHM2 Index', 'JPEPTWM2 Index', \n" +
            "                     'JPEXBOV3 Index', 'JPEXBOV5 Index', 'JPEXBOV6 Index', 'JPEXCAPD Index', \n" +
            "                     'JPEXGSFT Index', 'JPEXHDG2 Index', 'JPEXHDG7 Index', 'JPEXSAUD Index', \n" +
            "                     'JPEXSEM Index', 'JPEXSFT Index', 'JPEXTMS2 Index', 'JPEXTS40 Index', \n" +
            "                     'JPEXTS50 Index', 'LCXP Index', 'M1SAP Index', 'MCX Index', \n" +
            "                     'MCXP Index', 'MDAX Index', 'MGCUAE Index', 'MGCUQA Index', \n" +
            "                     'MSEPAPEJ Index', 'MSEPCNAM Index', 'MSEPCRD1 Index', 'MSEPCRD2 Index', \n" +
            "                     'MSEPCRWD Index', 'MSEPEUNT Index', 'MSEPGRL1 Index', 'MSEPHFLY Index', \n" +
            "                     'MSEPHIFI Index', 'MSEPHMOM Index', 'MSEPIDMA Index', 'MSEPLMOM Index', \n" +
            "                     'MSEPMOMO Index', 'MSEPNAOS Index', 'MSEPQLCY Index', 'MSEPSMOM Index', \n" +
            "                     'MSEPSMSW Index', 'MSEPUGRL Index', 'MSEPUMOL Index', 'MSEPUMOS Index', \n" +
            "                     'MSEPWTPE Index', 'MSQQEVLL Index', 'MXAE Index', 'MXQA Index', \n" +
            "                     'NDEUTHF Index', 'SCXP Index', 'SMI Index', 'SX3E Index', \n" +
            "                     'SX3P Index', 'SX4P Index', 'SX5E Index', 'SX6P Index', \n" +
            "                     'SX7E Index', 'SX7P Index', 'SX86P Index', 'SX8P Index', \n" +
            "                     'SXAP Index', 'SXDP Index', 'SXEP Index', 'SXFP Index', \n" +
            "                     'SXIP Index', 'SXKP Index', 'SXMP Index', 'SXNP Index', \n" +
            "                     'SXOP Index', 'SXPP Index', 'SXQP Index', 'SXRP Index', \n" +
            "                     'SXTP Index', 'SXXP Index', 'TSEREIT Index', 'UKX Index' )";
}


