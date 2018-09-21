package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "leave_detail")
public class LeaveDetail implements Serializable {
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
     * 请假开始时间
     */
    @Column(name = "leave_start")
    private Date leaveStart;

    /**
     * 请假结束时间
     */
    @Column(name = "leave_end")
    private Date leaveEnd;

    /**
     * 请假天数
     */
    @Column(name = "leave_days")
    private Integer leaveDays;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 审核后假期开始时间
     */
    @Column(name = "real_start")
    private Date realStart;

    /**
     * 审核后假期结束时间（销假）
     */
    @Column(name = "real_end")
    private Date realEnd;

    /**
     * 状态
            {
            	0冻结 1激活 2销假成功
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
     * 获取请假开始时间
     *
     * @return leave_start - 请假开始时间
     */
    public Date getLeaveStart() {
        return leaveStart;
    }

    /**
     * 设置请假开始时间
     *
     * @param leaveStart 请假开始时间
     */
    public void setLeaveStart(Date leaveStart) {
        this.leaveStart = leaveStart;
    }

    /**
     * 获取请假结束时间
     *
     * @return leave_end - 请假结束时间
     */
    public Date getLeaveEnd() {
        return leaveEnd;
    }

    /**
     * 设置请假结束时间
     *
     * @param leaveEnd 请假结束时间
     */
    public void setLeaveEnd(Date leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    /**
     * 获取请假天数
     *
     * @return leave_days - 请假天数
     */
    public Integer getLeaveDays() {
        return leaveDays;
    }

    /**
     * 设置请假天数
     *
     * @param leaveDays 请假天数
     */
    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    /**
     * 获取请假原因
     *
     * @return reason - 请假原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置请假原因
     *
     * @param reason 请假原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取审核后假期开始时间
     *
     * @return real_start - 审核后假期开始时间
     */
    public Date getRealStart() {
        return realStart;
    }

    /**
     * 设置审核后假期开始时间
     *
     * @param realStart 审核后假期开始时间
     */
    public void setRealStart(Date realStart) {
        this.realStart = realStart;
    }

    /**
     * 获取审核后假期结束时间（销假）
     *
     * @return real_end - 审核后假期结束时间（销假）
     */
    public Date getRealEnd() {
        return realEnd;
    }

    /**
     * 设置审核后假期结束时间（销假）
     *
     * @param realEnd 审核后假期结束时间（销假）
     */
    public void setRealEnd(Date realEnd) {
        this.realEnd = realEnd;
    }

    /**
     * 获取状态
            {
            	0冻结 1激活 2销假成功
            }
     *
     * @return state - 状态
            {
            	0冻结 1激活 2销假成功
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结 1激活 2销假成功
            }
     *
     * @param state 状态
            {
            	0冻结 1激活 2销假成功
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