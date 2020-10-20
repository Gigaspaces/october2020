package bpipe_rt;

import java.math.BigDecimal;
import java.sql.Date;

public interface PartitionedTable {
    String getId();
    void setId(String id);

    Date getDATA_DATE();
    void setDATA_DATE(Date DATA_DATE);

    long getDATA_RECEIVED_TIMESTAMP();
    void setDATA_RECEIVED_TIMESTAMP(long DATA_RECEIVED_TIMESTAMP);

    String getTICKER();
    void setTICKER(String TICKER);

    BigDecimal getLAST_PRICE();
    void setLAST_PRICE(BigDecimal LAST_PRICE);

    BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_5_DAYS();
    void setAVERAGE_VOLUME_AT_TIME_RT_5_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_5_DAYS) ;

    BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_20_DAYS();
    void setAVERAGE_VOLUME_AT_TIME_RT_20_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_20_DAYS);

    BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_30_DAYS();
    void setAVERAGE_VOLUME_AT_TIME_RT_30_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_30_DAYS);

    long getTRADING_DT_REALTIME();
    void setTRADING_DT_REALTIME(long TRADING_DT_REALTIME);

    long getPX_YEST_DT();
    void setPX_YEST_DT(long PX_YEST_DT);

    String getCRNCY();
    void setCRNCY(String CRNCY) ;

    BigDecimal getVOLUME_TDY();
    void setVOLUME_TDY(BigDecimal VOLUME);

    BigDecimal getSIZE_LAST_TRADE();
    void setSIZE_LAST_TRADE(BigDecimal VOLUME);

    long getLAST_PRICE_TIME_TODAY_REALTIME();
    void setLAST_PRICE_TIME_TODAY_REALTIME(long LAST_PRICE_TIME_TODAY_REALTIME);

    long getDBTIMESTAMP();
    void setDBTIMESTAMP(long DBTIMESTAMP);


}
