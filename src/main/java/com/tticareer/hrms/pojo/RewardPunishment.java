package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "reward_punishment")
public class RewardPunishment implements Serializable {
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
     * 奖惩1奖0惩
     */
    @Column(name = "reward_and_punishment")
    private Integer rewardAndPunishment;

    /**
     * 奖惩内容
     */
    private String content;

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
     * 获取奖惩1奖0惩
     *
     * @return reward_and_punishment - 奖惩1奖0惩
     */
    public Integer getRewardAndPunishment() {
        return rewardAndPunishment;
    }

    /**
     * 设置奖惩1奖0惩
     *
     * @param rewardAndPunishment 奖惩1奖0惩
     */
    public void setRewardAndPunishment(Integer rewardAndPunishment) {
        this.rewardAndPunishment = rewardAndPunishment;
    }

    /**
     * 获取奖惩内容
     *
     * @return content - 奖惩内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置奖惩内容
     *
     * @param content 奖惩内容
     */
    public void setContent(String content) {
        this.content = content;
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