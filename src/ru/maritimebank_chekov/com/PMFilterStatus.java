package ru.maritimebank_chekov.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;

@Entity(name="ru.maritimebank_chekov.com.PMFilterType")
@NamedNativeQuery(name="ru.maritimebank_chekov.com.PMFilterType",
        query=  "SELECT DISTINCT STATE \n" +
                "from MTB.VXD_DETAIL \n" +
                "where STATE IS NOT NULL  \n" +
                "union all \n" +
                "select 'ALL' \n" +
                "from dual")
public class PMFilterStatus implements Serializable {
    private static final long serialVersionUID = 3_11_2022_20_01_01L;
    private String STATE;

    public PMFilterStatus(){}

    @Column(name="STATE",length = 30)
    public String getSTATE() {
        return STATE;
    }
    public void setSTATE(String val) {
        STATE = val;
    }
}
