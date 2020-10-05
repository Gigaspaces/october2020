

Tables involved in Olympus queries 
BLOOMBERG.BLOOMBERG_TZERO_OUT
BPIPE_RT.REAL_TIME
BLOOMBERG_FI.CORP_PFD_OUT
BPIPE_RT.REAL_TIME_FUTURES
BARRA.BARRA_FX_RATES_WITH_MINOR_CURRENCIES 
BLOOMBERG.BLOOMBERG_TZERO_PX_OUT_ADJUSTED
BLOOMBERG_FUTURES.SHARE_FUTURES_PRICING



---------------------------------------------------------------------------------------
-- Queries 
-- Formatted via http://www.dpriver.com/pp/sqlformat.htm
---------------------------------------------------------------------------------------

-- 1) Simple select on a single table.
-- Challenges: none.
SELECT region, 
       id_bb_parsekey, 
       exch_code, 
       NAME, 
       crncy, 
       flex_id, 
       id_bb_global, 
       id_sedol1, 
       id_sedol2, 
       security_typ, 
       eqy_sh_out, 
       id_bb_global_company 
FROM   bloomberg.bloomberg_tzero_out 
WHERE  region = ? 
       AND ddate = ? 

-- 2) select with subquery on same table
-- Challenges: collocated subquery of table is ref or ticker col is routing. Otherwise requires shuffling.
SELECT ticker, 
       last_price, 
       dbtimestamp 
FROM   bpipe_rt.real_time t1 
WHERE  ticker LIKE '%Curncy%' 
       AND data_received_timestamp = (SELECT Max(data_received_timestamp) 
                                      FROM   bpipe_rt.real_time t2 
                                      WHERE  t1.ticker = t2.ticker 
                                             AND last_price IS NOT NULL) 
ORDER  BY data_received_timestamp DESC; 

-- 3) Simple select on a single table.
-- Challenges: none.
SELECT country, 
       crncy, 
       id_bb_global, 
       id_bb_sec_num_des, 
       exch_code, 
       id_sedol1, 
       id_sedol2, 
       NAME, 
       id_bb_global_company, 
       amt_outstanding, 
       security_typ 
FROM   bloomberg_fi.corp_pfd_out 
WHERE  region = ? 
       AND data_date = ? 
       AND market_sector_des = 'Pfd' 
       AND country IN ( 'US', 'CA' ) 
       AND called_bool = 'N' 
       AND exch_code <> 'NOT LISTED' 

-- 4) TODO
-- Challenges: TBD
SELECT * 
FROM   (SELECT Replace(x.ticker, ' ELEC ', ' ') AS TICKER, 
               Max(crncy)                       AS CRNCY, 
               Max(data_received_timestamp)     AS DATA_RECEIVED_TIMESTAMP 
        FROM   bpipe_rt.real_time_futures AS x 
               INNER JOIN (SELECT ticker, 
                                  Max(data_received_timestamp) AS MAX_TIMESTAMP 
                           FROM   bpipe_rt.real_time_futures 
                           WHERE  crncy IS NOT NULL 
                           GROUP  BY ticker) AS y 
                       ON x.data_received_timestamp = max_timestamp 
                          AND x.ticker = y.ticker 
        GROUP  BY x.ticker) RT 
       LEFT JOIN (SELECT x.fx_rate, 
                         x.currency_code, 
                         x.ddate AS FX_DATE 
                  FROM   barra.barra_fx_rates_with_minor_currencies AS x 
                         INNER JOIN 
                         (SELECT currency_code, 
                                 Max(ddate) AS DDATE 
                          FROM   barra.barra_fx_rates_with_minor_currencies 
                          GROUP  BY currency_code) y 
                                 ON x.currency_code = y.currency_code 
                                    AND x.ddate = y.ddate) FX 
              ON RT.crncy = FX.currency_code 
                 AND crncy IS NOT NULL 
ORDER  BY data_received_timestamp; 

-- 5) TODO
-- Challenges: TBD
SELECT Replace(x.parsekyable_des_source, ' ELEC ', ' ') AS TICKER, 
       Max(px_yest_close)                               AS PX_YEST_CLOSE, 
       Max(x.dbtimestamp)                               AS DBTIMESTAMP 
FROM   bloomberg_futures.share_futures_pricing_rpx AS x 
       INNER JOIN (SELECT parsekyable_des_source, 
                          Max(dbtimestamp) AS MAX_TIMESTAMP 
                   FROM   bloomberg_futures.share_futures_pricing_rpx 
                   WHERE  px_yest_close IS NOT NULL 
                          AND data_date > CURRENT_DATE - 10 
                   GROUP  BY parsekyable_des_source) AS y 
               ON x.dbtimestamp = max_timestamp 
                  AND x.parsekyable_des_source = y.parsekyable_des_source 
