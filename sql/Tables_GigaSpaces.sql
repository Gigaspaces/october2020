CREATE TABLE "BPIPE_EOD"."PX_POS_MULT_FACTOR" (
		"DATA_DATE" DATE NOT NULL ,
		"BLOOMBERG_ID" VARCHAR(40) UTF8 NOT NULL ,
		"PX_POS_MULT_FACTOR" VARCHAR(2000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);


ALTER TABLE BPIPE_EOD.PX_POS_MULT_FACTOR ADD CONSTRAINT PX_POS_MULT_FACTOR_PK PRIMARY KEY ("DATA_DATE","BLOOMBERG_ID")  ENABLE ;

enforce GLOBAL index on BPIPE_EOD.PX_POS_MULT_FACTOR(DATA_DATE,BLOOMBERG_ID);


CREATE TABLE "BPIPE_EOD"."FUT_ACT_DAYS_EXP" (
		"DATA_DATE" DATE NOT NULL ,
		"BLOOMBERG_ID" VARCHAR(40) UTF8 NOT NULL ,
		"FUT_ACT_DAYS_EXP" VARCHAR(2000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);


ALTER TABLE BPIPE_EOD.FUT_ACT_DAYS_EXP ADD CONSTRAINT FUT_ACT_DAYS_EXP_PK PRIMARY KEY ("DATA_DATE","BLOOMBERG_ID")  ENABLE ;

enforce GLOBAL index on BPIPE_EOD.FUT_ACT_DAYS_EXP(DATA_DATE,BLOOMBERG_ID);

CREATE TABLE "BLOOMBERG"."BLOOMBERG_TZERO_OUT" (
		"DDATE" DATE NOT NULL ,
		"REGION" VARCHAR(2000000) UTF8 NOT NULL ,
		"LINE_NUM" VARCHAR(2000000) UTF8 NOT NULL ,
		"ID_BB_PARSEKEY" VARCHAR(2000000) UTF8 ,
		"FLEX_ID" VARCHAR(2000000) UTF8 ,
		"UNKNOWN1" VARCHAR(2000000) UTF8 ,
		"UNKNOWN2" VARCHAR(2000000) UTF8 ,
		"TICKER" VARCHAR(2000000) UTF8 ,
		"EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"NAME" VARCHAR(2000000) UTF8 ,
		"COUNTRY" VARCHAR(2000000) UTF8 ,
		"CRNCY" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP" VARCHAR(2000000) UTF8 ,
		"PAR_AMT" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_EXCH" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_EXCH_SHRT" VARCHAR(2000000) UTF8 ,
		"EQY_SIC_CODE" VARCHAR(2000000) UTF8 ,
		"EQY_SIC_NAME" VARCHAR(2000000) UTF8 ,
		"INDUSTRY_GROUP" VARCHAR(2000000) UTF8 ,
		"INDUSTRY_SUBGROUP" VARCHAR(2000000) UTF8 ,
		"INDUSTRY_SECTOR" VARCHAR(2000000) UTF8 ,
		"ID_SEDOL1" VARCHAR(12) UTF8 ,
		"ID_WERTPAPIER" VARCHAR(2000000) UTF8 ,
		"ID_ISIN" VARCHAR(30) UTF8 ,
		"ID_DUTCH" VARCHAR(2000000) UTF8 ,
		"ID_VALOREN" VARCHAR(2000000) UTF8 ,
		"ID_FRENCH" VARCHAR(2000000) UTF8 ,
		"ID_BELGIUM" VARCHAR(2000000) UTF8 ,
		"ID_BB_COMPANY" VARCHAR(2000000) UTF8 ,
		"ID_BB_SECURITY" VARCHAR(2000000) UTF8 ,
		"ID_CUSIP" VARCHAR(17) UTF8 ,
		"ID_COMMON" VARCHAR(2000000) UTF8 ,
		"ADR_UNDL_TICKER" VARCHAR(2000000) UTF8 ,
		"ADR_SH_PER_ADR" VARCHAR(2000000) UTF8 ,
		"DVD_CRNCY" VARCHAR(2000000) UTF8 ,
		"EQY_DVD_SH_12M_NET" VARCHAR(2000000) UTF8 ,
		"DVD_SH_12M" VARCHAR(2000000) UTF8 ,
		"DVD_SH_LAST" VARCHAR(2000000) UTF8 ,
		"LAST_DPS_GROSS" VARCHAR(2000000) UTF8 ,
		"EQY_DVD_PCT_FRANKED" VARCHAR(2000000) UTF8 ,
		"DVD_TYP_LAST" VARCHAR(2000000) UTF8 ,
		"DVD_FREQ" VARCHAR(2000000) UTF8 ,
		"DVD_PAY_DT" VARCHAR(2000000) UTF8 ,
		"DVD_RECORD_DT" VARCHAR(2000000) UTF8 ,
		"DVD_DECLARED_DT" VARCHAR(2000000) UTF8 ,
		"EQY_SPLIT_DT" VARCHAR(2000000) UTF8 ,
		"EQY_SPLIT_RATIO" VARCHAR(2000000) UTF8 ,
		"DVD_EX_DT" VARCHAR(2000000) UTF8 ,
		"EQY_DVD_EX_FLAG" VARCHAR(2000000) UTF8 ,
		"INDUSTRY_SUBGROUP_NUM" VARCHAR(2000000) UTF8 ,
		"CNTRY_ISSUE_ISO" VARCHAR(2000000) UTF8 ,
		"MARKET_STATUS" VARCHAR(2000000) UTF8 ,
		"ID_BB_PARENT_CO" VARCHAR(2000000) UTF8 ,
		"ADR_UNDL_CMPID" VARCHAR(2000000) UTF8 ,
		"ADR_UNDL_SECID" VARCHAR(2000000) UTF8 ,
		"REL_INDEX" VARCHAR(2000000) UTF8 ,
		"PX_TRADE_LOT_SIZE" VARCHAR(2000000) UTF8 ,
		"PARENT_COMP_TICKER" VARCHAR(2000000) UTF8 ,
		"PARENT_COMP_NAME" VARCHAR(2000000) UTF8 ,
		"ID_LOCAL" VARCHAR(2000000) UTF8 ,
		"LONG_COMP_NAME" VARCHAR(2000000) UTF8 ,
		"PARENT_INDUSTRY_GROUP" VARCHAR(2000000) UTF8 ,
		"PARENT_INDUSTRY_SUBGROUP" VARCHAR(2000000) UTF8 ,
		"PARENT_INDUSTRY_SECTOR" VARCHAR(2000000) UTF8 ,
		"VOTING_RIGHTS" VARCHAR(2000000) UTF8 ,
		"ID_BB_PRIM_SECURITY_FLAG" VARCHAR(2000000) UTF8 ,
		"PAR_VAL_CRNCY" VARCHAR(2000000) UTF8 ,
		"EQY_SH_OUT" VARCHAR(2000000) UTF8 ,
		"EQY_SH_OUT_DT" VARCHAR(2000000) UTF8 ,
		"ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(2000000) UTF8 ,
		"IS_STK_MARGINABLE" VARCHAR(2000000) UTF8 ,
		"A144_FLAG" VARCHAR(2000000) UTF8 ,
		"TRANSFER_AGENT" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_SECURITY_TICKER" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_SECURITY_COMP_EXCH" VARCHAR(2000000) UTF8 ,
		"IS_SETS" VARCHAR(2000000) UTF8 ,
		"WHICH_JAPANESE_SECTION" VARCHAR(2000000) UTF8 ,
		"ADR_ADR_PER_SH" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_SECURITY_PRIM_EXCH" VARCHAR(2000000) UTF8 ,
		"EQY_FUND_CRNCY" VARCHAR(2000000) UTF8 ,
		"WHEN_ISSUED" VARCHAR(2000000) UTF8 ,
		"CDR_COUNTRY_CODE" VARCHAR(2000000) UTF8 ,
		"CDR_EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"CNTRY_OF_INCORPORATION" VARCHAR(2000000) UTF8 ,
		"CNTRY_OF_DOMICILE" VARCHAR(2000000) UTF8 ,
		"SEC_RESTRICT" VARCHAR(2000000) UTF8 ,
		"EQY_SH_OUT_REAL" VARCHAR(2000000) UTF8 ,
		"ADR_UNDL_CRNCY" VARCHAR(2000000) UTF8 ,
		"MULTIPLE_SHARE" VARCHAR(2000000) UTF8 ,
		"PX_QUOTE_LOT_SIZE" VARCHAR(2000000) UTF8 ,
		"PX_ROUND_LOT_SIZE" VARCHAR(2000000) UTF8 ,
		"ID_SEDOL2" VARCHAR(12) UTF8 ,
		"SEDOL1_COUNTRY_ISO" VARCHAR(2000000) UTF8 ,
		"SEDOL2_COUNTRY_ISO" VARCHAR(2000000) UTF8 ,
		"ID_MIC_PRIM_EXCH" VARCHAR(2000000) UTF8 ,
		"ID_MIC_LOCAL_EXCH" VARCHAR(2000000) UTF8 ,
		"EQY_SH_OUT_TOT_MULT_SH" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP2" VARCHAR(2000000) UTF8 ,
		"ID_BB_PRIM_SECURITY" VARCHAR(2000000) UTF8 ,
		"EQY_OPT_AVAIL" VARCHAR(2000000) UTF8 ,
		"EQY_FREE_FLOAT_PCT" VARCHAR(2000000) UTF8 ,
		"TICKER_AND_EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"EQY_INIT_PO_DT" VARCHAR(2000000) UTF8 ,
		"EQY_PO_DT" VARCHAR(2000000) UTF8 ,
		"EQY_INIT_PO_SH_PX" VARCHAR(2000000) UTF8 ,
		"EQY_SPLIT_ADJ_INIT_PO_PX" VARCHAR(2000000) UTF8 ,
		"EQY_FUND_TICKER" VARCHAR(2000000) UTF8 ,
		"TOTAL_VOTING_SHARES_VALUE" VARCHAR(2000000) UTF8 ,
		"ID_EXCH_SYMBOL" VARCHAR(2000000) UTF8 ,
		"ID_BB_CONNECT" VARCHAR(2000000) UTF8 ,
		"ID_NAICS_CODE" VARCHAR(2000000) UTF8 ,
		"TOTAL_NON_VOTING_SHARES_VALUE" VARCHAR(2000000) UTF8 ,
		"CDR_SETTLE_CODE" VARCHAR(2000000) UTF8 ,
		"CFI_CODE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"COMPOSITE_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"INDUSTRY_GROUP_NUM" VARCHAR(2000000) UTF8 ,
		"INDUSTRY_SECTOR_NUM" VARCHAR(2000000) UTF8 ,
		"EQY_PRIM_SECURITY_CRNCY" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(2000000) UTF8 ,
		"FEED_SOURCE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL_COMPANY" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL_COMPANY_NAME" VARCHAR(2000000) UTF8 ,
		"UNDERLYING_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"PRIMARY_UNDERLYING_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"ID_BB_GLOBAL_SHARE_CLASS_LEVEL" VARCHAR(2000000) UTF8 ,
		"PRIM_SECURITY_COMP_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER" VARCHAR(2000000) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER_DES" VARCHAR(2000000) UTF8 ,
		"LSE_SEGMENT" VARCHAR(1000) UTF8 ,
		"LSE_SECTOR" VARCHAR(1000) UTF8 
);
;

ALTER TABLE BLOOMBERG.BLOOMBERG_TZERO_OUT ADD CONSTRAINT BLOOMBERG_TZERO_OUT_PKEY PRIMARY KEY ("DDATE","REGION","LINE_NUM")  ENABLE ;

enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,REGION,LINE_NUM);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_ISIN);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_BB_UNIQUE);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_BB_PARSEKEY);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_BB_UNIQUE);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_ISIN,ID_CUSIP);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_SEDOL1);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_BB_PARSEKEY);
enforce GLOBAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_SEDOL1,EXCH_CODE);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(SEDOL2_COUNTRY_ISO);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_SEDOL1);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,REGION,LINE_NUM);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,ID_BB_PARSEKEY);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(DDATE,REGION);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_BB_PARSEKEY);
enforce LOCAL index on BLOOMBERG.BLOOMBERG_TZERO_OUT(ID_BB_GLOBAL);



