package com.kewei.manager.service;

import com.kewei.manager.pojo.BaseBascisData;

import java.util.List;

public interface ExcelBascisDataService {
    /**
     * 获取数据
     * @return
     */
    List<BaseBascisData> getExcelBase();

    List<BaseBascisData> getTimeBase();

    /**
     * 查询一级个数
     */
    Integer selectKeylevel1();
    /**
     * 查询二级个数
     */
    Integer selectKeylevel2();
    /**
     * 查询三级个数
     */
    Integer selectKeylevel3();
    /**
     * 查询四级个数
     */
    Integer selectKeylevel4();
    /**
     * 查询五级个数
     */
    Integer selectKeylevel5();



    /**
     * 查询一级key1
     * @return
     */
    List<String> selectKeyName1_2_1();
    /**
     * 查询一级key2
     * @return
     */
    List<String> selectKeyName2_2_1();
    /**
     * 查询一级key3
     * @return
     */
    List<String> selectKeyName3_2_1();


    /**
     * 查询二级key1
     * @return
     */
    List<String> selectKeyName1_1_0();
    /**
     * 查询二级key2
     * @return
     */
    List<String> selectKeyName2_1_0();
    /**
     * 查询二级key3
     * @return
     */
    List<String> selectKeyName3_1_0();


    /**
     * 查询三级key1
     * @return
     */
    List<String> selectKeyName1_0_2();
    /**
     * 查询三级key2
     * @return
     */
    List<String> selectKeyName2_0_2();
    /**
     * 查询三级key3
     * @return
     */
    List<String> selectKeyName3_0_2();


    /**
     * 查询四级key1
     * @return
     */
    List<String> selectKeyName1_2_4();
    /**
     * 查询四级key2
     * @return
     */
    List<String> selectKeyName2_2_4();
    /**
     * 查询四级key3
     * @return
     */
    List<String> selectKeyName3_2_4();


    /**
     * 查询五级key1
     * @return
     */
    List<String> selectKeyName1_4_6();
    /**
     * 查询五级key2
     * @return
     */
    List<String> selectKeyName2_4_6();
    /**
     * 查询五级key3
     * @return
     */
    List<String> selectKeyName3_4_6();


    //查询一级
    List<BaseBascisData> selectParticulars1();
    //查询二级
    List<BaseBascisData> selectParticulars2();
    //查询三级
    List<BaseBascisData> selectParticulars3();
    //查询四级
    List<BaseBascisData> selectParticulars4();
    //查询五级
    List<BaseBascisData> selectParticulars5();
}
