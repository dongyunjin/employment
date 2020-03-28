package com.cn.employment.question.entity;

import com.cn.employment.framework.base.entity.BaseEntity;
import java.io.Serializable;

/**
 * <p>
 * 题库
 * </p>
 *
 * @author employment
 * @since 2020-03-22
 */
public class Question extends BaseEntity<Question> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题
     */
    private String question;

    /**
     * 选项
     */
    private String optionA;

    /**
     * 选项
     */
    private String optionB;

    /**
     * 选项
     */
    private String optionC;

    /**
     * 选项
     */
    private String optionD;

    /**
     * 答案
     */
    private String answer;

    /**
     * 类型 1.水平测试 2.课后测试 3.阶段测试 4.最终测试
     */
    private String type;

    /**
     * 关联的岗位，或者课程id
     */
    private Integer busId;

//    @TableField(exist = false)
    private String busName;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Question{" +
            "question=" + question +
            ", optionA=" + optionA +
            ", optionB=" + optionB +
            ", optionC=" + optionC +
            ", optionD=" + optionD +
            ", answer=" + answer +
            ", type=" + type +
            ", busId=" + busId +
        "}";
    }
}
