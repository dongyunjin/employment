package com.cn.employment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbMembership implements Serializable {
    private Integer id;

    private String membername;

    private String membersex;

    private String membercardid;

    private String memberidcard;

    private String memberphone;

    private String memberlevel;

    private String memberapply;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getMembersex() {
        return membersex;
    }

    public void setMembersex(String membersex) {
        this.membersex = membersex == null ? null : membersex.trim();
    }

    public String getMembercardid() {
        return membercardid;
    }

    public void setMembercardid(String membercardid) {
        this.membercardid = membercardid == null ? null : membercardid.trim();
    }

    public String getMemberidcard() {
        return memberidcard;
    }

    public void setMemberidcard(String memberidcard) {
        this.memberidcard = memberidcard == null ? null : memberidcard.trim();
    }

    public String getMemberphone() {
        return memberphone;
    }

    public void setMemberphone(String memberphone) {
        this.memberphone = memberphone == null ? null : memberphone.trim();
    }

    public String getMemberlevel() {
        return memberlevel;
    }

    public void setMemberlevel(String memberlevel) {
        this.memberlevel = memberlevel == null ? null : memberlevel.trim();
    }

    public String getMemberapply() {
        return memberapply;
    }

    public void setMemberapply(String memberapply) {
        this.memberapply = memberapply;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", membername=").append(membername);
        sb.append(", membersex=").append(membersex);
        sb.append(", membercardid=").append(membercardid);
        sb.append(", memberidcard=").append(memberidcard);
        sb.append(", memberphone=").append(memberphone);
        sb.append(", memberlevel=").append(memberlevel);
        sb.append(", memberapply=").append(memberapply);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}