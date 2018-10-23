package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "examination_questions")
public class ExaminationQuestions implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 题目
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * 分数
     */
    private Long score;

    /**
     * 难度等级
            {
            	0易 1中 2难
            }	
     */
    @Column(name = "difficulty_level")
    private Integer difficultyLevel;

    /**
     * 分类
     	{
     		1选择题 2填空题 3问答题 4计算题
     	}
     */
    private Integer category;

    /**
     * 讲解
     */
    private String explanation;

    /**
     * 状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     */
    private Integer state;

    /**
     * 录入时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一标识，主键自增
     *
     * @return id - 唯一标识，主键自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置唯一标识，主键自增
     *
     * @param id 唯一标识，主键自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取题目
     *
     * @return question - 题目
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置题目
     *
     * @param question 题目
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取分数
     *
     * @return score - 分数
     */
    public Long getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * 获取难度等级
            {
            	0易 1中 2难
            }	
     *
     * @return difficulty_level - 难度等级
            {
            	0易 1中 2难
            }	
     */
    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * 设置难度等级
            {
            	0易 1中 2难
            }	
     *
     * @param difficultyLevel 难度等级
            {
            	0易 1中 2难
            }	
     */
    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * 获取分类
     *
     * @return category - 分类
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置分类
     *
     * @param category 分类
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取讲解
     *
     * @return explanation - 讲解
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * 设置讲解
     *
     * @param explanation 讲解
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * 获取状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     *
     * @return state - 状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     *
     * @param state 状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取录入时间
     *
     * @return create_time - 录入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置录入时间
     *
     * @param createTime 录入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }
}