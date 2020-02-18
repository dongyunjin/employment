package com.cn.employment.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calendar implements Serializable {
    private Integer id;

    private String title;

    private Integer allday;

    private String start;

    private String end;

    private String url;

    private String classname;

    private Integer editable;

    private String source;

    private String color;

    private String backgroundcolor;

    private String bordercolor;

    private String textcolor;

    private Integer type;

    private Integer memberid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAllday() {
        return allday;
    }

    public void setAllday(Integer allday) {
        this.allday = allday;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor == null ? null : backgroundcolor.trim();
    }

    public String getBordercolor() {
        return bordercolor;
    }

    public void setBordercolor(String bordercolor) {
        this.bordercolor = bordercolor == null ? null : bordercolor.trim();
    }

    public String getTextcolor() {
        return textcolor;
    }

    public void setTextcolor(String textcolor) {
        this.textcolor = textcolor == null ? null : textcolor.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", allday=").append(allday);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", url=").append(url);
        sb.append(", classname=").append(classname);
        sb.append(", editable=").append(editable);
        sb.append(", source=").append(source);
        sb.append(", color=").append(color);
        sb.append(", backgroundcolor=").append(backgroundcolor);
        sb.append(", bordercolor=").append(bordercolor);
        sb.append(", textcolor=").append(textcolor);
        sb.append(", type=").append(type);
        sb.append(", memberid=").append(memberid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}