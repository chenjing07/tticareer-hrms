package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "assessment_standard")
public class AssessmentStandard implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 岗位id
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 工作业绩说明
     */
    @Column(name = "work_result")
    private String workResult;

    /**
     * 工作态度说明
     */
    private String attitude;

    /**
     * 工作质量说明
     */
    private String quality;

    /**
     * 工作技能说明
     */
    private String skill;

    /**
     * 考核计算方法说明
     */
    @Column(name = "calculation_way")
    private String calculationWay;

    /**
     * 考核分类说明
     */
    @Column(name = "assessment_type")
    private String assessmentType;

    /**
     * 结果级别划分说明
     */
    @Column(name = "result_level")
    private String resultLevel;

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
     * 审核 0待审核1已审核
     */
    @Column(name = "check_status")
    private Integer checkStatus;

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
     * 获取岗位id
     *
     * @return position_id - 岗位id
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * 设置岗位id
     *
     * @param positionId 岗位id
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取工作业绩说明
     *
     * @return work_result - 工作业绩说明
     */
    public String getWorkResult() {
        return workResult;
    }

    /**
     * 设置工作业绩说明
     *
     * @param workResult 工作业绩说明
     */
    public void setWorkResult(String workResult) {
        this.workResult = workResult;
    }

    /**
     * 获取工作态度说明
     *
     * @return attitude - 工作态度说明
     */
    public String getAttitude() {
        return attitude;
    }

    /**
     * 设置工作态度说明
     *
     * @param attitude 工作态度说明
     */
    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    /**
     * 获取工作质量说明
     *
     * @return quality - 工作质量说明
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 设置工作质量说明
     *
     * @param quality 工作质量说明
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * 获取工作技能说明
     *
     * @return skill - 工作技能说明
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置工作技能说明
     *
     * @param skill 工作技能说明
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * 获取考核计算方法说明
     *
     * @return calculation_way - 考核计算方法说明
     */
    public String getCalculationWay() {
        return calculationWay;
    }

    /**
     * 设置考核计算方法说明
     *
     * @param calculationWay 考核计算方法说明
     */
    public void setCalculationWay(String calculationWay) {
        this.calculationWay = calculationWay;
    }

    /**
     * 获取考核分类说明
     *
     * @return assessment_type - 考核分类说明
     */
    public String getAssessmentType() {
        return assessmentType;
    }

    /**
     * 设置考核分类说明
     *
     * @param assessmentType 考核分类说明
     */
    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    /**
     * 获取结果级别划分说明
     *
     * @return result_level - 结果级别划分说明
     */
    public String getResultLevel() {
        return resultLevel;
    }

    /**
     * 设置结果级别划分说明
     *
     * @param resultLevel 结果级别划分说明
     */
    public void setResultLevel(String resultLevel) {
        this.resultLevel = resultLevel;
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
     * 获取审核 0待审核1已审核
     *
     * @return check_status - 审核 0待审核1已审核
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置审核 0待审核1已审核
     *
     * @param checkStatus 审核 0待审核1已审核
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
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