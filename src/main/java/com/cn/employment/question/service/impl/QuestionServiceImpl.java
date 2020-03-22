package com.cn.employment.question.service.impl;

import com.cn.employment.question.entity.Question;
import com.cn.employment.question.dao.QuestionMapper;
import com.cn.employment.question.service.IQuestionService;
import com.cn.employment.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 题库 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-03-22
 */
@Service
public class QuestionServiceImpl extends BaseServiceImpl<QuestionMapper, Question> implements IQuestionService {


    @Override
    public List<Question> questionList(String type) {
        return this.baseMapper.questionList(type);
    }

    @Override
    public List<Question> questionList(String type, Integer busId) {
        return this.baseMapper.questionListByBusId(type, busId);
    }

    @Override
    public void add(Question recruit) {
        recruit.insert();
    }

    @Override
    public void edit(Question recruit) {
        this.baseMapper.updateById(recruit);
    }

    @Override
    public void del(Long id) {
        Question recruit = new Question();
        recruit.deleteById(id);
    }
}
