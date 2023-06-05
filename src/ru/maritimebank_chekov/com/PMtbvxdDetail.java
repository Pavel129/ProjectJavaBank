package ru.maritimebank_chekov.com;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  chekov
@since   2022/11/01 10:40:08
*/
@Entity (name="ru.maritimebank_chekov.com.PMtbvxdDetail")
@Table (name="MTB.VXD_DETAIL")
public class PMtbvxdDetail implements Serializable
{
  //private static final long serialVersionUID ='01_11_2022_10_40_08l';

    private Long DOCUMENTID;
    private String DOCUMENTNAME;
    private Long REQ_DOC_ID;
    private LocalDate DOC_DATE;
    private String MAC;
    private String GLOBALID;
    private Clob DOCBODY;
    private String CPAND;
    private String CPANC;
    private Clob CXML;
    private String CROOT;
    private String CLIENT_INN;
    private String CLIENT_SRN;
    private Long CLIENT_ID;
    private String ACCOUNT;
    private String NAME;
    private String VALUE;
    private String STATE;
    private String S_COMMENT;

    public PMtbvxdDetail(){}

    @Id 
    @Column(name="DOCUMENTID",nullable = false,length = 0)
    public Long getDOCUMENTID() {
        return DOCUMENTID;
    }
    public void setDOCUMENTID(Long val) {
        DOCUMENTID = val; 
    }
    @Column(name="DOCUMENTNAME",length = 50)
    public String getDOCUMENTNAME() {
        return DOCUMENTNAME;
    }
    public void setDOCUMENTNAME(String val) {
        DOCUMENTNAME = val; 
    }
    @Column(name="REQ_DOC_ID",length = 0)
    public Long getREQ_DOC_ID() {
        return REQ_DOC_ID;
    }
    public void setREQ_DOC_ID(Long val) {
        REQ_DOC_ID = val; 
    }
    @Column(name="DOC_DATE")
    public LocalDate getDOC_DATE() {
        return DOC_DATE;
    }
    public void setDOC_DATE(LocalDate val) {
        DOC_DATE = val; 
    }
    @Column(name="MAC",length = 32)
    public String getMAC() {
        return MAC;
    }
    public void setMAC(String val) {
        MAC = val; 
    }
    @Column(name="GLOBALID",length = 40)
    public String getGLOBALID() {
        return GLOBALID;
    }
    public void setGLOBALID(String val) {
        GLOBALID = val; 
    }
    @Column(name="DOCBODY")
    public Clob getDOCBODY() {
        return DOCBODY;
    }
    public void setDOCBODY(Clob val) {
        DOCBODY = val; 
    }
    @Column(name="CPAND",length = 32)
    public String getCPAND() {
        return CPAND;
    }
    public void setCPAND(String val) {
        CPAND = val; 
    }
    @Column(name="CPANC",length = 32)
    public String getCPANC() {
        return CPANC;
    }
    public void setCPANC(String val) {
        CPANC = val; 
    }
    @Column(name="CXML")
    public Clob getCXML() {
        return CXML;
    }
    public void setCXML(Clob val) {
        CXML = val; 
    }
    @Column(name="CROOT",length = 255)
    public String getCROOT() {
        return CROOT;
    }
    public void setCROOT(String val) {
        CROOT = val; 
    }
    @Column(name="CLIENT_INN",length = 12)
    public String getCLIENT_INN() {
        return CLIENT_INN;
    }
    public void setCLIENT_INN(String val) {
        CLIENT_INN = val; 
    }
    @Column(name="CLIENT_SRN",length = 12)
    public String getCLIENT_SRN() {
        return CLIENT_SRN;
    }
    public void setCLIENT_SRN(String val) {
        CLIENT_SRN = val; 
    }
    @Column(name="CLIENT_ID",length = 0)
    public Long getCLIENT_ID() {
        return CLIENT_ID;
    }
    public void setCLIENT_ID(Long val) {
        CLIENT_ID = val; 
    }
    @Column(name="ACCOUNT",length = 35)
    public String getACCOUNT() {
        return ACCOUNT;
    }
    public void setACCOUNT(String val) {
        ACCOUNT = val; 
    }
    @Column(name="NAME",length = 255)
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String val) {
        NAME = val; 
    }
    @Column(name="VALUE",length = 255)
    public String getVALUE() {
        return VALUE;
    }
    public void setVALUE(String val) {
        VALUE = val; 
    }
    @Column(name="STATE",length = 30)
    public String getSTATE() {
        return STATE;
    }
    public void setSTATE(String val) {
        STATE = val; 
    }
    @Column(name="S_COMMENT",length = 2000)
    public String getS_COMMENT() {
        return S_COMMENT;
    }
    public void setS_COMMENT(String val) {
        S_COMMENT = val; 
    }
}