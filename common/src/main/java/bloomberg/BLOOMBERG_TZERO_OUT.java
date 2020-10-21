package bloomberg;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.metadata.index.SpaceIndexType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "BLOOMBERG_TZERO_OUT")
@SpaceClass
public class BLOOMBERG_TZERO_OUT {

    private String id;
    private Date DDATE;
    private String REGION;
    private String ID_BB_PARSEKEY;
    private String EXCH_CODE;
    private String NAME;
    private String CRNCY;
    private String FLEX_ID;
    private String ID_BB_GLOBAL;
    private String ID_SEDOL1;
    private String ID_SEDOL2;
    private String SECURITY_TYP;
    private String EQY_SH_OUT;
    private String ID_BB_GLOBAL_COMPANY;

    public BLOOMBERG_TZERO_OUT() {
    }

    public BLOOMBERG_TZERO_OUT(Date DDATE, String REGION, String ID_BB_PARSEKEY, String EXCH_CODE, String NAME, String CRNCY, String FLEX_ID, String ID_BB_GLOBAL, String ID_SEDOL1, String ID_SEDOL2, String SECURITY_TYP, String EQY_SH_OUT, String ID_BB_GLOBAL_COMPANY) {
        this.DDATE = DDATE;
        this.REGION = REGION;
        this.ID_BB_PARSEKEY = ID_BB_PARSEKEY;
        this.EXCH_CODE = EXCH_CODE;
        this.NAME = NAME;
        this.CRNCY = CRNCY;
        this.FLEX_ID = FLEX_ID;
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
        this.ID_SEDOL1 = ID_SEDOL1;
        this.ID_SEDOL2 = ID_SEDOL2;
        this.SECURITY_TYP = SECURITY_TYP;
        this.EQY_SH_OUT = EQY_SH_OUT;
        this.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY;
    }

    @Id
    @SpaceId
    @SpaceIndex(unique = true)
    @Column(name = "Id")
    public String getId() {
        return getDDATE().toString() + BLOOMBERG_TZERO_OUT.class.getName().hashCode();
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DDATE")
    public Date getDDATE() {
        return DDATE;
    }

    public void setDDATE(Date DDATE) {
        this.DDATE = DDATE;
    }

    @SpaceIndex(type = SpaceIndexType.EQUAL)
    @Column(name = "REGION")
    public String getREGION() {
        return REGION;
    }
    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    @Column(name = "ID_BB_PARSEKEY")
    public String getID_BB_PARSEKEY() {
        return ID_BB_PARSEKEY;
    }
    public void setID_BB_PARSEKEY(String ID_BB_PARSEKEY) {
        this.ID_BB_PARSEKEY = ID_BB_PARSEKEY;
    }

    @Column(name = "EXCH_CODE")
    public String getEXCH_CODE() {
        return EXCH_CODE;
    }
    public void setEXCH_CODE(String EXCH_CODE) {
        this.EXCH_CODE = EXCH_CODE;
    }

    @Column(name = "NAME")
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Column(name = "CRNCY")
    public String getCRNCY() {
        return CRNCY;
    }
    public void setCRNCY(String CRNCY) {
        this.CRNCY = CRNCY;
    }

    @Column(name = "FLEX_ID")
    public String getFLEX_ID() {
        return FLEX_ID;
    }
    public void setFLEX_ID(String FLEX_ID) {
        this.FLEX_ID = FLEX_ID;
    }

    @Column(name = "ID_BB_GLOBAL")
    public String getID_BB_GLOBAL() {
        return ID_BB_GLOBAL;
    }
    public void setID_BB_GLOBAL(String ID_BB_GLOBAL) {
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
    }

    @Column(name = "ID_SEDOL1")
    public String getID_SEDOL1() {
        return ID_SEDOL1;
    }
    public void setID_SEDOL1(String ID_SEDOL1) {
        this.ID_SEDOL1 = ID_SEDOL1;
    }

    @Column(name = "ID_SEDOL2")
    public String getID_SEDOL2() {
        return ID_SEDOL2;
    }
    public void setID_SEDOL2(String ID_SEDOL2) {
        this.ID_SEDOL2 = ID_SEDOL2;
    }

    @Column(name = "SECURITY_TYP")
    public String getSECURITY_TYP() {
        return SECURITY_TYP;
    }
    public void setSECURITY_TYP(String SECURITY_TYP) {
        this.SECURITY_TYP = SECURITY_TYP;
    }

    @Column(name = "EQY_SH_OUT")
    public String getEQY_SH_OUT() {
        return EQY_SH_OUT;
    }
    public void setEQY_SH_OUT(String EQY_SH_OUT) {
        this.EQY_SH_OUT = EQY_SH_OUT;
    }

    @Column(name = "ID_BB_GLOBAL_COMPANY")
    public String getID_BB_GLOBAL_COMPANY() {
        return ID_BB_GLOBAL_COMPANY;
    }
    public void setID_BB_GLOBAL_COMPANY(String ID_BB_GLOBAL_COMPANY) {
        this.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY;
    }

}

