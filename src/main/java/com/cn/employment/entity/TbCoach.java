package com.cn.employment.entity;

import java.io.Serializable;

public class TbCoach implements Serializable {
    private Integer id;

    private String coachname;

    private String coachsex;

    private String coachcardid;

    private String coachidcard;

    private String coachphone;

    private String coachlevel;

    private String coachyear;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        this.coachname = coachname == null ? null : coachname.trim();
    }

    public String getCoachsex() {
        return coachsex;
    }

    public void setCoachsex(String coachsex) {
        this.coachsex = coachsex == null ? null : coachsex.trim();
    }

    public String getCoachcardid() {
        return coachcardid;
    }

    public void setCoachcardid(String coachcardid) {
        this.coachcardid = coachcardid == null ? null : coachcardid.trim();
    }

    public String getCoachidcard() {
        return coachidcard;
    }

    public void setCoachidcard(String coachidcard) {
        this.coachidcard = coachidcard == null ? null : coachidcard.trim();
    }

    public String getCoachphone() {
        return coachphone;
    }

    public void setCoachphone(String coachphone) {
        this.coachphone = coachphone == null ? null : coachphone.trim();
    }

    public String getCoachlevel() {
        return coachlevel;
    }

    public void setCoachlevel(String coachlevel) {
        this.coachlevel = coachlevel == null ? null : coachlevel.trim();
    }

    public String getCoachyear() {
        return coachyear;
    }

    public void setCoachyear(String coachyear) {
        this.coachyear = coachyear == null ? null : coachyear.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coachname=").append(coachname);
        sb.append(", coachsex=").append(coachsex);
        sb.append(", coachcardid=").append(coachcardid);
        sb.append(", coachidcard=").append(coachidcard);
        sb.append(", coachphone=").append(coachphone);
        sb.append(", coachlevel=").append(coachlevel);
        sb.append(", coachyear=").append(coachyear);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}