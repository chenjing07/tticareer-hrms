package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Position implements Serializable {
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
     * 岗位编号
     */
    @Column(name = "position_number")
    private String positionNumber;

    /**
     * 上级岗位id
     */
    @Column(name = "position_name")
    private Long positionName;

    /**
     * 岗位名称
     */
    @Column(name = "superior_positionId")
    private String superiorPositionid;

    /**
     * 岗位简介
     */
    @Column(name = "position_introduction")
    private String positionIntroduction;

    /**
     * 状态 0冻结1激活
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
     * 获取岗位编号
     *
     * @return position_number - 岗位编号
     */
    public String getPositionNumber() {
        return positionNumber;
    }

    /**
     * 设置岗位编号
     *
     * @param positionNumber 岗位编号
     */
    public void setPositionNumber(String positionNumber) {
        this.positionNumber = positionNumber;
    }

    /**
     * 获取上级岗位id
     *
     * @return position_name - 上级岗位id
     */
    public Long getPositionName() {
        return positionName;
    }

    /**
     * 设置上级岗位id
     *
     * @param positionName 上级岗位id
     */
    public void setPositionName(Long positionName) {
        this.positionName = positionName;
    }

    /**
     * 获取岗位名称
     *
     * @return superior_positionId - 岗位名称
     */
    public String getSuperiorPositionid() {
        return superiorPositionid;
    }

    /**
     * 设置岗位名称
     *
     * @param superiorPositionid 岗位名称
     */
    public void setSuperiorPositionid(String superiorPositionid) {
        this.superiorPositionid = superiorPositionid;
    }

    /**
     * 获取岗位简介
     *
     * @return position_introduction - 岗位简介
     */
    public String getPositionIntroduction() {
        return positionIntroduction;
    }

    /**
     * 设置岗位简介
     *
     * @param positionIntroduction 岗位简介
     */
    public void setPositionIntroduction(String positionIntroduction) {
        this.positionIntroduction = positionIntroduction;
    }

    /**
     * 获取状态 0冻结1激活
     *
     * @return state - 状态 0冻结1激活
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 0冻结1激活
     *
     * @param state 状态 0冻结1激活
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