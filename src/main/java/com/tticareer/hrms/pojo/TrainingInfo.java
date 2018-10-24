package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "training_info")
public class TrainingInfo implements Serializable {
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
     * 员工id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 讲师
     */
    private String lecturer;

    /**
     * 培训开始时间
     */
    private Date time;

    /**
     * 培训计划时长
     */
    private String duration;

    /**
     * 培训目的
     */
    private String purpose;

    /**
     * 计划人数
     */
    private Integer number;

    /**
     * 计划费用
     */
    private Long cost;

    /**
     * 培训地点
     */
    private String place;

    /**
     * 培训内容
     */
    private String content;

    /**
     * 状态
            {
            	0冻结 1未进行 2在进行
            }
     */
    private Integer state;

    /**
     * 录入时间
     */
    @Column(name = "createTime")
    private Date createtime;

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
     * 获取讲师
     *
     * @return lecturer - 讲师
     */
    public String getLecturer() {
        return lecturer;
    }

    /**
     * 设置讲师
     *
     * @param lecturer 讲师
     */
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * 获取培训开始时间
     *
     * @return time - 培训开始时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置培训开始时间
     *
     * @param time 培训开始时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取培训计划时长
     *
     * @return duration - 培训计划时长
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置培训计划时长
     *
     * @param duration 培训计划时长
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 获取培训目的
     *
     * @return purpose - 培训目的
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 设置培训目的
     *
     * @param purpose 培训目的
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * 获取计划人数
     *
     * @return number - 计划人数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置计划人数
     *
     * @param number 计划人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取计划费用
     *
     * @return cost - 计划费用
     */
    public Long getCost() {
        return cost;
    }

    /**
     * 设置计划费用
     *
     * @param cost 计划费用
     */
    public void setCost(Long cost) {
        this.cost = cost;
    }

    /**
     * 获取培训地点
     *
     * @return place - 培训地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置培训地点
     *
     * @param place 培训地点
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获取培训内容
     *
     * @return content - 培训内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置培训内容
     *
     * @param content 培训内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取状态
            {
            	0冻结 1未进行 2在进行
            }
     *
     * @return state - 状态
            {
            	0冻结 1未进行 2在进行
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0冻结 1未进行 2在进行
            }
     *
     * @param state 状态
            {
            	0冻结 1未进行 2在进行
            }
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取录入时间
     *
     * @return createTime - 录入时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置录入时间
     *
     * @param createtime 录入时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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