CREATE TABLE "BLOOMBERG"."DATA_JOB_STATUS" (
		"DDATE" DATE ,
		"VENDOR" VARCHAR(2000000) UTF8 ,
		"REGION" VARCHAR(2000000) UTF8 ,
		"TABLE_NAME" VARCHAR(2000000) UTF8 ,
		"STATUS" VARCHAR(2000000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP 
);

enforce GLOBAL index on BLOOMBERG.DATA_JOB_STATUS(DDATE,VENDOR,REGION,TABLE_NAME);
enforce LOCAL index on BLOOMBERG.DATA_JOB_STATUS(DDATE,VENDOR,REGION,TABLE_NAME,STATUS,DBTIMESTAMP);
enforce LOCAL index on BLOOMBERG.DATA_JOB_STATUS(VENDOR,REGION,TABLE_NAME,STATUS,DBTIMESTAMP);
enforce LOCAL index on BLOOMBERG.DATA_JOB_STATUS(DDATE,VENDOR,REGION,TABLE_NAME,STATUS);
enforce LOCAL index on BLOOMBERG.DATA_JOB_STATUS(DDATE,VENDOR,REGION,TABLE_NAME);

CREATE TABLE "BLOOMBERG_FI"."CORP_PFD_OUT" (
		"REGION" VARCHAR(10) UTF8 ,
		"CUR_CPN" VARCHAR(255) UTF8 ,
		"ID_SPAIN" VARCHAR(255) UTF8 ,
		"ID_ITALY" VARCHAR(255) UTF8 ,
		"SHORT_NAME" VARCHAR(255) UTF8 ,
		"NXT_CPN_DT" DATE ,
		"DELIVERY_TYP" VARCHAR(255) UTF8 ,
		"LAST_REFIX_DT" VARCHAR(255) UTF8 ,
		"PCT_PAR_QUOTED" VARCHAR(255) UTF8 ,
		"REMOVAL_REASON" VARCHAR(255) UTF8 ,
		"ID_BB_PARENT_CO" DECIMAL(18,0) ,
		"FIRST_SETTLE_DT" DATE ,
		"ISO_COUNTRY_GUARANTOR" VARCHAR(255) UTF8 ,
		"ISSUER" VARCHAR(255) UTF8 ,
		"CFI_CODE" VARCHAR(255) UTF8 ,
		"SINKABLE" VARCHAR(255) UTF8 ,
		"ID_JAPAN" VARCHAR(255) UTF8 ,
		"LEAD_MGR" VARCHAR(255) UTF8 ,
		"FLAG_144A" VARCHAR(255) UTF8 ,
		"RESET_IDX" VARCHAR(255) UTF8 ,
		"ID_SWEDISH" VARCHAR(255) UTF8 ,
		"DTC_ELIGIBLE" VARCHAR(255) UTF8 ,
		"NXT_FACTOR_DT" DATE ,
		"ID_BB_SECURITY" DECIMAL(18,0) ,
		"CV_CNVS_FEXCH_RT" VARCHAR(255) UTF8 ,
		"CNTRY_OF_DOMICILE" VARCHAR(255) UTF8 ,
		"PENULTIMATE_CPN_DT" DATE ,
		"CRNCY" VARCHAR(255) UTF8 ,
		"JUNIOR" VARCHAR(255) UTF8 ,
		"SERIES" VARCHAR(255) UTF8 ,
		"ID_ISIN" VARCHAR(255) UTF8 ,
		"ID_SEDOL5" VARCHAR(255) UTF8 ,
		"DEFAULTED" VARCHAR(255) UTF8 ,
		"FILE_NAME" VARCHAR(255) UTF8 ,
		"REGISTERED" VARCHAR(255) UTF8 ,
		"AMT_ISSUED" DOUBLE ,
		"INT_ACC_DT" DATE ,
		"ANNOUNCE_DT" DATE ,
		"NXT_CALL_PX" DOUBLE ,
		"FIRST_CPN_DT" DATE ,
		"PCS_QUOTE_TYP" DECIMAL(18,0) ,
		"CDR_SETTLE_CODE" VARCHAR(255) UTF8 ,
		"ID_BB_GUARANTOR" DECIMAL(18,0) ,
		"RTG_JCR" VARCHAR(255) UTF8 ,
		"FLOATER" VARCHAR(255) UTF8 ,
		"BASE_CPI" DOUBLE ,
		"ID_VALOREN" VARCHAR(255) UTF8 ,
		"CV_CNVS_PX" VARCHAR(255) UTF8 ,
		"BASIC_SPREAD" DOUBLE ,
		"ISSUERS_STOCK" VARCHAR(255) UTF8 ,
		"DTC_REGISTERED" VARCHAR(255) UTF8 ,
		"LONG_COMP_NAME" VARCHAR(255) UTF8 ,
		"PFD_DVD_PAY_DT" DATE ,
		"NXT_PAR_CALL_DT" DATE ,
		"ID_JAPAN_COMPANY" VARCHAR(255) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(255) UTF8 ,
		"SINKING_FUND_FACTOR" DOUBLE ,
		"CNTRY_OF_INCORPORATION" VARCHAR(255) UTF8 ,
		"BEARER" VARCHAR(255) UTF8 ,
		"COLLAT_TYP" VARCHAR(255) UTF8 ,
		"DUAL_CRNCY" VARCHAR(255) UTF8 ,
		"ISSUER_BULK" VARCHAR(255) UTF8 ,
		"ID_BB_UNIQUE" VARCHAR(255) UTF8 ,
		"ID_LUXEMBOURG" VARCHAR(255) UTF8 ,
		"CV_CNVS_RATIO" VARCHAR(255) UTF8 ,
		"ID_WERTPAPIER" VARCHAR(255) UTF8 ,
		"PFD_EX_DVD_DT" DATE ,
		"CALC_MATURITY" VARCHAR(255) UTF8 ,
		"NXT_PAR_PUT_DT" DATE ,
		"AMT_OUTSTANDING" DOUBLE ,
		"MAKE_WHOLE_CALL" VARCHAR(255) UTF8 ,
		"SEASONING_STATUS" VARCHAR(255) UTF8 ,
		"FLT_BENCH_MULTIPLIER" DOUBLE ,
		"SINK_SCHEDULE_AMT_TYP" VARCHAR(255) UTF8 ,
		"ID_MIC1" VARCHAR(255) UTF8 ,
		"CALC_TYP" DECIMAL(18,0) ,
		"ID_BELGIUM" VARCHAR(255) UTF8 ,
		"STEPUP_CPN" DOUBLE ,
		"NXT_PUT_DT" DATE ,
		"PFD_RST_DVD" DOUBLE ,
		"ID_XTRAKTER" VARCHAR(255) UTF8 ,
		"EST_CPN_FLAG" VARCHAR(255) UTF8 ,
		"SECURITY_DES" VARCHAR(255) UTF8 ,
		"ISSUER_INDUSTRY" VARCHAR(255) UTF8 ,
		"CV_COMMON_TICKER" VARCHAR(255) UTF8 ,
		"FLT_CPN_CONVENTION" VARCHAR(255) UTF8 ,
		"CONTINGENT_CONVERSION" VARCHAR(255) UTF8 ,
		"MAKE_WHOLE_CALL_SPREAD" DOUBLE ,
		"ID_MIC2" VARCHAR(255) UTF8 ,
		"ID_CEDEL" VARCHAR(255) UTF8 ,
		"ISSUE_DT" DATE ,
		"STEPUP_DT" DATE ,
		"NXT_PUT_PX" DOUBLE ,
		"PREV_CPN_DT" DATE ,
		"MARKET_ISSUE" VARCHAR(255) UTF8 ,
		"CALC_TYP_DES" VARCHAR(255) UTF8 ,
		"INDUSTRY_GROUP" VARCHAR(255) UTF8 ,
		"FLT_DAYS_PRIOR" DECIMAL(18,0) ,
		"SECURITY_FACTORABLE" VARCHAR(255) UTF8 ,
		"EU_SAVINGS_DIRECTIVE" VARCHAR(255) UTF8 ,
		"CV_COMMON_TICKER_EXCH" VARCHAR(255) UTF8 ,
		"CONTRIB_DATA_INDICATOR" VARCHAR(255) UTF8 ,
		"ID_MIC3" VARCHAR(255) UTF8 ,
		"COUNTRY" VARCHAR(255) UTF8 ,
		"CALLABLE" VARCHAR(255) UTF8 ,
		"ISSUE_PX" DOUBLE ,
		"ID_COMMON" VARCHAR(255) UTF8 ,
		"PRVT_PLACE" VARCHAR(255) UTF8 ,
		"FLT_PAY_DAY" VARCHAR(255) UTF8 ,
		"EXCHANGEABLE" VARCHAR(255) UTF8 ,
		"SECURITY_TYP" VARCHAR(255) UTF8 ,
		"NXT_REFIX_DT" DATE ,
		"STRUCTURED_NOTE" VARCHAR(255) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(255) UTF8 ,
		"CV_MANDATORY_CNVS" VARCHAR(255) UTF8 ,
		"INDUSTRY_GROUP_NUM" DECIMAL(18,0) ,
		"TICKER" VARCHAR(255) UTF8 ,
		"ID_MIC4" VARCHAR(255) UTF8 ,
		"PUTABLE" VARCHAR(255) UTF8 ,
		"ID_CUSIP" VARCHAR(255) UTF8 ,
		"MATURITY" VARCHAR(255) UTF8 ,
		"EXCH_CODE" VARCHAR(255) UTF8 ,
		"CV_PROV_PX" VARCHAR(255) UTF8 ,
		"CALLED_BOOL" VARCHAR(255) UTF8 ,
		"SECURITY_TYP2" VARCHAR(255) UTF8 ,
		"NXT_REFUND_DT" DATE ,
		"INDUSTRY_SECTOR" VARCHAR(255) UTF8 ,
		"GILTS_EX_DVD_DT" DATE ,
		"IS_CURRENT_GOVT" VARCHAR(255) UTF8 ,
		"COUNTRY_GUARANTOR" VARCHAR(255) UTF8 ,
		"CPN" DOUBLE ,
		"ID_MIC5" VARCHAR(255) UTF8 ,
		"CV_SH_PAR" VARCHAR(255) UTF8 ,
		"CALLED_DT" DATE ,
		"EXTENDIBLE" VARCHAR(255) UTF8 ,
		"TRADE_CRNCY" VARCHAR(255) UTF8 ,
		"PUT_DISCRETE" VARCHAR(255) UTF8 ,
		"IS_DAY_PAYER" VARCHAR(255) UTF8 ,
		"NXT_SINK_AMT" DOUBLE ,
		"ID_CUSIP_REAL" VARCHAR(255) UTF8 ,
		"MIN_INCREMENT" DOUBLE ,
		"GUARANTOR_NAME" VARCHAR(255) UTF8 ,
		"SEDOL1_COUNTRY_ISO" VARCHAR(255) UTF8 ,
		"INDUSTRY_SECTOR_NUM" DECIMAL(18,0) ,
		"MIN_PIECE" DOUBLE ,
		"ID_DANISH" VARCHAR(255) UTF8 ,
		"CALLED_PX" DOUBLE ,
		"ID_NORWAY" VARCHAR(255) UTF8 ,
		"CPN_CRNCY" VARCHAR(255) UTF8 ,
		"PUT_FEATURE" VARCHAR(255) UTF8 ,
		"ID_AUSTRIAN" VARCHAR(255) UTF8 ,
		"NXT_SINK_DT" DATE ,
		"CV_START_DT" DATE ,
		"IS_PERPETUAL" VARCHAR(255) UTF8 ,
		"TRADE_STATUS" VARCHAR(255) UTF8 ,
		"CALL_DISCRETE" VARCHAR(255) UTF8 ,
		"EX_DIV_CALENDAR" VARCHAR(255) UTF8 ,
		"INDUSTRY_SUBGROUP" VARCHAR(255) UTF8 ,
		"SEDOL2_COUNTRY_ISO" VARCHAR(255) UTF8 ,
		"OID_BOND" VARCHAR(255) UTF8 ,
		"ID_DUTCH" VARCHAR(255) UTF8 ,
		"CV_UNTIL" VARCHAR(255) UTF8 ,
		"CPN_FREQ" DECIMAL(18,0) ,
		"IS_REG_S" VARCHAR(255) UTF8 ,
		"ID_SEDOL1" VARCHAR(255) UTF8 ,
		"EX_DIV_DAYS" VARCHAR(255) UTF8 ,
		"TYPE_OF_BOND" VARCHAR(255) UTF8 ,
		"CALL_FEATURE" VARCHAR(255) UTF8 ,
		"REDEMP_CRNCY" VARCHAR(255) UTF8 ,
		"ID_BB_COMPANY" DECIMAL(18,0) ,
		"SEDOL3_COUNTRY_ISO" VARCHAR(255) UTF8 ,
		"INDUSTRY_SUBGROUP_NUM" DECIMAL(18,0) ,
		"MOST_RECENT_REPORTED_FACTOR" DOUBLE ,
		"MTY_TYP" VARCHAR(255) UTF8 ,
		"ID_SEDOL2" VARCHAR(255) UTF8 ,
		"REDEMP_VAL" DOUBLE ,
		"FEED_SOURCE" VARCHAR(255) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(255) UTF8 ,
		"CALL_PARTIAL" VARCHAR(255) UTF8 ,
		"ID_EUROCLEAR" VARCHAR(255) UTF8 ,
		"INFLATION_LAG" DECIMAL(18,0) ,
		"DAYS_TO_SETTLE" DECIMAL(18,0) ,
		"CDR_COUNTRY_CODE" VARCHAR(255) UTF8 ,
		"PARENT_COMP_NAME" VARCHAR(255) UTF8 ,
		"CPN_FREQ_YLD_CNV" DECIMAL(18,0) ,
		"UNDL_ID_BB_UNIQUE" VARCHAR(255) UTF8 ,
		"SEDOL4_COUNTRY_ISO" VARCHAR(255) UTF8 ,
		"IS_REVERSE_CONVERTIBLE" VARCHAR(255) UTF8 ,
		"NAME" VARCHAR(255) UTF8 ,
		"SENIOR" VARCHAR(255) UTF8 ,
		"CPN_TYP" VARCHAR(255) UTF8 ,
		"PAR_AMT" DOUBLE ,
		"DAY_CNT" DECIMAL(18,0) ,
		"ID_SEDOL3" VARCHAR(255) UTF8 ,
		"ID_SEDOL4" VARCHAR(255) UTF8 ,
		"ID_FRENCH" VARCHAR(255) UTF8 ,
		"DATA_DATE" DATE ,
		"REFIX_FREQ" DOUBLE ,
		"NXT_CALL_DT" DATE ,
		"DBTIMESTAMP" TIMESTAMP ,
		"IS_SOFT_CALL" VARCHAR(255) UTF8 ,
		"IS_UNIT_TRADED" VARCHAR(255) UTF8 ,
		"ID_EXCH_SYMBOL" VARCHAR(255) UTF8 ,
		"DAY_PAYER_FREQ" DECIMAL(18,0) ,
		"FINAL_MATURITY" VARCHAR(255) UTF8 ,
		"REFERENCE_INDEX" VARCHAR(255) UTF8 ,
		"INSURANCE_STATUS" VARCHAR(255) UTF8 ,
		"SEDOL5_COUNTRY_ISO" VARCHAR(255) UTF8 ,
		"PARENT_COMP_TICKER" VARCHAR(255) UTF8 ,
		"CREDIT_ENHANCEMENTS" VARCHAR(255) UTF8 ,
		"ID_BB_GLOBAL_COMPANY" VARCHAR(255) UTF8 ,
		"FIRST_CALL_DT_ISSUANCE" VARCHAR(255) UTF8 ,
		"INFLATION_LINKED_INDICATOR" VARCHAR(255) UTF8 ,
		"ID_BB_GLOBAL_COMPANY_NAME" VARCHAR(255) UTF8 
);

enforce GLOBAL index on BLOOMBERG_FI.CORP_PFD_OUT(ID_BB_GLOBAL,DBTIMESTAMP);
enforce LOCAL index on BLOOMBERG_FI.CORP_PFD_OUT(ID_BB_GLOBAL,DATA_DATE);

CREATE TABLE "BLOOMBERG_FUTURES"."SHARE_FUTURES_PRICING_RPX" (
		"DATA_DATE" DATE ,
		"TICKER" VARCHAR(2000000) UTF8 ,
		"EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNIQUE_ID_FUT_OPT" VARCHAR(2000000) UTF8 ,
		"PARSEKYABLE_DES_SOURCE" VARCHAR(2000000) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP2" VARCHAR(2000000) UTF8 ,
		"FUTURES_CATEGORY" VARCHAR(2000000) UTF8 ,
		"FUTURES_NAME" VARCHAR(2000000) UTF8 ,
		"FEED_SOURCE" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(2000000) UTF8 ,
		"ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"FUT_PX_SESSION" VARCHAR(2000000) UTF8 ,
		"CRNCY" VARCHAR(2000000) UTF8 ,
		"ID_BB_COMPANY" DECIMAL(18,0) ,
		"PRICING_SOURCE" VARCHAR(2000000) UTF8 ,
		"QUOTED_CRNCY" VARCHAR(2000000) UTF8 ,
		"LAST_UPDATE" VARCHAR(2000000) UTF8 ,
		"LAST_UPDATE_DT" DATE ,
		"OPEN_INT_CHANGE" VARCHAR(2000000) UTF8 ,
		"OPEN_INT_DATE" VARCHAR(2000000) UTF8 ,
		"OPT_UNDL_PX" DOUBLE ,
		"PRIOR_CLOSE_ASK" DOUBLE ,
		"PRIOR_CLOSE_BID" DOUBLE ,
		"PRIOR_CLOSE_MID" DOUBLE ,
		"PX_ASK" DOUBLE ,
		"PX_BID" DOUBLE ,
		"PX_CLOSE_DT" DATE ,
		"PX_HIGH" DOUBLE ,
		"PX_LAST" DOUBLE ,
		"PX_LAST_ACTUAL" VARCHAR(2000000) UTF8 ,
		"PX_LAST_EOD" DOUBLE ,
		"PX_LOW" DOUBLE ,
		"PX_OPEN" DOUBLE ,
		"PX_SCALING_FACTOR" DOUBLE ,
		"PX_SETTLE" VARCHAR(2000000) UTF8 ,
		"PX_SETTLE_LAST_DT" DATE ,
		"PX_VOLUME" DECIMAL(18,0) ,
		"PX_VOLUME_1D" DECIMAL(18,0) ,
		"PX_YEST_DT" DATE ,
		"PX_YEST_HIGH" DOUBLE ,
		"PX_YEST_LOW" DOUBLE ,
		"SETTLE_DT" DATE ,
		"VOLUME_AVG_100D" VARCHAR(2000000) UTF8 ,
		"VOLUME_AVG_10D" DOUBLE ,
		"VOLUME_AVG_30D" DOUBLE ,
		"VOLUME_AVG_3M" DOUBLE ,
		"VOLUME_AVG_6M" DOUBLE ,
		"CONTRACT_VALUE" VARCHAR(2000000) UTF8 ,
		"DAILY_LIMIT_DOWN" VARCHAR(2000000) UTF8 ,
		"DAILY_LIMIT_UP" VARCHAR(2000000) UTF8 ,
		"FUT_AGGTE_OPEN_INT" DECIMAL(18,0) ,
		"FUT_CNVS_FACTOR" DOUBLE ,
		"FUT_CTD_PX" DOUBLE ,
		"FUT_EXCH_NAME_LONG" VARCHAR(2000000) UTF8 ,
		"FUT_NOTICE_FIRST" DATE ,
		"FUT_PX" DOUBLE ,
		"FUT_SEC_HEDGE_ML" VARCHAR(2000000) UTF8 ,
		"FUT_SEC_SPEC_ML" VARCHAR(2000000) UTF8 ,
		"OPEN_INT" DECIMAL(18,0) ,
		"OPEN_INT_TOTAL_CALL" DOUBLE ,
		"OPEN_INT_TOTAL_PUT" DOUBLE ,
		"PX_SETTLE_E_MINI_ACTUAL" DOUBLE ,
		"PX_YEST_CLOSE" VARCHAR(2000000) UTF8 ,
		"PX_YEST_OPEN" DOUBLE ,
		"PX_YEST_OPEN_INT" DOUBLE ,
		"QUOTE_UNITS" VARCHAR(2000000) UTF8 ,
		"STRATEGY_TYP" VARCHAR(2000000) UTF8 ,
		"QT_SPEC" VARCHAR(2000000) UTF8 ,
		"REGION" VARCHAR(10) UTF8 ,
		"FILE_NAME" VARCHAR(2000000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP 
);

enforce LOCAL index on BLOOMBERG_FUTURES.SHARE_FUTURES_PRICING_RPX(PARSEKYABLE_DES_SOURCE,DBTIMESTAMP);

CREATE TABLE "BLOOMBERG_FUTURES"."NON_SHARE_FUTURES_PRICING_RPX" (
		"DATA_DATE" DATE ,
		"TICKER" VARCHAR(2000000) UTF8 ,
		"EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNIQUE_ID_FUT_OPT" VARCHAR(2000000) UTF8 ,
		"PARSEKYABLE_DES_SOURCE" VARCHAR(2000000) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP2" VARCHAR(2000000) UTF8 ,
		"FUTURES_CATEGORY" VARCHAR(2000000) UTF8 ,
		"FUTURES_NAME" VARCHAR(2000000) UTF8 ,
		"FEED_SOURCE" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(2000000) UTF8 ,
		"ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"FUT_PX_SESSION" VARCHAR(2000000) UTF8 ,
		"CRNCY" VARCHAR(2000000) UTF8 ,
		"ID_BB_COMPANY" VARCHAR(2000000) UTF8 ,
		"PRICING_SOURCE" VARCHAR(2000000) UTF8 ,
		"QUOTED_CRNCY" VARCHAR(2000000) UTF8 ,
		"LAST_UPDATE" VARCHAR(2000000) UTF8 ,
		"LAST_UPDATE_DT" DATE ,
		"OPEN_INT_CHANGE" VARCHAR(2000000) UTF8 ,
		"OPEN_INT_DATE" VARCHAR(2000000) UTF8 ,
		"OPT_UNDL_PX" DOUBLE ,
		"PRIOR_CLOSE_ASK" VARCHAR(2000000) UTF8 ,
		"PRIOR_CLOSE_BID" VARCHAR(2000000) UTF8 ,
		"PRIOR_CLOSE_MID" VARCHAR(2000000) UTF8 ,
		"PX_ASK" VARCHAR(2000000) UTF8 ,
		"PX_BID" VARCHAR(2000000) UTF8 ,
		"PX_CLOSE_DT" DATE ,
		"PX_HIGH" VARCHAR(2000000) UTF8 ,
		"PX_LAST" VARCHAR(2000000) UTF8 ,
		"PX_LAST_ACTUAL" VARCHAR(2000000) UTF8 ,
		"PX_LAST_EOD" VARCHAR(2000000) UTF8 ,
		"PX_LOW" VARCHAR(2000000) UTF8 ,
		"PX_OPEN" VARCHAR(2000000) UTF8 ,
		"PX_SCALING_FACTOR" DOUBLE ,
		"PX_SETTLE" VARCHAR(2000000) UTF8 ,
		"PX_SETTLE_LAST_DT" DATE ,
		"PX_VOLUME" VARCHAR(2000000) UTF8 ,
		"PX_VOLUME_1D" VARCHAR(2000000) UTF8 ,
		"PX_YEST_DT" DATE ,
		"PX_YEST_HIGH" VARCHAR(2000000) UTF8 ,
		"PX_YEST_LOW" VARCHAR(2000000) UTF8 ,
		"SETTLE_DT" DATE ,
		"VOLUME_AVG_100D" VARCHAR(2000000) UTF8 ,
		"VOLUME_AVG_10D" DOUBLE ,
		"VOLUME_AVG_30D" DOUBLE ,
		"VOLUME_AVG_3M" DOUBLE ,
		"VOLUME_AVG_6M" DOUBLE ,
		"CONTRACT_VALUE" VARCHAR(2000000) UTF8 ,
		"DAILY_LIMIT_DOWN" VARCHAR(2000000) UTF8 ,
		"DAILY_LIMIT_UP" VARCHAR(2000000) UTF8 ,
		"FUT_AGGTE_OPEN_INT" VARCHAR(2000000) UTF8 ,
		"FUT_CNVS_FACTOR" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_PX" VARCHAR(2000000) UTF8 ,
		"FUT_EXCH_NAME_LONG" VARCHAR(2000000) UTF8 ,
		"FUT_NOTICE_FIRST" VARCHAR(2000000) UTF8 ,
		"FUT_PX" VARCHAR(2000000) UTF8 ,
		"FUT_SEC_HEDGE_ML" DOUBLE ,
		"FUT_SEC_SPEC_ML" DOUBLE ,
		"OPEN_INT" VARCHAR(2000000) UTF8 ,
		"OPEN_INT_TOTAL_CALL" DOUBLE ,
		"OPEN_INT_TOTAL_PUT" DOUBLE ,
		"PX_SETTLE_E_MINI_ACTUAL" VARCHAR(2000000) UTF8 ,
		"PX_YEST_CLOSE" VARCHAR(2000000) UTF8 ,
		"PX_YEST_OPEN" VARCHAR(2000000) UTF8 ,
		"PX_YEST_OPEN_INT" VARCHAR(2000000) UTF8 ,
		"QUOTE_UNITS" VARCHAR(2000000) UTF8 ,
		"STRATEGY_TYP" VARCHAR(2000000) UTF8 ,
		"QT_SPEC" VARCHAR(2000000) UTF8 ,
		"REGION" VARCHAR(10) UTF8 ,
		"FILE_NAME" VARCHAR(2000000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP 
);

enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_PRICING_RPX(DBTIMESTAMP,PARSEKYABLE_DES_SOURCE);

CREATE TABLE "BLOOMBERG_FUTURES"."SHARE_FUTURES_DATA_OUT" (
		"DATA_DATE" DATE ,
		"TICKER" VARCHAR(2000000) UTF8 ,
		"EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNIQUE_ID_FUT_OPT" VARCHAR(2000000) UTF8 ,
		"PARSEKYABLE_DES_SOURCE" VARCHAR(2000000) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP2" VARCHAR(2000000) UTF8 ,
		"FUTURES_CATEGORY" VARCHAR(2000000) UTF8 ,
		"FUTURES_NAME" VARCHAR(2000000) UTF8 ,
		"FEED_SOURCE" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_SRC" VARCHAR(2000000) UTF8 ,
		"ID_BB_SECURITY" DECIMAL(18,0) ,
		"ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"ID_EXCH_SYMBOL" VARCHAR(2000000) UTF8 ,
		"ID_FULL_EXCHANGE_SYMBOL" VARCHAR(2000000) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER" VARCHAR(2000000) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER_DES" VARCHAR(2000000) UTF8 ,
		"FUT_PX_SESSION" VARCHAR(2000000) UTF8 ,
		"ALT_INSTRUMENT_ID" VARCHAR(2000000) UTF8 ,
		"CASH_SETTLED" BOOLEAN ,
		"CDR_SETTLE_CODE" VARCHAR(2000000) UTF8 ,
		"CFI_CODE" VARCHAR(2000000) UTF8 ,
		"CNTRY_ISSUE_ISO" VARCHAR(2000000) UTF8 ,
		"COUNTRY_ISO" VARCHAR(2000000) UTF8 ,
		"CRNCY" VARCHAR(2000000) UTF8 ,
		"FUT_MONTH_YR" VARCHAR(2000000) UTF8 ,
		"FUT_TRADING_HRS" VARCHAR(2000000) UTF8 ,
		"FUT_TRADING_UNITS" VARCHAR(2000000) UTF8 ,
		"ID_BB_COMPANY" DECIMAL(18,0) ,
		"ID_BB_GLOBAL_COMPANY" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL_COMPANY_NAME" VARCHAR(2000000) UTF8 ,
		"ID_ISIN" VARCHAR(30) UTF8 ,
		"ID_MIC_PRIM_EXCH" VARCHAR(2000000) UTF8 ,
		"LAST_TRADEABLE_DT" DATE ,
		"LONG_COMP_NAME" VARCHAR(2000000) UTF8 ,
		"PRIMARY_EXCHANGE_NAME" VARCHAR(2000000) UTF8 ,
		"UNDERLYING_CUSIP" VARCHAR(17) UTF8 ,
		"UNDERLYING_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNDERLYING_ISIN" VARCHAR(30) UTF8 ,
		"UNDL_ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"QUOTED_CRNCY" VARCHAR(2000000) UTF8 ,
		"DUPLICATE_INDICATOR" BOOLEAN ,
		"FUT_CONT_SIZE" DOUBLE ,
		"FUT_CONTRACT_DT" DATE ,
		"FUT_CTD" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_CPN" DOUBLE ,
		"FUT_CTD_FREQ" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_ISIN" VARCHAR(30) UTF8 ,
		"FUT_CTD_MTY" DATE ,
		"FUT_CTD_NET_BASIS" DOUBLE ,
		"FUT_CTD_REAL_CUSIP" VARCHAR(17) UTF8 ,
		"FUT_DLV_DT_FIRST" DATE ,
		"FUT_DLV_DT_LAST" DATE ,
		"FUT_EXCH_NAME_LONG" VARCHAR(2000000) UTF8 ,
		"FUT_EXCH_NAME_SHRT" VARCHAR(2000000) UTF8 ,
		"FUT_FIRST_TRADE_DT" DATE ,
		"FUT_GEN_MONTH" VARCHAR(2000000) UTF8 ,
		"FUT_LONG_NAME" VARCHAR(2000000) UTF8 ,
		"FUT_NOTL_BOND" VARCHAR(2000000) UTF8 ,
		"FUT_ROLL_DT" DATE ,
		"QUOTE_UNITS" VARCHAR(2000000) UTF8 ,
		"STRATEGY_TYP" VARCHAR(2000000) UTF8 ,
		"UNDL_SPOT_TICKER" VARCHAR(2000000) UTF8 ,
		"INT_RATE_FUT_END_DT" DATE ,
		"INT_RATE_FUT_START_DT" DATE ,
		"FUT_TICK_SIZE" DOUBLE ,
		"FUT_TICK_VAL" DOUBLE ,
		"FUT_VAL_PT" VARCHAR(2000000) UTF8 ,
		"REGION" VARCHAR(10) UTF8 ,
		"FILE_NAME" VARCHAR(2000000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP 
);

enforce LOCAL index on BLOOMBERG_FUTURES.SHARE_FUTURES_DATA_OUT(UNIQUE_ID_FUT_OPT);
enforce LOCAL index on BLOOMBERG_FUTURES.SHARE_FUTURES_DATA_OUT(UNIQUE_ID_FUT_OPT,DATA_DATE);

CREATE TABLE "BLOOMBERG_FUTURES"."NON_SHARE_FUTURES_DATA_OUT" (
		"DATA_DATE" DATE ,
		"TICKER" VARCHAR(2000000) UTF8 ,
		"EXCH_CODE" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNIQUE_ID_FUT_OPT" VARCHAR(2000000) UTF8 ,
		"PARSEKYABLE_DES_SOURCE" VARCHAR(2000000) UTF8 ,
		"MARKET_SECTOR_DES" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP" VARCHAR(2000000) UTF8 ,
		"SECURITY_TYP2" VARCHAR(2000000) UTF8 ,
		"FUTURES_CATEGORY" VARCHAR(2000000) UTF8 ,
		"FUTURES_NAME" VARCHAR(2000000) UTF8 ,
		"FEED_SOURCE" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_DES" VARCHAR(2000000) UTF8 ,
		"ID_BB_SEC_NUM_SRC" VARCHAR(2000000) UTF8 ,
		"ID_BB_SECURITY" DECIMAL(18,0) ,
		"ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"ID_EXCH_SYMBOL" VARCHAR(2000000) UTF8 ,
		"ID_FULL_EXCHANGE_SYMBOL" VARCHAR(2000000) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER" VARCHAR(2000000) UTF8 ,
		"TRADING_SYSTEM_IDENTIFIER_DES" VARCHAR(2000000) UTF8 ,
		"FUT_PX_SESSION" VARCHAR(2000000) UTF8 ,
		"ALT_INSTRUMENT_ID" VARCHAR(2000000) UTF8 ,
		"CASH_SETTLED" BOOLEAN ,
		"CDR_SETTLE_CODE" VARCHAR(2000000) UTF8 ,
		"CFI_CODE" VARCHAR(2000000) UTF8 ,
		"CNTRY_ISSUE_ISO" VARCHAR(2000000) UTF8 ,
		"COUNTRY_ISO" VARCHAR(2000000) UTF8 ,
		"CRNCY" VARCHAR(2000000) UTF8 ,
		"FUT_MONTH_YR" VARCHAR(2000000) UTF8 ,
		"FUT_TRADING_HRS" VARCHAR(2000000) UTF8 ,
		"FUT_TRADING_UNITS" VARCHAR(2000000) UTF8 ,
		"ID_BB_COMPANY" DECIMAL(18,0) ,
		"ID_BB_GLOBAL_COMPANY" VARCHAR(2000000) UTF8 ,
		"ID_BB_GLOBAL_COMPANY_NAME" VARCHAR(2000000) UTF8 ,
		"ID_ISIN" VARCHAR(30) UTF8 ,
		"ID_MIC_PRIM_EXCH" VARCHAR(2000000) UTF8 ,
		"LAST_TRADEABLE_DT" DATE ,
		"LONG_COMP_NAME" VARCHAR(2000000) UTF8 ,
		"PRIMARY_EXCHANGE_NAME" VARCHAR(2000000) UTF8 ,
		"UNDERLYING_CUSIP" VARCHAR(17) UTF8 ,
		"UNDERLYING_ID_BB_GLOBAL" VARCHAR(40) UTF8 ,
		"UNDERLYING_ISIN" VARCHAR(30) UTF8 ,
		"UNDL_ID_BB_UNIQUE" VARCHAR(40) UTF8 ,
		"QUOTED_CRNCY" VARCHAR(2000000) UTF8 ,
		"DUPLICATE_INDICATOR" BOOLEAN ,
		"FUT_CONT_SIZE" DOUBLE ,
		"FUT_CONTRACT_DT" DATE ,
		"FUT_CTD" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_CPN" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_FREQ" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_ISIN" VARCHAR(30) UTF8 ,
		"FUT_CTD_MTY" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_NET_BASIS" VARCHAR(2000000) UTF8 ,
		"FUT_CTD_REAL_CUSIP" VARCHAR(17) UTF8 ,
		"FUT_DLV_DT_FIRST" DATE ,
		"FUT_DLV_DT_LAST" DATE ,
		"FUT_EXCH_NAME_LONG" VARCHAR(2000000) UTF8 ,
		"FUT_EXCH_NAME_SHRT" VARCHAR(2000000) UTF8 ,
		"FUT_FIRST_TRADE_DT" DATE ,
		"FUT_GEN_MONTH" VARCHAR(2000000) UTF8 ,
		"FUT_LONG_NAME" VARCHAR(2000000) UTF8 ,
		"FUT_NOTL_BOND" VARCHAR(2000000) UTF8 ,
		"FUT_ROLL_DT" DATE ,
		"QUOTE_UNITS" VARCHAR(2000000) UTF8 ,
		"STRATEGY_TYP" VARCHAR(2000000) UTF8 ,
		"UNDL_SPOT_TICKER" VARCHAR(2000000) UTF8 ,
		"INT_RATE_FUT_END_DT" DATE ,
		"INT_RATE_FUT_START_DT" DATE ,
		"FUT_TICK_SIZE" DOUBLE ,
		"FUT_TICK_VAL" VARCHAR(2000000) UTF8 ,
		"FUT_VAL_PT" VARCHAR(2000000) UTF8 ,
		"REGION" VARCHAR(10) UTF8 ,
		"FILE_NAME" VARCHAR(2000000) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP 
);

enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(ID_BB_GLOBAL,DATA_DATE,FUT_PX_SESSION);
enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(ID_BB_GLOBAL,FUT_PX_SESSION);
enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(ID_BB_GLOBAL,DATA_DATE,UNIQUE_ID_FUT_OPT);
enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(ID_BB_GLOBAL,DATA_DATE);
enforce GLOBAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(TICKER);
enforce LOCAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(DATA_DATE,ID_BB_GLOBAL,FUT_PX_SESSION);
enforce LOCAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(TICKER,FUT_PX_SESSION,MARKET_SECTOR_DES);
enforce LOCAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(TICKER,FUT_PX_SESSION);
enforce LOCAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(DATA_DATE,ID_BB_GLOBAL,UNIQUE_ID_FUT_OPT);
enforce LOCAL index on BLOOMBERG_FUTURES.NON_SHARE_FUTURES_DATA_OUT(UNIQUE_ID_FUT_OPT);


CREATE TABLE "BPIPE_RT"."REAL_TIME" (
		"DATA_DATE" DATE ,
		"DATA_RECEIVED_TIMESTAMP" TIMESTAMP ,
		"TICKER" VARCHAR(50) UTF8 ,
		"LAST_PRICE" DECIMAL(30,6) ,
		"SIZE_LAST_TRADE" DECIMAL(36,0) ,
		"DBTIMESTAMP" TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
		"PX_YEST_CLOSE" DECIMAL(30,6) ,
		"CRNCY" VARCHAR(3) UTF8 ,
		"VOLUME_TDY" DECIMAL(30,0) ,
		"5_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"20_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"30_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"LAST_PRICE_TIME_TODAY_REALTIME" TIMESTAMP ,
		"TRADING_DT_REALTIME" DATE ,
		"PX_YEST_DT" DATE 
);

enforce GLOBAL index on BPIPE_RT.REAL_TIME(TICKER,DBTIMESTAMP);
enforce LOCAL index on BPIPE_RT.REAL_TIME(TICKER,DATA_RECEIVED_TIMESTAMP);
enforce LOCAL index on BPIPE_RT.REAL_TIME(TICKER);
enforce LOCAL index on BPIPE_RT.REAL_TIME(TICKER,DBTIMESTAMP);

CREATE TABLE "BPIPE_RT"."REAL_TIME_FUTURES" (
		"DATA_DATE" DATE ,
		"DATA_RECEIVED_TIMESTAMP" TIMESTAMP ,
		"TICKER" VARCHAR(50) UTF8 ,
		"LAST_PRICE" DECIMAL(30,6) ,
		"SIZE_LAST_TRADE" DECIMAL(36,0) ,
		"DBTIMESTAMP" TIMESTAMP ,
		"VOLUME_TDY" DECIMAL(30,0) ,
		"5_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"20_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"30_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"LAST_PRICE_TIME_TODAY_REALTIME" TIMESTAMP ,
		"TRADING_DT_REALTIME" DATE ,
		"PX_YEST_DT" DATE ,
		"ASK" DECIMAL(30,6) ,
		"BID" DECIMAL(30,6) ,
		"VOLUME" DECIMAL(30,6) ,
		"LAST_TRADE_PRICE_TIME_TODAY_RT" TIMESTAMP ,
		"CRNCY" VARCHAR(50) UTF8 
);

enforce LOCAL index on BPIPE_RT.REAL_TIME_FUTURES(TICKER);
enforce LOCAL index on BPIPE_RT.REAL_TIME_FUTURES(TICKER,DBTIMESTAMP);
enforce LOCAL index on BPIPE_RT.REAL_TIME_FUTURES(DATA_DATE);
enforce LOCAL index on BPIPE_RT.REAL_TIME_FUTURES(DATA_RECEIVED_TIMESTAMP,TICKER);

CREATE TABLE "BPIPE_RT"."REAL_TIME_CORP_PFD" (
		"DATA_DATE" DATE ,
		"DATA_RECEIVED_TIMESTAMP" TIMESTAMP ,
		"ID_BB_GLOBAL" VARCHAR(12) UTF8 ,
		"LAST_PRICE" DECIMAL(30,6) ,
		"SIZE_LAST_TRADE" DECIMAL(36,0) ,
		"DBTIMESTAMP" TIMESTAMP ,
		"VOLUME_TDY" DECIMAL(30,0) ,
		"5_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"20_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"30_DAY_AVERAGE_VOLUME_AT_TIME_RT" DECIMAL(36,6) ,
		"LAST_PRICE_TIME_TODAY_REALTIME" TIMESTAMP ,
		"TRADING_DT_REALTIME" DATE ,
		"PX_YEST_DT" DATE ,
		"ASK" DECIMAL(30,6) ,
		"BID" DECIMAL(30,6) ,
		"VOLUME" DECIMAL(30,6) ,
		"LAST_TRADE_PRICE_TIME_TODAY_RT" TIMESTAMP ,
		"PX_YEST_CLOSE" DECIMAL(30,6) 
);

enforce LOCAL index on BPIPE_RT.REAL_TIME_CORP_PFD(DATA_RECEIVED_TIMESTAMP,ID_BB_GLOBAL);

CREATE OR REPLACE VIEW BARRA.BARRA_FX_RATES_WITH_MINOR_CURRENCIES  AS 
SELECT DDATE, CURRENCY_CODE, FX_RATE, RF_RATE FROM BARRA.BARRA_FX_RATES
UNION ALL 
SELECT A.DDATE, B.MINOR_CURRENCY AS CURRENCY_CODE, A.FX_RATE/B.RATE AS FX_RATE, A.RF_RATE 
FROM BARRA.BARRA_FX_RATES A 
JOIN BARRA.MINOR_MAJOR_CURRENCY_MAPPING B 
ON A.CURRENCY_CODE = B.MAJOR_CURRENCY;


CREATE TABLE "BARRA"."BARRA_FX_RATES" (
		"DDATE" DATE ,
		"CURRENCY_CODE" VARCHAR(3) UTF8 ,
		"FX_RATE" DOUBLE ,
		"RF_RATE" DOUBLE 
);

enforce LOCAL index on BARRA.BARRA_FX_RATES(DDATE);
enforce LOCAL index on BARRA.BARRA_FX_RATES(CURRENCY_CODE);


CREATE TABLE "BARRA"."MINOR_MAJOR_CURRENCY_MAPPING" (
		"MINOR_CURRENCY" VARCHAR(3) UTF8 ,
		"MAJOR_CURRENCY" VARCHAR(3) UTF8 ,
		"RATE" DECIMAL(20,5) 
);

CREATE TABLE "EQUITY_SEC_MASTER"."EXCH_TO_REGION_MAP" (
		"XP_EXCH" VARCHAR(32) UTF8 NOT NULL ,
		"BB_EXCH" VARCHAR(32) UTF8 ,
		"XP_REGION" VARCHAR(32) UTF8 ,
		"EXCH_NAME" VARCHAR(512) UTF8 ,
		"EXCH_COUNTRY" VARCHAR(64) UTF8 
);
;

ALTER TABLE EQUITY_SEC_MASTER.EXCH_TO_REGION_MAP ADD CONSTRAINT EXCH_TO_REGION_MAP_PK PRIMARY KEY ("XP_EXCH")  ENABLE ;

CREATE TABLE "COMMON"."DATA_JOB_STATUS" (
		"DATA_DATE" DATE NOT NULL ,
		"VENDOR" VARCHAR(50) UTF8 ,
		"REGION" VARCHAR(50) UTF8 ,
		"TABLE_NAME" VARCHAR(128) UTF8 NOT NULL ,
		"TABLE_SCHEMA" VARCHAR(50) UTF8 NOT NULL ,
		"STATUS" VARCHAR(10) UTF8 ,
		"DBTIMESTAMP" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL 
);

enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,REGION,TABLE_NAME,TABLE_SCHEMA);
enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,VENDOR,REGION,TABLE_NAME,TABLE_SCHEMA);
enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,TABLE_NAME,TABLE_SCHEMA,STATUS);
enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,REGION,TABLE_NAME,TABLE_SCHEMA,STATUS);
enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,VENDOR,REGION,TABLE_NAME,TABLE_SCHEMA,STATUS);
enforce GLOBAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,VENDOR,TABLE_NAME,TABLE_SCHEMA,STATUS);
enforce LOCAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,TABLE_NAME,TABLE_SCHEMA);
enforce LOCAL index on COMMON.DATA_JOB_STATUS(DATA_DATE);
enforce LOCAL index on COMMON.DATA_JOB_STATUS(DATA_DATE,VENDOR,TABLE_NAME);


