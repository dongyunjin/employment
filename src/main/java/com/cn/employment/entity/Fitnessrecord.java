package com.cn.employment.entity;

import java.io.Serializable;
import java.util.Date;

public class Fitnessrecord implements Serializable {
    private Integer id;

    private String memberid;

    private String start;
    
    private String overlap;
    
    private String rendering;
    
    private String color;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start == null ? null : start.trim();
	}

	public String getOverlap() {
		return overlap;
	}

	public void setOverlap(String overlap) {
		this.overlap = overlap == null ? null : overlap.trim();
	}

	public String getRendering() {
		return rendering;
	}

	public void setRendering(String rendering) {
		this.rendering = rendering == null ? null : rendering.trim();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberid=").append(memberid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}