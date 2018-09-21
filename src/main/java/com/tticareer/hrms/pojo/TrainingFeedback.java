package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "training_feedback")
public class TrainingFeedback implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 培训信息表ID
     */
    @Column(name = "training_info_id")
    private Long trainingInfoId;

    /**
     * 反馈内容
     */
    @Column(name = "training_feedback")
    private String trainingFeedback;

    /**
     * 状态
            {
            	0冻结 1激活
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
     * 获取培训信息表ID
     *
     * @return training_info_id - 培训信息表ID
     */
    public Long getTrainingInfoId() {
        return trainingInfoId;
    }

    /**
     * 设置培训信息表ID
     *
     * @param trainingInfoId 培训信息表ID
     */
    public void setTrainingInfoId(Long trainingInfoId) {
        this.trainingInfoId = trainingInfoId;
    }

    /**
     * 获取反馈内容
     *
     * @return training_feedback - 反馈内容
     */
    public String getTrainingFeedback() {
        return trainingFeedback;
    }

    /**
     * 设置反馈内容
     *
     * @param trainingFeedback 反馈内容
     */
    public void setTrainingFeedback(String trainingFeedback) {
        this.trainingFeedback = trainingFeedback;
    }

    /**
     * 获取状态
            {
            	0冻结 1激活
            }
     *
     * @return state - 状态
            {
            	0冻结 1激活
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结 1激活
            }
     *
     * @param state 状态
            {
            	0冻结 1激活
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