package com.cn.employment.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Date: $ $
 * @Author: dyj
 */
public class TreeNode {
    private Long id;

    private String name;

    private String sequence;

    private State state;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeNode> children = Collections.emptyList();

    public TreeNode() {
    }

    public TreeNode(Long id, String name, String sequence, String icon) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public static class State {

        private Boolean checked = false;

        public State(Boolean checked) {
            this.checked = checked;
        }

        public Boolean getChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

    }
}
