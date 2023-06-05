package ru.maritimebank_chekov.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;

@Entity(name="ru.maritimebank_chekov.com.PMFilterType")
@NamedNativeQuery(name="ru.maritimebank_chekov.com.PMFilterType",
        query=  "SELECT DISTINCT CROOT \n" +
                "from MTB.VXD_DETAIL \n" +
                "where CROOT IS NOT NULL  \n" +
                "union all \n" +
                "select 'ALL' \n" +
                "from dual")
public class PMFilterType implements Serializable {
    private static final long serialVersionUID = 3_11_2022_20_01_01L;
    private String CROOT;

    public PMFilterType(){}

    @Column(name="CROOT",length = 255)
    public String getCROOT() {
        return CROOT;
    }
    public void setCROOT(String val) {
        CROOT = val;
    }
}
