package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "late_early")
public class LateEarly implements Serializable {
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
     * 迟到早退时间
     */
    @Column(name = "late_early_time")
    private Date lateEarlyTime;

    /**
     * 迟到早退原因
     */
    @Column(name = "late_early_reason")
    private String lateEarlyReason;

    /**
     * 状态
            {
            	0冻结 1迟到 2早退
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
     * 获取迟到早退时间
     *
     * @return late_early_time - 迟到早退时间
     */
    public Date getLateEarlyTime() {
        return lateEarlyTime;
    }

    /**
     * 设置迟到早退时间
     *
     * @param lateEarlyTime 迟到早退时间
     */
    public void setLateEarlyTime(Date lateEarlyTime) {
        this.lateEarlyTime = lateEarlyTime;
    }

    /**
     * 获取迟到早退原因
     *
     * @return late_early_reason - 迟到早退原因
     */
    public String getLateEarlyReason() {
        return lateEarlyReason;
    }

    /**
     * 设置迟到早退原因
     *
     * @param lateEarlyReason 迟到早退原因
     */
    public void setLateEarlyReason(String lateEarlyReason) {
        this.lateEarlyReason = lateEarlyReason;
    }

    /**
     * 获取状态
            {
            	0冻结 1迟到 2早退
            }
     *
     * @return state - 状态
            {
            	0冻结 1迟到 2早退
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结 1迟到 2早退
            }
     *
     * @param state 状态
            {
            	0冻结 1迟到 2早退
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