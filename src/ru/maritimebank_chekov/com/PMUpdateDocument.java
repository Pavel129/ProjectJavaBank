package ru.maritimebank_chekov.com;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="ru.maritimebank_chekov.com.PMUpdateDocument")
@NamedStoredProcedureQuery(name = "ru.maritimebank_chekov.com.PMUpdateDocument", procedureName = "dbo_fx.RevertStatus", resultClasses = Integer.class,
        parameters = { @StoredProcedureParameter(mode = ParameterMode.IN, name = "pID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pErr", type = String.class)})
public class PMUpdateDocument {
    private static final long serialVersionUID = 3_11_2022_20_01_01L;

    PMUpdateDocument(){}
}
