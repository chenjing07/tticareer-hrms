package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Archives implements Serializable {
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
     * 转入时间
     */
    @Column(name = "in_time")
    private Date inTime;

    /**
     * 转出时间
     */
    @Column(name = "out_time")
    private Date outTime;

    /**
     * 档案来处
     */
    @Column(name = "archives_source")
    private String archivesSource;

    /**
     * 档案去处
     */
    @Column(name = "archives_destination")
    private String archivesDestination;

    /**
     * 档案变更说明
     */
    @Column(name = "archives_change")
    private String archivesChange;

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
     * 获取转入时间
     *
     * @return in_time - 转入时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getInTime() {
        return inTime;
    }

    /**
     * 设置转入时间
     *
     * @param inTime 转入时间
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 获取转出时间
     *
     * @return out_time - 转出时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getOutTime() {
        return outTime;
    }

    /**
     * 设置转出时间
     *
     * @param outTime 转出时间
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * 获取档案来处
     *
     * @return archives_source - 档案来处
     */
    public String getArchivesSource() {
        return archivesSource;
    }

    /**
     * 设置档案来处
     *
     * @param archivesSource 档案来处
     */
    public void setArchivesSource(String archivesSource) {
        this.archivesSource = archivesSource;
    }

    /**
     * 获取档案去处
     *
     * @return archives_destination - 档案去处
     */
    public String getArchivesDestination() {
        return archivesDestination;
    }

    /**
     * 设置档案去处
     *
     * @param archivesDestination 档案去处
     */
    public void setArchivesDestination(String archivesDestination) {
        this.archivesDestination = archivesDestination;
    }

    /**
     * 获取档案变更说明
     *
     * @return archives_change - 档案变更说明
     */
    public String getArchivesChange() {
        return archivesChange;
    }

    /**
     * 设置档案变更说明
     *
     * @param archivesChange 档案变更说明
     */
    public void setArchivesChange(String archivesChange) {
        this.archivesChange = archivesChange;
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