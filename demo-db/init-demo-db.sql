# Script for creating demo schema and data
CREATE TABLE BARRA_FX_RATES_WITH_MINOR_CURRENCIES(Id VARCHAR(100) PRIMARY KEY,DDATE BIGINT,CURRENCY_CODE VARCHAR(20),FX_RATE DOUBLE, RF_RATE DOUBLE, Routing INTEGER)