package com.tticareer.hrms.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "written_examination_content")
public class WrittenExaminationContent implements Serializable {
    /**
     * 唯一标识，主键自增
     */
    @Id
    private Long id;

    /**
     * 题目1id
     */
    @Column(name = "one_id")
    private Long oneId;

    /**
     * 题目2id
     */
    @Column(name = "two_id")
    private Long twoId;

    /**
     * 题目3id
     */
    @Column(name = "three_id")
    private Long threeId;

    /**
     * 题目4id
     */
    @Column(name = "four_id")
    private Long fourId;

    /**
     * 题目5id
     */
    @Column(name = "five_id")
    private Long fiveId;

    /**
     * 题目6id
     */
    @Column(name = "six_id")
    private Long sixId;

    /**
     * 题目7id
     */
    @Column(name = "seven_id")
    private Long sevenId;

    /**
     * 题目8id
     */
    @Column(name = "eight_id")
    private Long eightId;

    /**
     * 题目9id
     */
    @Column(name = "nine_id")
    private Long nineId;

    /**
     * 题目10id
     */
    @Column(name = "ten_id")
    private Long tenId;

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
     * 获取题目1id
     *
     * @return one_id - 题目1id
     */
    public Long getOneId() {
        return oneId;
    }

    /**
     * 设置题目1id
     *
     * @param oneId 题目1id
     */
    public void setOneId(Long oneId) {
        this.oneId = oneId;
    }

    /**
     * 获取题目2id
     *
     * @return two_id - 题目2id
     */
    public Long getTwoId() {
        return twoId;
    }

    /**
     * 设置题目2id
     *
     * @param twoId 题目2id
     */
    public void setTwoId(Long twoId) {
        this.twoId = twoId;
    }

    /**
     * 获取题目3id
     *
     * @return three_id - 题目3id
     */
    public Long getThreeId() {
        return threeId;
    }

    /**
     * 设置题目3id
     *
     * @param threeId 题目3id
     */
    public void setThreeId(Long threeId) {
        this.threeId = threeId;
    }

    /**
     * 获取题目4id
     *
     * @return four_id - 题目4id
     */
    public Long getFourId() {
        return fourId;
    }

    /**
     * 设置题目4id
     *
     * @param fourId 题目4id
     */
    public void setFourId(Long fourId) {
        this.fourId = fourId;
    }

    /**
     * 获取题目5id
     *
     * @return five_id - 题目5id
     */
    public Long getFiveId() {
        return fiveId;
    }

    /**
     * 设置题目5id
     *
     * @param fiveId 题目5id
     */
    public void setFiveId(Long fiveId) {
        this.fiveId = fiveId;
    }

    /**
     * 获取题目6id
     *
     * @return six_id - 题目6id
     */
    public Long getSixId() {
        return sixId;
    }

    /**
     * 设置题目6id
     *
     * @param sixId 题目6id
     */
    public void setSixId(Long sixId) {
        this.sixId = sixId;
    }

    /**
     * 获取题目7id
     *
     * @return seven_id - 题目7id
     */
    public Long getSevenId() {
        return sevenId;
    }

    /**
     * 设置题目7id
     *
     * @param sevenId 题目7id
     */
    public void setSevenId(Long sevenId) {
        this.sevenId = sevenId;
    }

    /**
     * 获取题目8id
     *
     * @return eight_id - 题目8id
     */
    public Long getEightId() {
        return eightId;
    }

    /**
     * 设置题目8id
     *
     * @param eightId 题目8id
     */
    public void setEightId(Long eightId) {
        this.eightId = eightId;
    }

    /**
     * 获取题目9id
     *
     * @return nine_id - 题目9id
     */
    public Long getNineId() {
        return nineId;
    }

    /**
     * 设置题目9id
     *
     * @param nineId 题目9id
     */
    public void setNineId(Long nineId) {
        this.nineId = nineId;
    }

    /**
     * 获取题目10id
     *
     * @return ten_id - 题目10id
     */
    public Long getTenId() {
        return tenId;
    }

    /**
     * 设置题目10id
     *
     * @param tenId 题目10id
     */
    public void setTenId(Long tenId) {
        this.tenId = tenId;
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