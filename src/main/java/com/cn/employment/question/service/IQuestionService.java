package com.cn.employment.question.service;

import com.cn.employment.question.entity.Question;
import com.cn.employment.framework.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 题库 服务类
 * </p>
 *
 * @author employment
 * @since 2020-03-22
 */
public interface IQuestionService extends IBaseService<Question> {

    /**
     * @Description: 获取所有招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<Question> questionList(String type);

    /**
     * @Description: 获取题
     * @Date: 2020/3/4 23:17
     */
    List<Question> questionList(String type, Integer busId);

    /**
     * @Description: 增加
     * @Date: 2020/3/7 17:17
     */
    void add(Question question);

    /**
     * @Description: 修改
     * @Date: 2020/3/7 17:17
     */
    void edit(Question question);

    /**
     * @Description: 删除
     * @Date: 2020/3/7 17:17
     */
    void del(Long id);
}
