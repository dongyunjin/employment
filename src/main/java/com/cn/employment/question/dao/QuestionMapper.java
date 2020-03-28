package com.cn.employment.question.dao;

import com.cn.employment.question.entity.Question;
import com.cn.employment.framework.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 题库 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-03-22
 */
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * @Description: 获取所有招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<Question> questionList(@Param("type") String type);

    /**
    * @Description: 获取题
    * @Date: 2020/3/22 18:06
    */
    List<Question> questionListByBusId(@Param("type") String type, @Param("busId") Integer busId);
}
