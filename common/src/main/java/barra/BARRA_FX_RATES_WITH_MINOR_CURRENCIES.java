package barra;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;
import com.olympus.model.RefTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BARRA_FX_RATES_WITH_MINOR_CURRENCIES")
@SpaceClass
public class BARRA_FX_RATES_WITH_MINOR_CURRENCIES implements RefTable {
    private String id;
    private long DDATE;
    private String CURRENCY_CODE;
    private double FX_RATE;
    private double RF_RATE;
    private Integer routing;

    public BARRA_FX_RATES_WITH_MINOR_CURRENCIES() {
    }
    @Id
//    @SpaceId(autoGenerate = true)
    @SpaceId
    @SpaceIndex(unique = true)
    @Column(name = "Id")
    public String getId() {
        return CURRENCY_CODE + DDATE + BARRA_FX_RATES_WITH_MINOR_CURRENCIES.class.getName().hashCode();
    }

    public void setId(String id) {
        this.id = id;
    }

    @SpaceIndex(type = SpaceIndexType.ORDERED)
    @Column(name = "DDATE")
    public long getDDATE() {
        return DDATE;
    }

    public void setDDATE(long DDATE) {
        this.DDATE = DDATE;
    }


    @SpaceIndex(type = SpaceIndexType.EQUAL)
    @Column(name = "CURRENCY_CODE")
    public String getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }
    public void setCURRENCY_CODE(String CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    @Column(name = "FX_RATE")
    public double getFX_RATE() {
        return FX_RATE;
    }
    public void setFX_RATE(double FX_RATE) {
        this.FX_RATE = FX_RATE;
    }

    @Column(name = "RF_RATE")
    public double getRF_RATE() {
        return RF_RATE;
    }
    public void setRF_RATE(double RF_RATE) {
        this.RF_RATE = RF_RATE;
    }

    @SpaceRouting
    @Column(name = "Routing")
    public Integer getRouting() {
        return routing;
    }
    public void setRouting(Integer routing) {
        this.routing = routing;
    }
}
