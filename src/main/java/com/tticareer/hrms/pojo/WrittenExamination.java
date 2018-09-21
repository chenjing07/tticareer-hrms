package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "written_examination")
public class WrittenExamination implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 简历id
     */
    @Column(name = "resume_id")
    private Long resumeId;

    /**
     * 笔试内容id
     */
    @Column(name = "exam_content_id")
    private Long examContentId;

    /**
     * 笔试时间
     */
    @Column(name = "exam_start")
    private Date examStart;

    /**
     * 备注
     */
    private String note;

    /**
     * 笔试成绩
     */
    @Column(name = "exam_score")
    private Long examScore;

    /**
     * 笔试结果
            {
            	1一面 0落选
            }
     */
    @Column(name = "exam_result")
    private Integer examResult;

    /**
     * 录入时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "exam_end")
    private Date examEnd;

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
     * 获取简历id
     *
     * @return resume_id - 简历id
     */
    public Long getResumeId() {
        return resumeId;
    }

    /**
     * 设置简历id
     *
     * @param resumeId 简历id
     */
    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * 获取笔试内容id
     *
     * @return exam_content_id - 笔试内容id
     */
    public Long getExamContentId() {
        return examContentId;
    }

    /**
     * 设置笔试内容id
     *
     * @param examContentId 笔试内容id
     */
    public void setExamContentId(Long examContentId) {
        this.examContentId = examContentId;
    }

    /**
     * 获取笔试时间
     *
     * @return exam_start - 笔试时间
     */
    public Date getExamStart() {
        return examStart;
    }

    /**
     * 设置笔试时间
     *
     * @param examStart 笔试时间
     */
    public void setExamStart(Date examStart) {
        this.examStart = examStart;
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

    /**
     * 获取笔试成绩
     *
     * @return exam_score - 笔试成绩
     */
    public Long getExamScore() {
        return examScore;
    }

    /**
     * 设置笔试成绩
     *
     * @param examScore 笔试成绩
     */
    public void setExamScore(Long examScore) {
        this.examScore = examScore;
    }

    /**
     * 获取笔试结果
            {
            	1一面 0落选
            }
     *
     * @return exam_result - 笔试结果
            {
            	1一面 0落选
            }
     */
    public Integer getExamResult() {
        return examResult;
    }

    /**
     * 设置笔试结果
            {
            	1一面 0落选
            }
     *
     * @param examResult 笔试结果
            {
            	1一面 0落选
            }
     */
    public void setExamResult(Integer examResult) {
        this.examResult = examResult;
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
     * @return exam_end
     */
    public Date getExamEnd() {
        return examEnd;
    }

    /**
     * @param examEnd
     */
    public void setExamEnd(Date examEnd) {
        this.examEnd = examEnd;
    }
}