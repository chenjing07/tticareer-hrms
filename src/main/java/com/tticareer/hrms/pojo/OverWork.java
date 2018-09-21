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
    @Column(name = "overWorkId")
    private Long overworkid;

    /**
     * 员工id
     */
    @Column(name = "employeeId")
    private Long employeeid;

    /**
     * 加班日期
     */
    @Column(name = "overWorkTime")
    private Date overworktime;

    /**
     * 加班时长
     */
    @Column(name = "overWorkDuration")
    private String overworkduration;

    /**
     * 加班内容
     */
    @Column(name = "overWorkContent")
    private String overworkcontent;

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
     * @return overWorkId - 唯一标识，主键自增
     */
    public Long getOverworkid() {
        return overworkid;
    }

    /**
     * 设置唯一标识，主键自增
     *
     * @param overworkid 唯一标识，主键自增
     */
    public void setOverworkid(Long overworkid) {
        this.overworkid = overworkid;
    }

    /**
     * 获取员工id
     *
     * @return employeeId - 员工id
     */
    public Long getEmployeeid() {
        return employeeid;
    }

    /**
     * 设置员工id
     *
     * @param employeeid 员工id
     */
    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * 获取加班日期
     *
     * @return overWorkTime - 加班日期
     */
    public Date getOverworktime() {
        return overworktime;
    }

    /**
     * 设置加班日期
     *
     * @param overworktime 加班日期
     */
    public void setOverworktime(Date overworktime) {
        this.overworktime = overworktime;
    }

    /**
     * 获取加班时长
     *
     * @return overWorkDuration - 加班时长
     */
    public String getOverworkduration() {
        return overworkduration;
    }

    /**
     * 设置加班时长
     *
     * @param overworkduration 加班时长
     */
    public void setOverworkduration(String overworkduration) {
        this.overworkduration = overworkduration;
    }

    /**
     * 获取加班内容
     *
     * @return overWorkContent - 加班内容
     */
    public String getOverworkcontent() {
        return overworkcontent;
    }

    /**
     * 设置加班内容
     *
     * @param overworkcontent 加班内容
     */
    public void setOverworkcontent(String overworkcontent) {
        this.overworkcontent = overworkcontent;
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