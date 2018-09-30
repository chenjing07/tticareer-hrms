package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "labor_contract")
public class LaborContract implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 甲方名称，用人单位
     */
    @Column(name = "employer_name")
    private String employerName;

    /**
     * 乙方名称 员工id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 合同期限
     */
    @Column(name = "contract_time_limit")
    private Integer contractTimeLimit;

    /**
     * 开始时间
     */
    @Column(name = "contract_start")
    private Date contractStart;

    /**
     * 结束时间
     */
    @Column(name = "contract_end")
    private Date contractEnd;

    /**
     * 工作内容
     */
    @Column(name = "work_content")
    private String workContent;

    /**
     * 工作地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 劳动保护
     */
    @Column(name = "labor_protection")
    private String laborProtection;

    /**
     * 劳动条件
     */
    @Column(name = "labor_conditions")
    private String laborConditions;

    /**
     * 劳动报酬
     */
    @Column(name = "labor_reward")
    private String laborReward;

    /**
     * 违约责任
     */
    @Column(name = "default_responsibility")
    private String defaultResponsibility;

    /**
     * 社会保险
     */
    @Column(name = "social_insurance")
    private String socialInsurance;

    /**
     * 合同变更
     */
    @Column(name = "contract_change")
    private String contractChange;

    /**
     * 状态 0以往1现在
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
     * 获取甲方名称，用人单位
     *
     * @return employer_name - 甲方名称，用人单位
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * 设置甲方名称，用人单位
     *
     * @param employerName 甲方名称，用人单位
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    /**
     * 获取乙方名称 员工id
     *
     * @return employee_id - 乙方名称 员工id
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置乙方名称 员工id
     *
     * @param employeeId 乙方名称 员工id
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取合同期限
     *
     * @return contract_time_limit - 合同期限
     */
    public Integer getContractTimeLimit() {
        return contractTimeLimit;
    }

    /**
     * 设置合同期限
     *
     * @param contractTimeLimit 合同期限
     */
    public void setContractTimeLimit(Integer contractTimeLimit) {
        this.contractTimeLimit = contractTimeLimit;
    }

    /**
     * 获取开始时间
     *
     * @return contract_start - 开始时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getContractStart() {
        return contractStart;
    }

    /**
     * 设置开始时间
     *
     * @param contractStart 开始时间
     */
    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    /**
     * 获取结束时间
     *
     * @return contract_end - 结束时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getContractEnd() {
        return contractEnd;
    }

    /**
     * 设置结束时间
     *
     * @param contractEnd 结束时间
     */
    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

    /**
     * 获取工作内容
     *
     * @return work_content - 工作内容
     */
    public String getWorkContent() {
        return workContent;
    }

    /**
     * 设置工作内容
     *
     * @param workContent 工作内容
     */
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    /**
     * 获取工作地点
     *
     * @return work_place - 工作地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置工作地点
     *
     * @param workPlace 工作地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * 获取劳动保护
     *
     * @return labor_protection - 劳动保护
     */
    public String getLaborProtection() {
        return laborProtection;
    }

    /**
     * 设置劳动保护
     *
     * @param laborProtection 劳动保护
     */
    public void setLaborProtection(String laborProtection) {
        this.laborProtection = laborProtection;
    }

    /**
     * 获取劳动条件
     *
     * @return labor_conditions - 劳动条件
     */
    public String getLaborConditions() {
        return laborConditions;
    }

    /**
     * 设置劳动条件
     *
     * @param laborConditions 劳动条件
     */
    public void setLaborConditions(String laborConditions) {
        this.laborConditions = laborConditions;
    }

    /**
     * 获取劳动报酬
     *
     * @return labor_reward - 劳动报酬
     */
    public String getLaborReward() {
        return laborReward;
    }

    /**
     * 设置劳动报酬
     *
     * @param laborReward 劳动报酬
     */
    public void setLaborReward(String laborReward) {
        this.laborReward = laborReward;
    }

    /**
     * 获取违约责任
     *
     * @return default_responsibility - 违约责任
     */
    public String getDefaultResponsibility() {
        return defaultResponsibility;
    }

    /**
     * 设置违约责任
     *
     * @param defaultResponsibility 违约责任
     */
    public void setDefaultResponsibility(String defaultResponsibility) {
        this.defaultResponsibility = defaultResponsibility;
    }

    /**
     * 获取社会保险
     *
     * @return social_insurance - 社会保险
     */
    public String getSocialInsurance() {
        return socialInsurance;
    }

    /**
     * 设置社会保险
     *
     * @param socialInsurance 社会保险
     */
    public void setSocialInsurance(String socialInsurance) {
        this.socialInsurance = socialInsurance;
    }

    /**
     * 获取合同变更
     *
     * @return contract_change - 合同变更
     */
    public String getContractChange() {
        return contractChange;
    }

    /**
     * 设置合同变更
     *
     * @param contractChange 合同变更
     */
    public void setContractChange(String contractChange) {
        this.contractChange = contractChange;
    }

    /**
     * 获取状态 0以往1现在
     *
     * @return state - 状态 0以往1现在
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 0以往1现在
     *
     * @param state 状态 0以往1现在
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取录入时间
     *
     * @return create_time - 录入时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
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