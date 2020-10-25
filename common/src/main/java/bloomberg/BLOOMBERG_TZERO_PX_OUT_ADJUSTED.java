package bloomberg;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "BLOOMBERG_TZERO_PX_OUT_ADJUSTED")
@SpaceClass
public class BLOOMBERG_TZERO_PX_OUT_ADJUSTED {
    private String id;
    private Date OPEN_DATE;
    private String ID_BB_GLOBAL;
    private String CLOSE_PX_ADJ; // find the type

    public BLOOMBERG_TZERO_PX_OUT_ADJUSTED() {
    }

    public BLOOMBERG_TZERO_PX_OUT_ADJUSTED(Date OPEN_DATE, String ID_BB_GLOBAL, String CLOSE_PX_ADJ) {
        this.OPEN_DATE = OPEN_DATE;
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
        this.CLOSE_PX_ADJ = CLOSE_PX_ADJ;
    }

    @Id
    @SpaceId(autoGenerate = true)
    @Column(name = "Id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "OPEN_DATE")
    public Date getOPEN_DATE() {
        return OPEN_DATE;
    }

    public void setOPEN_DATE(Date OPEN_DATE) {
        this.OPEN_DATE = OPEN_DATE;
    }

    @Column(name = "ID_BB_GLOBAL")
    public String getID_BB_GLOBAL() {
        return ID_BB_GLOBAL;
    }
    public void setID_BB_GLOBAL(String ID_BB_GLOBAL) {
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
    }


    @Column(name = "CLOSE_PX_ADJ")
    public String getCLOSE_PX_ADJ() {
        return CLOSE_PX_ADJ;
    }
    public void setCLOSE_PX_ADJ(String CLOSE_PX_ADJ) {
        this.CLOSE_PX_ADJ = CLOSE_PX_ADJ;
    }

}
