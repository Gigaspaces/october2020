package bpipe_rt;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = "REAL_TIME")
@SpaceClass
public class REAL_TIME implements PartitionedTable {
    private String id;
    private Date DATA_DATE;
    private long DATA_RECEIVED_TIMESTAMP;
    private String TICKER;
    private BigDecimal LAST_PRICE;
    private BigDecimal SIZE_LAST_TRADE;
    private long DBTIMESTAMP;
    private String CRNCY;
    private BigDecimal VOLUME_TDY;
    private BigDecimal AVERAGE_VOLUME_AT_TIME_RT_5_DAYS;
    private BigDecimal AVERAGE_VOLUME_AT_TIME_RT_20_DAYS;
    private BigDecimal AVERAGE_VOLUME_AT_TIME_RT_30_DAYS;
    private long LAST_PRICE_TIME_TODAY_REALTIME;
    private long TRADING_DT_REALTIME;
    private long PX_YEST_DT;
    private BigDecimal PX_YEST_CLOSE;

    public REAL_TIME() {
    }

    @Id
    @SpaceId(autoGenerate = true)
    @SpaceIndex(unique = true)
    @Column(name = "Id")
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DATA_DATE")
    @Override
    public Date getDATA_DATE() {
        return DATA_DATE;
    }

    @Override
    public void setDATA_DATE(Date DATA_DATE) {
        this.DATA_DATE = DATA_DATE;
    }

    @SpaceIndex(type = SpaceIndexType.ORDERED)
    @Column(name = "DATA_RECEIVED_TIMESTAMP")
    @Override
    public long getDATA_RECEIVED_TIMESTAMP() {
        return DATA_RECEIVED_TIMESTAMP;
    }

    @Override
    public void setDATA_RECEIVED_TIMESTAMP(long DATA_RECEIVED_TIMESTAMP) {
        this.DATA_RECEIVED_TIMESTAMP = DATA_RECEIVED_TIMESTAMP;
    }

    @SpaceIndex(type = SpaceIndexType.EQUAL)
    @SpaceRouting
    @Column(name = "TICKER")
    @Override
    public String getTICKER() {
        return TICKER;
    }

    @Override
    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    @Column(name = "LAST_PRICE", precision = 30, scale = 6)
    @Override
    public BigDecimal getLAST_PRICE() {
        return LAST_PRICE;
    }

    @Override
    public void setLAST_PRICE(BigDecimal LAST_PRICE) {
        this.LAST_PRICE = LAST_PRICE;
    }

    @Column(name = "SIZE_LAST_TRADE", precision = 36)
    @Override
    public BigDecimal getSIZE_LAST_TRADE() {
        return SIZE_LAST_TRADE;
    }

    @Override
    public void setSIZE_LAST_TRADE(BigDecimal SIZE_LAST_TRADE) {
        this.SIZE_LAST_TRADE = SIZE_LAST_TRADE;
    }

    @Column(name = "DBTIMESTAMP")
    @Override
    public long getDBTIMESTAMP() {
        return DBTIMESTAMP;
    }
    @Override
    public void setDBTIMESTAMP(long DBTIMESTAMP) {
        this.DBTIMESTAMP = DBTIMESTAMP;
    }

    @Column(name = "CRNCY")
    @Override
    public String getCRNCY() {
        return CRNCY;
    }

    @Override
    public void setCRNCY(String CRNCY) {
        this.CRNCY = CRNCY;
    }

    @Column(name = "VOLUME_TDY", precision = 30)
    @Override
    public BigDecimal getVOLUME_TDY() {
        return VOLUME_TDY;
    }

    @Override
    public void setVOLUME_TDY(BigDecimal VOLUME_TDY) {
        this.VOLUME_TDY = VOLUME_TDY;
    }

    @Column(name = "AVERAGE_VOLUME_AT_TIME_RT_5_DAYS", precision = 36, scale = 6)
    @Override
    public BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_5_DAYS() {
        return AVERAGE_VOLUME_AT_TIME_RT_5_DAYS;
    }

    @Override
    public void setAVERAGE_VOLUME_AT_TIME_RT_5_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_5_DAYS) {
        this.AVERAGE_VOLUME_AT_TIME_RT_5_DAYS = AVERAGE_VOLUME_AT_TIME_RT_5_DAYS;
    }

    @Column(name = "AVERAGE_VOLUME_AT_TIME_RT_20_DAYS", precision = 36, scale = 6)
    public BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_20_DAYS() {
        return AVERAGE_VOLUME_AT_TIME_RT_20_DAYS;
    }

    @Override
    public void setAVERAGE_VOLUME_AT_TIME_RT_20_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_20_DAYS) {
        this.AVERAGE_VOLUME_AT_TIME_RT_20_DAYS = AVERAGE_VOLUME_AT_TIME_RT_20_DAYS;
    }


    @Column(name = "AVERAGE_VOLUME_AT_TIME_RT_30_DAYS", precision = 36, scale = 6)
    @Override
    public BigDecimal getAVERAGE_VOLUME_AT_TIME_RT_30_DAYS() {
        return AVERAGE_VOLUME_AT_TIME_RT_30_DAYS;
    }

    @Override
    public void setAVERAGE_VOLUME_AT_TIME_RT_30_DAYS(BigDecimal AVERAGE_VOLUME_AT_TIME_RT_30_DAYS) {
        this.AVERAGE_VOLUME_AT_TIME_RT_30_DAYS = AVERAGE_VOLUME_AT_TIME_RT_30_DAYS;
    }


    @Column(name = "LAST_PRICE_TIME_TODAY_REALTIME")
    @Override
    public long getLAST_PRICE_TIME_TODAY_REALTIME() {
        return LAST_PRICE_TIME_TODAY_REALTIME;
    }

    @Override
    public void setLAST_PRICE_TIME_TODAY_REALTIME(long LAST_PRICE_TIME_TODAY_REALTIME) {
        this.LAST_PRICE_TIME_TODAY_REALTIME = LAST_PRICE_TIME_TODAY_REALTIME;
    }

    @Column(name = "TRADING_DT_REALTIME")
    @Override
    public long getTRADING_DT_REALTIME() {
        return TRADING_DT_REALTIME;
    }

    @Override
    public void setTRADING_DT_REALTIME(long TRADING_DT_REALTIME) {
        this.TRADING_DT_REALTIME = TRADING_DT_REALTIME;
    }

    @Column(name = "PX_YEST_DT")
    @Override
    public long getPX_YEST_DT() {
        return PX_YEST_DT;
    }

    @Override
    public void setPX_YEST_DT(long PX_YEST_DT) {
        this.PX_YEST_DT = PX_YEST_DT;
    }

    @Column(name = "PX_YEST_CLOSE", precision = 30, scale = 6)
    public BigDecimal getPX_YEST_CLOSE() {
        return PX_YEST_CLOSE;
    }

    public void setPX_YEST_CLOSE(BigDecimal PX_YEST_CLOSE) {
        this.PX_YEST_CLOSE = PX_YEST_CLOSE;
    }
}