WHERE  px_yest_close IS NOT NULL 
GROUP  BY Replace(x.parsekyable_des_source, ' ELEC ', ' ') 

-- 6) Select on 2 tables, effectively inner join withot join syntax
-- Challenges: inner join. 
SELECT btz.flex_id, 
       badj.close_px_adj 
FROM   bloomberg.bloomberg_tzero_out btz, 
       bloomberg.bloomberg_tzero_px_out_adjusted badj 
WHERE  btz.region = ? 
       AND btz.ddate = ? 
       AND btz.ddate = badj.open_date 
       AND btz.id_bb_global = badj.id_bb_global 

-- 7) TODO
-- Challenges: 3 levels (select from select from select) mixed with join.
-- all queries and joins are on same table, so looks like its collocated if ticker is routing
SELECT m.ticker, 
       m.last_price 
FROM   (SELECT x.ticker, 
               Max(last_price) AS LAST_PRICE 
        FROM   bpipe_rt.real_time AS x 
               INNER JOIN (SELECT ticker, 
                                  Max(data_received_timestamp) AS MAX_TIMESTAMP 
                           FROM   bpipe_rt.real_time 
                           WHERE  last_price IS NOT NULL 
                                  AND last_price > 0 
                                  AND data_date > CURRENT_DATE - 10 
                           GROUP  BY ticker) AS y 
                       ON x.data_received_timestamp = max_timestamp 
                          AND x.ticker = y.ticker 
        GROUP  BY x.ticker) m 
WHERE  m.ticker IN ( 'EPRA Index', 'F3MNG Index', 'F3RETG Index', 'GSCBLUXL Index', 
                     'GSCBMUAE Index', 'GSCBOSA1 Index', 'GSCBOSAU Index', 'GSCBQTAR Index', 
                     'GSCBSUDN Index', 'GSCBUKD1 Index', 'GSEXACOR Index', 'GSEXADIS Index', 
                     'GSEXCINT Index', 'GSEXCRP1 Index', 'GSEXNPTC Index', 'GSEXRGAS Index', 
                     'GSEXRUS1 Index', 'GSEXSF8X Index', 'JP55BOV5 Index', 'JPEPEMMC Index', 
                     'JPEPJPMC Index', 'JPEPKRMC Index', 'JPEPTHM2 Index', 'JPEPTWM2 Index', 
                     'JPEXBOV3 Index', 'JPEXBOV5 Index', 'JPEXBOV6 Index', 'JPEXCAPD Index', 
                     'JPEXGSFT Index', 'JPEXHDG2 Index', 'JPEXHDG7 Index', 'JPEXSAUD Index', 
                     'JPEXSEM Index', 'JPEXSFT Index', 'JPEXTMS2 Index', 'JPEXTS40 Index', 
                     'JPEXTS50 Index', 'LCXP Index', 'M1SAP Index', 'MCX Index', 
                     'MCXP Index', 'MDAX Index', 'MGCUAE Index', 'MGCUQA Index', 
                     'MSEPAPEJ Index', 'MSEPCNAM Index', 'MSEPCRD1 Index', 'MSEPCRD2 Index', 
                     'MSEPCRWD Index', 'MSEPEUNT Index', 'MSEPGRL1 Index', 'MSEPHFLY Index', 
                     'MSEPHIFI Index', 'MSEPHMOM Index', 'MSEPIDMA Index', 'MSEPLMOM Index', 
                     'MSEPMOMO Index', 'MSEPNAOS Index', 'MSEPQLCY Index', 'MSEPSMOM Index', 
                     'MSEPSMSW Index', 'MSEPUGRL Index', 'MSEPUMOL Index', 'MSEPUMOS Index', 
                     'MSEPWTPE Index', 'MSQQEVLL Index', 'MXAE Index', 'MXQA Index', 
                     'NDEUTHF Index', 'SCXP Index', 'SMI Index', 'SX3E Index', 
                     'SX3P Index', 'SX4P Index', 'SX5E Index', 'SX6P Index', 
                     'SX7E Index', 'SX7P Index', 'SX86P Index', 'SX8P Index', 
                     'SXAP Index', 'SXDP Index', 'SXEP Index', 'SXFP Index', 
                     'SXIP Index', 'SXKP Index', 'SXMP Index', 'SXNP Index', 
                     'SXOP Index', 'SXPP Index', 'SXQP Index', 'SXRP Index', 
                     'SXTP Index', 'SXXP Index', 'TSEREIT Index', 'UKX Index' ); 
