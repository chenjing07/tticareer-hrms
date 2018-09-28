package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "over_work")
public class OverWork implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 员工id
     */
    @Column(name = "employee_Id")
    private Long employeeId;

    /**
     * 加班日期
     */
    private Date time;

    /**
     * 加班时长
     */
    private String duration;

    /**
     * 加班内容
     */
    private String content;

    /**
     * 状态
            {
            	0异常 1正常
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
     * @return employee_Id - 员工id
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
     * 获取加班日期
     *
     * @return time - 加班日期
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置加班日期
     *
     * @param time 加班日期
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取加班时长
     *
     * @return duration - 加班时长
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置加班时长
     *
     * @param duration 加班时长
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 获取加班内容
     *
     * @return content - 加班内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置加班内容
     *
     * @param content 加班内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取状态
            {
            	0异常 1正常
            }
     *
     * @return state - 状态
            {
            	0异常 1正常
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0异常 1正常
            }
     *
     * @param state 状态
            {
            	0异常 1正常
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