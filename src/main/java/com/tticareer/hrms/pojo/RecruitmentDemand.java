package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "recruitment_demand")
public class RecruitmentDemand implements Serializable {
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
     * 计划人数
     */
    @Column(name = "plan_number")
    private Integer planNumber;

    /**
     * 薪资待遇
     */
    private Long salary;

    /**
     * 增补人数
     */
    @Column(name = "supplemental_number")
    private Integer supplementalNumber;

    /**
     * 增补原因
     */
    @Column(name = "supplement_reason")
    private String supplementReason;

    /**
     * 到岗日期
     */
    @Column(name = "arrival_date")
    private Date arrivalDate;

    /**
     * 外语要求
     */
    @Column(name = "language_requirements")
    private String languageRequirements;

    /**
     * 专业要求
     */
    @Column(name = "professional_requirements")
    private String professionalRequirements;

    /**
     * 学历要求
     */
    @Column(name = "educational_requirements")
    private String educationalRequirements;

    /**
     * 电脑要求
     */
    @Column(name = "computer_requirements")
    private String computerRequirements;

    /**
     * 经验要求
     */
    @Column(name = "experience_requirements")
    private String experienceRequirements;

    /**
     * 年龄要求
     */
    @Column(name = "age_requirements")
    private String ageRequirements;

    /**
     * 岗位职责
     */
    @Column(name = "post_duties")
    private String postDuties;

    /**
     * 岗位要求
     */
    @Column(name = "post_requirements")
    private String postRequirements;

    /**
     * 状态
            {
            	0冻结1激活
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
     * 获取计划人数
     *
     * @return plan_number - 计划人数
     */
    public Integer getPlanNumber() {
        return planNumber;
    }

    /**
     * 设置计划人数
     *
     * @param planNumber 计划人数
     */
    public void setPlanNumber(Integer planNumber) {
        this.planNumber = planNumber;
    }

    /**
     * 获取薪资待遇
     *
     * @return salary - 薪资待遇
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * 设置薪资待遇
     *
     * @param salary 薪资待遇
     */
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    /**
     * 获取增补人数
     *
     * @return supplemental_number - 增补人数
     */
    public Integer getSupplementalNumber() {
        return supplementalNumber;
    }

    /**
     * 设置增补人数
     *
     * @param supplementalNumber 增补人数
     */
    public void setSupplementalNumber(Integer supplementalNumber) {
        this.supplementalNumber = supplementalNumber;
    }

    /**
     * 获取增补原因
     *
     * @return supplement_reason - 增补原因
     */
    public String getSupplementReason() {
        return supplementReason;
    }

    /**
     * 设置增补原因
     *
     * @param supplementReason 增补原因
     */
    public void setSupplementReason(String supplementReason) {
        this.supplementReason = supplementReason;
    }

    /**
     * 获取到岗日期
     *
     * @return arrival_date - 到岗日期
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * 设置到岗日期
     *
     * @param arrivalDate 到岗日期
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * 获取外语要求
     *
     * @return language_requirements - 外语要求
     */
    public String getLanguageRequirements() {
        return languageRequirements;
    }

    /**
     * 设置外语要求
     *
     * @param languageRequirements 外语要求
     */
    public void setLanguageRequirements(String languageRequirements) {
        this.languageRequirements = languageRequirements;
    }

    /**
     * 获取专业要求
     *
     * @return professional_requirements - 专业要求
     */
    public String getProfessionalRequirements() {
        return professionalRequirements;
    }

    /**
     * 设置专业要求
     *
     * @param professionalRequirements 专业要求
     */
    public void setProfessionalRequirements(String professionalRequirements) {
        this.professionalRequirements = professionalRequirements;
    }

    /**
     * 获取学历要求
     *
     * @return educational_requirements - 学历要求
     */
    public String getEducationalRequirements() {
        return educationalRequirements;
    }

    /**
     * 设置学历要求
     *
     * @param educationalRequirements 学历要求
     */
    public void setEducationalRequirements(String educationalRequirements) {
        this.educationalRequirements = educationalRequirements;
    }

    /**
     * 获取电脑要求
     *
     * @return computer_requirements - 电脑要求
     */
    public String getComputerRequirements() {
        return computerRequirements;
    }

    /**
     * 设置电脑要求
     *
     * @param computerRequirements 电脑要求
     */
    public void setComputerRequirements(String computerRequirements) {
        this.computerRequirements = computerRequirements;
    }

    /**
     * 获取经验要求
     *
     * @return experience_requirements - 经验要求
     */
    public String getExperienceRequirements() {
        return experienceRequirements;
    }

    /**
     * 设置经验要求
     *
     * @param experienceRequirements 经验要求
     */
    public void setExperienceRequirements(String experienceRequirements) {
        this.experienceRequirements = experienceRequirements;
    }

    /**
     * 获取年龄要求
     *
     * @return age_requirements - 年龄要求
     */
    public String getAgeRequirements() {
        return ageRequirements;
    }

    /**
     * 设置年龄要求
     *
     * @param ageRequirements 年龄要求
     */
    public void setAgeRequirements(String ageRequirements) {
        this.ageRequirements = ageRequirements;
    }

    /**
     * 获取岗位职责
     *
     * @return post_duties - 岗位职责
     */
    public String getPostDuties() {
        return postDuties;
    }

    /**
     * 设置岗位职责
     *
     * @param postDuties 岗位职责
     */
    public void setPostDuties(String postDuties) {
        this.postDuties = postDuties;
    }

    /**
     * 获取岗位要求
     *
     * @return post_requirements - 岗位要求
     */
    public String getPostRequirements() {
        return postRequirements;
    }

    /**
     * 设置岗位要求
     *
     * @param postRequirements 岗位要求
     */
    public void setPostRequirements(String postRequirements) {
        this.postRequirements = postRequirements;
    }

    /**
     * 获取状态
            {
            	0冻结1激活
            }
     *
     * @return state - 状态
            {
            	0冻结1激活
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结1激活
            }
     *
     * @param state 状态
            {
            	0冻结1激活
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