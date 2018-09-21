package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Employee implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 工号  部门编号+岗位编号+员工id   录账号
            
     */
    @Column(name = "user_name")
    private String userName;

    private String password;

    /**
     * 员工真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 员工身份证号
     */
    @Column(name = "id_card_number")
    private String idCardNumber;

    /**
     * 身份证图片存放地址
     */
    @Column(name = "id_card_picture")
    private String idCardPicture;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 性别1男0女
     */
    private Integer gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    @Column(name = "native_place")
    private String nativePlace;

    /**
     * 户口地址
     */
    @Column(name = "registered_address")
    private String registeredAddress;

    /**
     * 家庭住址
     */
    @Column(name = "house_address")
    private String houseAddress;

    /**
     * 学历
     */
    private String education;

    /**
     * 学位
     */
    @Column(name = "academic_degree")
    private String academicDegree;

    /**
     * 专业
     */
    private String major;

    /**
     * 系别
     */
    private String tie;

    /**
     * 毕业院校
     */
    @Column(name = "graduated_school")
    private String graduatedSchool;

    /**
     * 毕业时间
     */
    @Column(name = "graduated_time")
    private Date graduatedTime;

    /**
     * 政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     */
    @Column(name = "political_status")
    private Integer politicalStatus;

    /**
     * 婚姻状况 0未婚1已婚
     */
    @Column(name = "marital_status")
    private Integer maritalStatus;

    /**
     * 招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }
     */
    @Column(name = "recruitment_source")
    private Integer recruitmentSource;

    /**
     * 开户银行
     */
    @Column(name = "account_bank")
    private String accountBank;

    /**
     * 工资账户
     */
    @Column(name = "account_number")
    private String accountNumber;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * MSN
     */
    private String msn;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "emergency_contact_relationship")
    private String emergencyContactRelationship;

    /**
     * 紧急联系人电话
     */
    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    /**
     * 入职时间
     */
    @Column(name = "work_start")
    private Date workStart;

    /**
     * 离职时间
     */
    @Column(name = "work_end")
    private Date workEnd;

    /**
     * 实习开始时间
     */
    @Column(name = "practice_start")
    private Date practiceStart;

    /**
     * 实习结束时间
     */
    @Column(name = "practice_end")
    private Date practiceEnd;

    /**
     * 是否在职0离职1正式2实习
     */
    private Integer iswork;

    /**
     * 状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
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
    @Column(name = "check_satus")
    private Integer checkSatus;

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
     * 获取工号  部门编号+岗位编号+员工id   录账号
            
     *
     * @return user_name - 工号  部门编号+岗位编号+员工id   录账号
            
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置工号  部门编号+岗位编号+员工id   录账号
            
     *
     * @param userName 工号  部门编号+岗位编号+员工id   录账号
            
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取员工真实姓名
     *
     * @return real_name - 员工真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置员工真实姓名
     *
     * @param realName 员工真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取员工身份证号
     *
     * @return id_card_number - 员工身份证号
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * 设置员工身份证号
     *
     * @param idCardNumber 员工身份证号
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    /**
     * 获取身份证图片存放地址
     *
     * @return id_card_picture - 身份证图片存放地址
     */
    public String getIdCardPicture() {
        return idCardPicture;
    }

    /**
     * 设置身份证图片存放地址
     *
     * @param idCardPicture 身份证图片存放地址
     */
    public void setIdCardPicture(String idCardPicture) {
        this.idCardPicture = idCardPicture;
    }

    /**
     * 获取出生年月
     *
     * @return birthday - 出生年月
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年月
     *
     * @param birthday 出生年月
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别1男0女
     *
     * @return gender - 性别1男0女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别1男0女
     *
     * @param gender 性别1男0女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取户口地址
     *
     * @return registered_address - 户口地址
     */
    public String getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * 设置户口地址
     *
     * @param registeredAddress 户口地址
     */
    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    /**
     * 获取家庭住址
     *
     * @return house_address - 家庭住址
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param houseAddress 家庭住址
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取学位
     *
     * @return academic_degree - 学位
     */
    public String getAcademicDegree() {
        return academicDegree;
    }

    /**
     * 设置学位
     *
     * @param academicDegree 学位
     */
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    /**
     * 获取专业
     *
     * @return major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取系别
     *
     * @return tie - 系别
     */
    public String getTie() {
        return tie;
    }

    /**
     * 设置系别
     *
     * @param tie 系别
     */
    public void setTie(String tie) {
        this.tie = tie;
    }

    /**
     * 获取毕业院校
     *
     * @return graduated_school - 毕业院校
     */
    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    /**
     * 设置毕业院校
     *
     * @param graduatedSchool 毕业院校
     */
    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    /**
     * 获取毕业时间
     *
     * @return graduated_time - 毕业时间
     */
    public Date getGraduatedTime() {
        return graduatedTime;
    }

    /**
     * 设置毕业时间
     *
     * @param graduatedTime 毕业时间
     */
    public void setGraduatedTime(Date graduatedTime) {
        this.graduatedTime = graduatedTime;
    }

    /**
     * 获取政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     *
     * @return political_status - 政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     */
    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    /**
     * 设置政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     *
     * @param politicalStatus 政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     */
    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    /**
     * 获取婚姻状况 0未婚1已婚
     *
     * @return marital_status - 婚姻状况 0未婚1已婚
     */
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状况 0未婚1已婚
     *
     * @param maritalStatus 婚姻状况 0未婚1已婚
     */
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 获取招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }
     *
     * @return recruitment_source - 招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }
     */
    public Integer getRecruitmentSource() {
        return recruitmentSource;
    }

    /**
     * 设置招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }
     *
     * @param recruitmentSource 招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }
     */
    public void setRecruitmentSource(Integer recruitmentSource) {
        this.recruitmentSource = recruitmentSource;
    }

    /**
     * 获取开户银行
     *
     * @return account_bank - 开户银行
     */
    public String getAccountBank() {
        return accountBank;
    }

    /**
     * 设置开户银行
     *
     * @param accountBank 开户银行
     */
    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    /**
     * 获取工资账户
     *
     * @return account_number - 工资账户
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 设置工资账户
     *
     * @param accountNumber 工资账户
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取qq号码
     *
     * @return qq - qq号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号码
     *
     * @param qq qq号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取微信号
     *
     * @return wechat - 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取MSN
     *
     * @return msn - MSN
     */
    public String getMsn() {
        return msn;
    }

    /**
     * 设置MSN
     *
     * @param msn MSN
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }

    /**
     * 获取紧急联系人姓名
     *
     * @return emergency_contact_name - 紧急联系人姓名
     */
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    /**
     * 设置紧急联系人姓名
     *
     * @param emergencyContactName 紧急联系人姓名
     */
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    /**
     * 获取紧急联系人姓名
     *
     * @return emergency_contact_relationship - 紧急联系人姓名
     */
    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    /**
     * 设置紧急联系人姓名
     *
     * @param emergencyContactRelationship 紧急联系人姓名
     */
    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    /**
     * 获取紧急联系人电话
     *
     * @return emergency_contact_number - 紧急联系人电话
     */
    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    /**
     * 设置紧急联系人电话
     *
     * @param emergencyContactNumber 紧急联系人电话
     */
    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    /**
     * 获取入职时间
     *
     * @return work_start - 入职时间
     */
    public Date getWorkStart() {
        return workStart;
    }

    /**
     * 设置入职时间
     *
     * @param workStart 入职时间
     */
    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    /**
     * 获取离职时间
     *
     * @return work_end - 离职时间
     */
    public Date getWorkEnd() {
        return workEnd;
    }

    /**
     * 设置离职时间
     *
     * @param workEnd 离职时间
     */
    public void setWorkEnd(Date workEnd) {
        this.workEnd = workEnd;
    }

    /**
     * 获取实习开始时间
     *
     * @return practice_start - 实习开始时间
     */
    public Date getPracticeStart() {
        return practiceStart;
    }

    /**
     * 设置实习开始时间
     *
     * @param practiceStart 实习开始时间
     */
    public void setPracticeStart(Date practiceStart) {
        this.practiceStart = practiceStart;
    }

    /**
     * 获取实习结束时间
     *
     * @return practice_end - 实习结束时间
     */
    public Date getPracticeEnd() {
        return practiceEnd;
    }

    /**
     * 设置实习结束时间
     *
     * @param practiceEnd 实习结束时间
     */
    public void setPracticeEnd(Date practiceEnd) {
        this.practiceEnd = practiceEnd;
    }

    /**
     * 获取是否在职0离职1正式2实习
     *
     * @return iswork - 是否在职0离职1正式2实习
     */
    public Integer getIswork() {
        return iswork;
    }

    /**
     * 设置是否在职0离职1正式2实习
     *
     * @param iswork 是否在职0离职1正式2实习
     */
    public void setIswork(Integer iswork) {
        this.iswork = iswork;
    }

    /**
     * 获取状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
            }
     *
     * @return state - 状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
            }
     *
     * @param state 状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
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
     * @return check_satus - 审核 0待审核1已审核
     */
    public Integer getCheckSatus() {
        return checkSatus;
    }

    /**
     * 设置审核 0待审核1已审核
     *
     * @param checkSatus 审核 0待审核1已审核
     */
    public void setCheckSatus(Integer checkSatus) {
        this.checkSatus = checkSatus;
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