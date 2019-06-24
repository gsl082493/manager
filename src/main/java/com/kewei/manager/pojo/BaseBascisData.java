package com.kewei.manager.pojo;

import javax.persistence.*;

/**
 * 数据类
 * @author Administrator
 * @date 2019/5/29 0029
 **/
@Table(name = "base_bascis_data")
public class BaseBascisData {
    /**
     * 用户数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 数据
     */
    @Column(name = "key1")
    private Double key1;
    /**
     * 数据
     */
    @Column(name = "key2")
    private Double key2;
    /**
     * 数据
     */
    @Column(name = "key3")
    private Double key3;
    /**
     * 数据
     */
    @Column(name = "key4")
    private Double key4;
    /**
     * 数据
     */
    @Column(name = "key5")
    private Double key5;
    /**
     * 数据
     */
    @Column(name = "key6")
    private Double key6;
    /**
     * 数据
     */
    @Column(name = "key7")
    private Double key7;
    /**
     * 数据
     */
    @Column(name = "key8")
    private Double key8;
    /**
     * 数据
     */
    @Column(name = "key9")
    private String key9;
    /**
     * 数据
     */
    @Column(name = "key0")
    private String key0;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getKey1() {
        return key1;
    }

    public void setKey1(Double key1) {
        this.key1 = key1;
    }

    public Double getKey2() {
        return key2;
    }

    public void setKey2(Double key2) {
        this.key2 = key2;
    }

    public Double getKey3() {
        return key3;
    }

    public void setKey3(Double key3) {
        this.key3 = key3;
    }

    public Double getKey4() {
        return key4;
    }

    public void setKey4(Double key4) {
        this.key4 = key4;
    }

    public Double getKey5() {
        return key5;
    }

    public void setKey5(Double key5) {
        this.key5 = key5;
    }

    public Double getKey6() {
        return key6;
    }

    public void setKey6(Double key6) {
        this.key6 = key6;
    }

    public Double getKey7() {
        return key7;
    }

    public void setKey7(Double key7) {
        this.key7 = key7;
    }

    public Double getKey8() {
        return key8;
    }

    public void setKey8(Double key8) {
        this.key8 = key8;
    }

    public String getKey9() {
        return key9;
    }

    public void setKey9(String key9) {
        this.key9 = key9;
    }

    public String getKey0() {
        return key0;
    }

    public void setKey0(String key0) {
        this.key0 = key0;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
