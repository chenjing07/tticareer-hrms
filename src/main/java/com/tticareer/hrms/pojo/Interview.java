package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Interview implements Serializable {
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
     * 初面内容
     */
    @Column(name = "one_content")
    private String oneContent;

    /**
     * 初面开始时间
     */
    @Column(name = "one_start")
    private Date oneStart;

    /**
     * 初面结束时间
     */
    @Column(name = "one_end")
    private Date oneEnd;

    /**
     * 初面反馈总结
     */
    @Column(name = "one_feedback")
    private String oneFeedback;

    /**
     * 复面内容
     */
    @Column(name = "two_content")
    private String twoContent;

    /**
     * 复面开始时间
     */
    @Column(name = "two_start")
    private Date twoStart;

    /**
     * 复面结束时间
     */
    @Column(name = "two_end")
    private Date twoEnd;

    /**
     * 复面反馈总结
     */
    @Column(name = "two_feedback")
    private String twoFeedback;

    /**
     * 状态
            {
            	0落选 1进入二面
            }
     */
    private Integer state;

    /**
     * 录入时间
     */
    @Column(name = "create_time")
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
     * 获取初面内容
     *
     * @return one_content - 初面内容
     */
    public String getOneContent() {
        return oneContent;
    }

    /**
     * 设置初面内容
     *
     * @param oneContent 初面内容
     */
    public void setOneContent(String oneContent) {
        this.oneContent = oneContent;
    }

    /**
     * 获取初面开始时间
     *
     * @return one_start - 初面开始时间
     */
    public Date getOneStart() {
        return oneStart;
    }

    /**
     * 设置初面开始时间
     *
     * @param oneStart 初面开始时间
     */
    public void setOneStart(Date oneStart) {
        this.oneStart = oneStart;
    }

    /**
     * 获取初面结束时间
     *
     * @return one_end - 初面结束时间
     */
    public Date getOneEnd() {
        return oneEnd;
    }

    /**
     * 设置初面结束时间
     *
     * @param oneEnd 初面结束时间
     */
    public void setOneEnd(Date oneEnd) {
        this.oneEnd = oneEnd;
    }

    /**
     * 获取初面反馈总结
     *
     * @return one_feedback - 初面反馈总结
     */
    public String getOneFeedback() {
        return oneFeedback;
    }

    /**
     * 设置初面反馈总结
     *
     * @param oneFeedback 初面反馈总结
     */
    public void setOneFeedback(String oneFeedback) {
        this.oneFeedback = oneFeedback;
    }

    /**
     * 获取复面内容
     *
     * @return two_content - 复面内容
     */
    public String getTwoContent() {
        return twoContent;
    }

    /**
     * 设置复面内容
     *
     * @param twoContent 复面内容
     */
    public void setTwoContent(String twoContent) {
        this.twoContent = twoContent;
    }

    /**
     * 获取复面开始时间
     *
     * @return two_start - 复面开始时间
     */
    public Date getTwoStart() {
        return twoStart;
    }

    /**
     * 设置复面开始时间
     *
     * @param twoStart 复面开始时间
     */
    public void setTwoStart(Date twoStart) {
        this.twoStart = twoStart;
    }

    /**
     * 获取复面结束时间
     *
     * @return two_end - 复面结束时间
     */
    public Date getTwoEnd() {
        return twoEnd;
    }

    /**
     * 设置复面结束时间
     *
     * @param twoEnd 复面结束时间
     */
    public void setTwoEnd(Date twoEnd) {
        this.twoEnd = twoEnd;
    }

    /**
     * 获取复面反馈总结
     *
     * @return two_feedback - 复面反馈总结
     */
    public String getTwoFeedback() {
        return twoFeedback;
    }

    /**
     * 设置复面反馈总结
     *
     * @param twoFeedback 复面反馈总结
     */
    public void setTwoFeedback(String twoFeedback) {
        this.twoFeedback = twoFeedback;
    }

    /**
     * 获取状态
            {
            	0落选 1进入二面
            }
     *
     * @return state - 状态
            {
            	0落选 1进入二面
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0落选 1进入二面
            }
     *
     * @param state 状态
            {
            	0落选 1进入二面
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