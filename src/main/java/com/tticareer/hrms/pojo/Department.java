package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Department implements Serializable {
    /**
     * 唯一id，主键自增
     */
    @Id
    private Long id;

    /**
     * 上级部门id
     */
    @Column(name = "superior_department_id")
    private Long superiorDepartmentId;

    /**
     * 部门编号
     */
    @Column(name = "department_number")
    private String departmentNumber;

    /**
     * 部门名称
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 部门简介
     */
    @Column(name = "department_introduction")
    private String departmentIntroduction;

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
     * 获取唯一id，主键自增
     *
     * @return id - 唯一id，主键自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置唯一id，主键自增
     *
     * @param id 唯一id，主键自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取上级部门id
     *
     * @return superior_department_id - 上级部门id
     */
    public Long getSuperiorDepartmentId() {
        return superiorDepartmentId;
    }

    /**
     * 设置上级部门id
     *
     * @param superiorDepartmentId 上级部门id
     */
    public void setSuperiorDepartmentId(Long superiorDepartmentId) {
        this.superiorDepartmentId = superiorDepartmentId;
    }

    /**
     * 获取部门编号
     *
     * @return department_number - 部门编号
     */
    public String getDepartmentNumber() {
        return departmentNumber;
    }

    /**
     * 设置部门编号
     *
     * @param departmentNumber 部门编号
     */
    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    /**
     * 获取部门名称
     *
     * @return department_name - 部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置部门名称
     *
     * @param departmentName 部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取部门简介
     *
     * @return department_introduction - 部门简介
     */
    public String getDepartmentIntroduction() {
        return departmentIntroduction;
    }

    /**
     * 设置部门简介
     *
     * @param departmentIntroduction 部门简介
     */
    public void setDepartmentIntroduction(String departmentIntroduction) {
        this.departmentIntroduction = departmentIntroduction;
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