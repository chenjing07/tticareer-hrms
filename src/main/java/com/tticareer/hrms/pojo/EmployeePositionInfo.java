package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "employee_position_info")
public class EmployeePositionInfo implements Serializable {
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
     * 岗位id
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 到岗时间
     */
    @Column(name = "arrive_post")
    private Date arrivePost;

    /**
     * 调岗时间
     */
    @Column(name = "leave_post")
    private Date leavePost;

    /**
     * 调岗原因
     */
    @Column(name = "transfer_reason")
    private String transferReason;

    /**
     * 调出部门意见
     */
    @Column(name = "leave_opinion")
    private String leaveOpinion;

    /**
     * 调入部门意见
     */
    @Column(name = "arrive_opinion")
    private String arriveOpinion;

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
     * 获取到岗时间
     *
     * @return arrive_post - 到岗时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getArrivePost() {
        return arrivePost;
    }

    /**
     * 设置到岗时间
     *
     * @param arrivePost 到岗时间
     */
    public void setArrivePost(Date arrivePost) {
        this.arrivePost = arrivePost;
    }

    /**
     * 获取调岗时间
     *
     * @return leave_post - 调岗时间
     */
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    public Date getLeavePost() {
        return leavePost;
    }

    /**
     * 设置调岗时间
     *
     * @param leavePost 调岗时间
     */
    public void setLeavePost(Date leavePost) {
        this.leavePost = leavePost;
    }

    /**
     * 获取调岗原因
     *
     * @return transfer_reason - 调岗原因
     */
    public String getTransferReason() {
        return transferReason;
    }

    /**
     * 设置调岗原因
     *
     * @param transferReason 调岗原因
     */
    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    /**
     * 获取调出部门意见
     *
     * @return leave_opinion - 调出部门意见
     */
    public String getLeaveOpinion() {
        return leaveOpinion;
    }

    /**
     * 设置调出部门意见
     *
     * @param leaveOpinion 调出部门意见
     */
    public void setLeaveOpinion(String leaveOpinion) {
        this.leaveOpinion = leaveOpinion;
    }

    /**
     * 获取调入部门意见
     *
     * @return arrive_opinion - 调入部门意见
     */
    public String getArriveOpinion() {
        return arriveOpinion;
    }

    /**
     * 设置调入部门意见
     *
     * @param arriveOpinion 调入部门意见
     */
    public void setArriveOpinion(String arriveOpinion) {
        this.arriveOpinion = arriveOpinion;
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