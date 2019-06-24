package com.kewei.manager.service.impl;

import com.kewei.manager.dao.BaseBascisDataMapper;
import com.kewei.manager.pojo.BaseBascisData;
import com.kewei.manager.service.ExcelBascisDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询数据表
 *
 * @author Administrator
 * @date 2019/6/3 0003
 **/
@Service
public class ExcelBascisDataServiceImpl implements ExcelBascisDataService {
    @Autowired
    BaseBascisDataMapper baseBascisDataMapper;
    @Override
    public List<BaseBascisData> getExcelBase() {
        return baseBascisDataMapper.getExcel();
    }

    @Override
    public List<BaseBascisData> getTimeBase() {
        return baseBascisDataMapper.getTime();
    }

    /**
     * 查询一级绝对值个数
     * @return
     */
    @Override
    public Integer selectKeylevel1() {
        return baseBascisDataMapper.slelectlevel1();
    }
    /**
     * 查询二级绝对值个数
     * @return
     */
    @Override
    public Integer selectKeylevel2() {
        return baseBascisDataMapper.slelectlevel2();
    }
    /**
     * 查询三级绝对值个数
     * @return
     */
    @Override
    public Integer selectKeylevel3() {
        return baseBascisDataMapper.slelectlevel3();
    }
    /**
     * 查询四级绝对值个数
     * @return
     */
    @Override
    public Integer selectKeylevel4() {
        return baseBascisDataMapper.slelectlevel4();
    }
    /**
     * 查询五级绝对值个数
     * @return
     */
    @Override
    public Integer selectKeylevel5() {
        return baseBascisDataMapper.slelectlevel5();
    }

    /**
     * 一级查询数据
     * @return
     */
    @Override
    public List<String> selectKeyName1_2_1() {
        return baseBascisDataMapper.levelkeyName1_2_1();
    }

    @Override
    public List<String> selectKeyName2_2_1() {
        return baseBascisDataMapper.levelkeyName2_2_1();
    }

    @Override
    public List<String> selectKeyName3_2_1() {
        return baseBascisDataMapper.levelkeyName3_2_1();
    }
    /**
     * 二级查询
     * @return
     */
    @Override
    public List<String> selectKeyName1_1_0() {
        return baseBascisDataMapper.levelkeyName1_1_0();
    }

    @Override
    public List<String> selectKeyName2_1_0() {
        return baseBascisDataMapper.levelkeyName2_1_0();
    }

    @Override
    public List<String> selectKeyName3_1_0() {
        return baseBascisDataMapper.levelkeyName3_1_0();
    }
    /**
     * 三级查询
     * @return
     */
    @Override
    public List<String> selectKeyName1_0_2() {
        return baseBascisDataMapper.levelkeyName1_0_2();
    }

    @Override
    public List<String> selectKeyName2_0_2() {
        return baseBascisDataMapper.levelkeyName2_0_2();
    }

    @Override
    public List<String> selectKeyName3_0_2() {
        return baseBascisDataMapper.levelkeyName3_0_2();
    }
    /**
     * 四级查询
     * @return
     */
    @Override
    public List<String> selectKeyName1_2_4() {
        return baseBascisDataMapper.levelkeyName1_2_4();
    }

    @Override
    public List<String> selectKeyName2_2_4() {
        return baseBascisDataMapper.levelkeyName2_2_4();
    }

    @Override
    public List<String> selectKeyName3_2_4() {
        return baseBascisDataMapper.levelkeyName3_2_4();
    }
    /**
     * 五级查询
     * @return
     */
    @Override
    public List<String> selectKeyName1_4_6() {
        return baseBascisDataMapper.levelkeyName1_4_6();
    }

    @Override
    public List<String> selectKeyName2_4_6() {
        return baseBascisDataMapper.levelkeyName2_4_6();
    }

    @Override
    public List<String> selectKeyName3_4_6() {
        return baseBascisDataMapper.levelkeyName3_4_6();
    }


    /**
     * 详情查询
     * @return
     */
    @Override
    public List<BaseBascisData> selectParticulars1() {
        return baseBascisDataMapper.selectParticulars1();
    }

    @Override
    public List<BaseBascisData> selectParticulars2() {
        return baseBascisDataMapper.selectParticulars2();
    }

    @Override
    public List<BaseBascisData> selectParticulars3() {
        return baseBascisDataMapper.selectParticulars3();
    }

    @Override
    public List<BaseBascisData> selectParticulars4() {
        return baseBascisDataMapper.selectParticulars4();
    }

    @Override
    public List<BaseBascisData> selectParticulars5() {
        return baseBascisDataMapper.selectParticulars5();
    }

}
