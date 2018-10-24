package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Resume implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 应聘人姓名
     */
    @Column(name = "application_name")
    private String applicationName;

    /**
     * 期望的职位
     */
    @Column(name = "expected_position")
    private String expectedPosition;

    /**
     * 身份证号
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
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
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
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date graduatedTime;

    /**
     * 获得的奖项
     */
    @Column(name = "awards_received")
    private String awardsReceived;

    /**
     * 语言水平
     */
    @Column(name = "language_level")
    private String languageLevel;

    /**
     * 工作经验
     */
    @Column(name = "work_experience")
    private String workExperience;

    /**
     * 兴趣爱好
     */
    private String hobbies;

    /**
     * 自我评价
     */
    @Column(name = "self_evaluation")
    private String selfEvaluation;

    /**
     * 状态
            {
            	0待处理 1进入笔试 2落选
            }
     */
    private Integer state;

    /**
     * 录入时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
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
     * 获取应聘人姓名
     *
     * @return application_name - 应聘人姓名
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 设置应聘人姓名
     *
     * @param applicationName 应聘人姓名
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * 获取期望的职位
     *
     * @return expected_position - 期望的职位
     */
    public String getExpectedPosition() {
        return expectedPosition;
    }

    /**
     * 设置期望的职位
     *
     * @param expectedPosition 期望的职位
     */
    public void setExpectedPosition(String expectedPosition) {
        this.expectedPosition = expectedPosition;
    }

    /**
     * 获取身份证号
     *
     * @return id_card_number - 身份证号
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * 设置身份证号
     *
     * @param idCardNumber 身份证号
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
     * 获取获得的奖项
     *
     * @return awards_received - 获得的奖项
     */
    public String getAwardsReceived() {
        return awardsReceived;
    }

    /**
     * 设置获得的奖项
     *
     * @param awardsReceived 获得的奖项
     */
    public void setAwardsReceived(String awardsReceived) {
        this.awardsReceived = awardsReceived;
    }

    /**
     * 获取语言水平
     *
     * @return language_level - 语言水平
     */
    public String getLanguageLevel() {
        return languageLevel;
    }

    /**
     * 设置语言水平
     *
     * @param languageLevel 语言水平
     */
    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }

    /**
     * 获取工作经验
     *
     * @return work_experience - 工作经验
     */
    public String getWorkExperience() {
        return workExperience;
    }

    /**
     * 设置工作经验
     *
     * @param workExperience 工作经验
     */
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    /**
     * 获取兴趣爱好
     *
     * @return hobbies - 兴趣爱好
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * 设置兴趣爱好
     *
     * @param hobbies 兴趣爱好
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * 获取自我评价
     *
     * @return self_evaluation - 自我评价
     */
    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    /**
     * 设置自我评价
     *
     * @param selfEvaluation 自我评价
     */
    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

    /**
     * 获取状态
            {
            	0待处理 1进入笔试 2落选
            }
     *
     * @return state - 状态
            {
            	0待处理 1进入笔试 2落选
            }
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
            {
            	0待处理 1进入笔试 2落选
            }
     *
     * @param state 状态
            {
            	0待处理 1进入笔试 2落选
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