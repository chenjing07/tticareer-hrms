package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "great_team")
public class GreatTeam implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 表彰内容
     */
    private String commend;

    /**
     * 奖励内容
     */
    private String reward;

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
     * 获取部门id
     *
     * @return department_id - 部门id
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门id
     *
     * @param departmentId 部门id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取表彰内容
     *
     * @return commend - 表彰内容
     */
    public String getCommend() {
        return commend;
    }

    /**
     * 设置表彰内容
     *
     * @param commend 表彰内容
     */
    public void setCommend(String commend) {
        this.commend = commend;
    }

    /**
     * 获取奖励内容
     *
     * @return reward - 奖励内容
     */
    public String getReward() {
        return reward;
    }

    /**
     * 设置奖励内容
     *
     * @param reward 奖励内容
     */
    public void setReward(String reward) {
        this.reward = reward;
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