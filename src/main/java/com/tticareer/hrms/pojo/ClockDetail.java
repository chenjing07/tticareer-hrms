package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clock_detail")
public class ClockDetail implements Serializable {
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
     * 上午上班打卡时间
     */
    @Column(name = "morning_in")
    private Date morningIn;

    /**
     * 上午下班打卡时间
     */
    @Column(name = "morning_out")
    private Date morningOut;

    /**
     * 下午上班打卡时间
     */
    @Column(name = "afternoon_in")
    private Date afternoonIn;

    /**
     * 下午下班打卡时间
     */
    @Column(name = "afternoon_out")
    private Date afternoonOut;

    /**
     * 状态
            {
            	0异常 1按例
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

    /**
     * 上午上班打卡当前坐标
     */
    @Column(name = "mi_coordinate")
    private byte[] miCoordinate;

    /**
     * 上午下班打卡当前坐标
     */
    @Column(name = "mo_coordinate")
    private byte[] moCoordinate;

    /**
     * 下午上班打卡当前坐标
     */
    @Column(name = "ai_coordinate")
    private byte[] aiCoordinate;

    /**
     * 下午下班打卡当前坐标
     */
    @Column(name = "ao_coordinate")
    private byte[] aoCoordinate;

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
     * 获取上午上班打卡时间
     *
     * @return morning_in - 上午上班打卡时间
     */
    public Date getMorningIn() {
        return morningIn;
    }

    /**
     * 设置上午上班打卡时间
     *
     * @param morningIn 上午上班打卡时间
     */
    public void setMorningIn(Date morningIn) {
        this.morningIn = morningIn;
    }

    /**
     * 获取上午下班打卡时间
     *
     * @return morning_out - 上午下班打卡时间
     */
    public Date getMorningOut() {
        return morningOut;
    }

    /**
     * 设置上午下班打卡时间
     *
     * @param morningOut 上午下班打卡时间
     */
    public void setMorningOut(Date morningOut) {
        this.morningOut = morningOut;
    }

    /**
     * 获取下午上班打卡时间
     *
     * @return afternoon_in - 下午上班打卡时间
     */
    public Date getAfternoonIn() {
        return afternoonIn;
    }

    /**
     * 设置下午上班打卡时间
     *
     * @param afternoonIn 下午上班打卡时间
     */
    public void setAfternoonIn(Date afternoonIn) {
        this.afternoonIn = afternoonIn;
    }

    /**
     * 获取下午下班打卡时间
     *
     * @return afternoon_out - 下午下班打卡时间
     */
    public Date getAfternoonOut() {
        return afternoonOut;
    }

    /**
     * 设置下午下班打卡时间
     *
     * @param afternoonOut 下午下班打卡时间
     */
    public void setAfternoonOut(Date afternoonOut) {
        this.afternoonOut = afternoonOut;
    }

    /**
     * 获取状态
            {
            	0异常 1按例
            }
     *
     * @return state - 状态
            {
            	0异常 1按例
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0异常 1按例
            }
     *
     * @param state 状态
            {
            	0异常 1按例
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

    /**
     * 获取上午上班打卡当前坐标
     *
     * @return mi_coordinate - 上午上班打卡当前坐标
     */
    public byte[] getMiCoordinate() {
        return miCoordinate;
    }

    /**
     * 设置上午上班打卡当前坐标
     *
     * @param miCoordinate 上午上班打卡当前坐标
     */
    public void setMiCoordinate(byte[] miCoordinate) {
        this.miCoordinate = miCoordinate;
    }

    /**
     * 获取上午下班打卡当前坐标
     *
     * @return mo_coordinate - 上午下班打卡当前坐标
     */
    public byte[] getMoCoordinate() {
        return moCoordinate;
    }

    /**
     * 设置上午下班打卡当前坐标
     *
     * @param moCoordinate 上午下班打卡当前坐标
     */
    public void setMoCoordinate(byte[] moCoordinate) {
        this.moCoordinate = moCoordinate;
    }

    /**
     * 获取下午上班打卡当前坐标
     *
     * @return ai_coordinate - 下午上班打卡当前坐标
     */
    public byte[] getAiCoordinate() {
        return aiCoordinate;
    }

    /**
     * 设置下午上班打卡当前坐标
     *
     * @param aiCoordinate 下午上班打卡当前坐标
     */
    public void setAiCoordinate(byte[] aiCoordinate) {
        this.aiCoordinate = aiCoordinate;
    }

    /**
     * 获取下午下班打卡当前坐标
     *
     * @return ao_coordinate - 下午下班打卡当前坐标
     */
    public byte[] getAoCoordinate() {
        return aoCoordinate;
    }

    /**
     * 设置下午下班打卡当前坐标
     *
     * @param aoCoordinate 下午下班打卡当前坐标
     */
    public void setAoCoordinate(byte[] aoCoordinate) {
        this.aoCoordinate = aoCoordinate;
    }
}