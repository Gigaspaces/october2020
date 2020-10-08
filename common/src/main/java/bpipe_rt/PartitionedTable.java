package bpipe_rt;

import java.math.BigDecimal;

public interface PartitionedTable {
    String getId();

    void setId(String id);


    long getDATA_DATE();

    void setDATA_DATE(long DATA_DATE);

    long getDATA_RECEIVED_TIMESTAMP();
    void setDATA_RECEIVED_TIMESTAMP(long DATA_RECEIVED_TIMESTAMP);

    String getTICKER();

    void setTICKER(String TICKER);

    BigDecimal getLAST_PRICE();

    void setLAST_PRICE(BigDecimal LAST_PRICE);

    BigDecimal get_5_DAY_AVERAGE_VOLUME_AT_TIME_RT();
    void set_5_DAY_AVERAGE_VOLUME_AT_TIME_RT(BigDecimal _5_DAY_AVERAGE_VOLUME_AT_TIME_RT) ;

    BigDecimal get_20_DAY_AVERAGE_VOLUME_AT_TIME_RT();
    void set_20_DAY_AVERAGE_VOLUME_AT_TIME_RT(BigDecimal _20_DAY_AVERAGE_VOLUME_AT_TIME_RT);
    BigDecimal get_30_DAY_AVERAGE_VOLUME_AT_TIME_RT();
    void set_30_DAY_AVERAGE_VOLUME_AT_TIME_RT(BigDecimal _30_DAY_AVERAGE_VOLUME_AT_TIME_RT);
    long getTRADING_DT_REALTIME();
    void setTRADING_DT_REALTIME(long TRADING_DT_REALTIME);
    long getPX_YEST_DT();
    void setPX_YEST_DT(long PX_YEST_DT);
    String getCRNCY();
    void setCRNCY(String CRNCY) ;
    BigDecimal getVOLUME();

    void setVOLUME(BigDecimal VOLUME);

}
