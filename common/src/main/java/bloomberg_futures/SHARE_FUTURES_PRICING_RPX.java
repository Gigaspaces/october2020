package bloomberg_futures;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "SHARE_FUTURES_PRICING_RPX")
@SpaceClass
public class SHARE_FUTURES_PRICING_RPX {
    private String id;
    private String PARSEKYABLE_DES_SOURCE;
    private String PX_YEST_CLOSE;
    private long DBTIMESTAMP; //TIMESTAMP ??
    private java.sql.Date DATA_DATE;

    public SHARE_FUTURES_PRICING_RPX() {
    }

    public SHARE_FUTURES_PRICING_RPX(String PARSEKYABLE_DES_SOURCE, String PX_YEST_CLOSE, long DBTIMESTAMP, Date DATA_DATE) {
        this.PARSEKYABLE_DES_SOURCE = PARSEKYABLE_DES_SOURCE;
        this.PX_YEST_CLOSE = PX_YEST_CLOSE;
        this.DBTIMESTAMP = DBTIMESTAMP;
        this.DATA_DATE = DATA_DATE;
    }

    @SpaceId(autoGenerate = true)
    @Column(name = "Id")
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PARSEKYABLE_DES_SOURCE")
    public String getPARSEKYABLE_DES_SOURCE() {
        return PARSEKYABLE_DES_SOURCE;
    }

    public void setPARSEKYABLE_DES_SOURCE(String PARSEKYABLE_DES_SOURCE) {
        this.PARSEKYABLE_DES_SOURCE = PARSEKYABLE_DES_SOURCE;
    }

    @Column(name = "PX_YEST_CLOSE")
    public String getPX_YEST_CLOSE() {
        return PX_YEST_CLOSE;
    }

    public void setPX_YEST_CLOSE(String PX_YEST_CLOSE) {
        this.PX_YEST_CLOSE = PX_YEST_CLOSE;
    }

    @Column(name = "DBTIMESTAMP")
    public long getDBTIMESTAMP() {
        return DBTIMESTAMP;
    }

    public void setDBTIMESTAMP(long DBTIMESTAMP) {
        this.DBTIMESTAMP = DBTIMESTAMP;
    }

    @Column(name = "DATA_DATE")
    public Date getDATA_DATE() {
        return DATA_DATE;
    }

    public void setDATA_DATE(Date DATA_DATE) {
        this.DATA_DATE = DATA_DATE;
    }
}
