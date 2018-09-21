package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "employee_assessment")
public class EmployeeAssessment implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 员工id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }
     */
    @Column(name = "assessment_type")
    private Integer assessmentType;

    /**
     * 工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }
     */
    @Column(name = "work_result")
    private Integer workResult;

    /**
     * {
            	1优秀 2良好 3及格 0不及格
            }
     */
    private Integer attitude;

    /**
     * {
            	1优秀 2良好 3及格 0不及格
            }
     */
    private Integer quality;

    /**
     * {
            	1优秀 2良好 3及格 0不及格
            }
     */
    private Integer skill;

    /**
     * {
            	1优秀 2良好 3及格 0不及格
            }
     */
    @Column(name = "assessment_result")
    private Integer assessmentResult;

    /**
     * 评价
     */
    private String evaluate;

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
     * 获取员工id
     *
     * @return employee_id - 员工id
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工id
     *
     * @param employeeId 员工id
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }
     *
     * @return assessment_type - 考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }
     */
    public Integer getAssessmentType() {
        return assessmentType;
    }

    /**
     * 设置考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }
     *
     * @param assessmentType 考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }
     */
    public void setAssessmentType(Integer assessmentType) {
        this.assessmentType = assessmentType;
    }

    /**
     * 获取工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @return work_result - 工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public Integer getWorkResult() {
        return workResult;
    }

    /**
     * 设置工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @param workResult 工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public void setWorkResult(Integer workResult) {
        this.workResult = workResult;
    }

    /**
     * 获取{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @return attitude - {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public Integer getAttitude() {
        return attitude;
    }

    /**
     * 设置{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @param attitude {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    /**
     * 获取{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @return quality - {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * 设置{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @param quality {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    /**
     * 获取{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @return skill - {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public Integer getSkill() {
        return skill;
    }

    /**
     * 设置{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @param skill {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    /**
     * 获取{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @return assessment_result - {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public Integer getAssessmentResult() {
        return assessmentResult;
    }

    /**
     * 设置{
            	1优秀 2良好 3及格 0不及格
            }
     *
     * @param assessmentResult {
            	1优秀 2良好 3及格 0不及格
            }
     */
    public void setAssessmentResult(Integer assessmentResult) {
        this.assessmentResult = assessmentResult;
    }

    /**
     * 获取评价
     *
     * @return evaluate - 评价
     */
    public String getEvaluate() {
        return evaluate;
    }

    /**
     * 设置评价
     *
     * @param evaluate 评价
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
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