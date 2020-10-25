package bloomberg_fi;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "CORP_PFD_OUT")
@SpaceClass
public class CORP_PFD_OUT {

    private String id;
    private String CRNCY;
    private String ID_BB_GLOBAL;
    private String EXCH_CODE;
    private String ID_SEDOL1;
    private String ID_SEDOL2;
    private String NAME;
    private String ID_BB_GLOBAL_COMPANY;
    private String SECURITY_TYP;
    private String MARKET_SECTOR_DES;
    private String COUNTRY;
    private String CALLED_BOOL;
    private String ID_BB_SEC_NUM_DES;
    private String REGION;
    private Double AMT_OUTSTANDING;
    private Date DATA_DATE;

    public CORP_PFD_OUT() {
    }

    public CORP_PFD_OUT(String CRNCY, String ID_BB_GLOBAL, String EXCH_CODE, String ID_SEDOL1, String ID_SEDOL2, String NAME, String ID_BB_GLOBAL_COMPANY, String SECURITY_TYP, String MARKET_SECTOR_DES, String COUNTRY, String CALLED_BOOL, String ID_BB_SEC_NUM_DES, String REGION, Double AMT_OUTSTANDING, Date DATA_DATE) {
        this.CRNCY = CRNCY;
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
        this.EXCH_CODE = EXCH_CODE;
        this.ID_SEDOL1 = ID_SEDOL1;
        this.ID_SEDOL2 = ID_SEDOL2;
        this.NAME = NAME;
        this.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY;
        this.SECURITY_TYP = SECURITY_TYP;
        this.MARKET_SECTOR_DES = MARKET_SECTOR_DES;
        this.COUNTRY = COUNTRY;
        this.CALLED_BOOL = CALLED_BOOL;
        this.ID_BB_SEC_NUM_DES = ID_BB_SEC_NUM_DES;
        this.REGION = REGION;
        this.AMT_OUTSTANDING = AMT_OUTSTANDING;
        this.DATA_DATE = DATA_DATE;
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

    @Column(name = "DATA_DATE")
    public Date getDATA_DATE() {
        return DATA_DATE;
    }

    public void setDATA_DATE(Date DATA_DATE) {
        this.DATA_DATE = DATA_DATE;
    }

    @Column(name = "MARKET_SECTOR_DES")
    public String getMARKET_SECTOR_DES() {
        return MARKET_SECTOR_DES;
    }

    public void setMARKET_SECTOR_DES(String MARKET_SECTOR_DES) {
        this.MARKET_SECTOR_DES = MARKET_SECTOR_DES;
    }

    @Column(name = "COUNTRY")
    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
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

    @Column(name = "CALLED_BOOL")
    public String getCALLED_BOOL() {
        return CALLED_BOOL;
    }

    public void setCALLED_BOOL(String CALLED_BOOL) {
        this.CALLED_BOOL = CALLED_BOOL;
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

    @Column(name = "AMT_OUTSTANDING")
    public Double getAMT_OUTSTANDING() {
        return AMT_OUTSTANDING;
    }

    public void setAMT_OUTSTANDING(Double AMT_OUTSTANDING) {
        this.AMT_OUTSTANDING = AMT_OUTSTANDING;
    }

    @Column(name = "ID_BB_GLOBAL_COMPANY")
    public String getID_BB_GLOBAL_COMPANY() {
        return ID_BB_GLOBAL_COMPANY;
    }

    public void setID_BB_GLOBAL_COMPANY(String ID_BB_GLOBAL_COMPANY) {
        this.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY;
    }

    @Column(name = "ID_BB_SEC_NUM_DES")
    public String getID_BB_SEC_NUM_DES() {
        return ID_BB_SEC_NUM_DES;
    }

    public void setID_BB_SEC_NUM_DES(String ID_BB_SEC_NUM_DES) {
        this.ID_BB_SEC_NUM_DES = ID_BB_SEC_NUM_DES;
    }

    @Column(name = "REGION")
    public String getREGION() {
        return REGION;
    }
    public void setREGION(String REGION) {
        this.REGION = REGION;
    }


}
