package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "salary_detail")
public class SalaryDetail implements Serializable {
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
     * 基本工资
     */
    @Column(name = "basic_salary")
    private Long basicSalary;

    /**
     * 奖金
     */
    private Long bonus;

    /**
     * 补贴
     */
    private Long subsidy;

    /**
     * 加班工资
     */
    @Column(name = "over_work_salary")
    private Long overWorkSalary;

    /**
     * 考勤应扣
     */
    @Column(name = "attendance_deduction")
    private Long attendanceDeduction;

    /**
     * 薪资总和
     */
    @Column(name = "salary_total")
    private Long salaryTotal;

    /**
     * 年月
     */
    @Column(name = "now_year_month")
    private Date nowYearMonth;

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
     * 获取基本工资
     *
     * @return basic_salary - 基本工资
     */
    public Long getBasicSalary() {
        return basicSalary;
    }

    /**
     * 设置基本工资
     *
     * @param basicSalary 基本工资
     */
    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * 获取奖金
     *
     * @return bonus - 奖金
     */
    public Long getBonus() {
        return bonus;
    }

    /**
     * 设置奖金
     *
     * @param bonus 奖金
     */
    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    /**
     * 获取补贴
     *
     * @return subsidy - 补贴
     */
    public Long getSubsidy() {
        return subsidy;
    }

    /**
     * 设置补贴
     *
     * @param subsidy 补贴
     */
    public void setSubsidy(Long subsidy) {
        this.subsidy = subsidy;
    }

    /**
     * 获取加班工资
     *
     * @return over_work_salary - 加班工资
     */
    public Long getOverWorkSalary() {
        return overWorkSalary;
    }

    /**
     * 设置加班工资
     *
     * @param overWorkSalary 加班工资
     */
    public void setOverWorkSalary(Long overWorkSalary) {
        this.overWorkSalary = overWorkSalary;
    }

    /**
     * 获取考勤应扣
     *
     * @return attendance_deduction - 考勤应扣
     */
    public Long getAttendanceDeduction() {
        return attendanceDeduction;
    }

    /**
     * 设置考勤应扣
     *
     * @param attendanceDeduction 考勤应扣
     */
    public void setAttendanceDeduction(Long attendanceDeduction) {
        this.attendanceDeduction = attendanceDeduction;
    }

    /**
     * 获取薪资总和
     *
     * @return salary_total - 薪资总和
     */
    public Long getSalaryTotal() {
        return salaryTotal;
    }

    /**
     * 设置薪资总和
     *
     * @param salaryTotal 薪资总和
     */
    public void setSalaryTotal(Long salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    /**
     * 获取年月
     *
     * @return now_year_month - 年月
     */
    public Date getNowYearMonth() {
        return nowYearMonth;
    }

    /**
     * 设置年月
     *
     * @param nowYearMonth 年月
     */
    public void setNowYearMonth(Date nowYearMonth) {
        this.nowYearMonth = nowYearMonth;
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