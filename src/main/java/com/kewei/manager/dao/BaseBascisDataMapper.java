package com.kewei.manager.dao;

import com.kewei.manager.pojo.BaseBascisData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;
import java.util.List;
import java.util.Map;

@Repository
public interface BaseBascisDataMapper extends MyMapper<BaseBascisData> {

    /**
     * 查询数据库总数
     * @return
     */
    int getCncount();
    /**
     * 查询所有数据
     * @param pagemap
     * @return
     */
    List<Map<String, Object>> findBaseData(Map<String, Object> pagemap);

    /**
     * 修改信息
     * @param baseBascisData
     * @return
     */
    int updateBascisData(BaseBascisData baseBascisData);

    /**
     * 删除信息
     * @param id
     * @return
     */
    int deleteBascisData(@Param("id") Integer id);

    /**
     * 添加信息
     * @param baseBascisData
     * @return
     */
    int insertBascisDatas(BaseBascisData baseBascisData);
    /**
     * 获取折线图数据
     * @return
     */
    List<BaseBascisData> getExcel();

    /**
     * 获取时间
     * @return
     */
    List<BaseBascisData> getTime();

    /**
     * 一级条数
     */
    Integer slelectlevel1();
    /**
     * 二级条数
     */
    Integer slelectlevel2();
    /**
     * 三级条数
     */
    Integer slelectlevel3();
    /**
     * 四级条数
     */
    Integer slelectlevel4();
    /**
     * 五级条数
     */
    Integer slelectlevel5();




    /**
     * 查询数据
     *
     * 查询key1 一级查询
     * @return
     */
    List<String> levelkeyName1_2_1();
    /**
     * 查询key2
     * @return
     */
    List<String> levelkeyName2_2_1();
    /**
     * 查询key3
     * @return
     */
    List<String> levelkeyName3_2_1();



    /**
     * 查询key1 二级查询
     * @return
     */
    List<String> levelkeyName1_1_0();
    /**
     * 查询key2
     * @return
     */
    List<String> levelkeyName2_1_0();
    /**
     * 查询key3
     * @return
     */
    List<String> levelkeyName3_1_0();

    /**
     * 查询key1 三级查询
     * @return
     */
    List<String> levelkeyName1_0_2();
    /**
     * 查询key2
     * @return
     */
    List<String> levelkeyName2_0_2();
    /**
     * 查询key3
     * @return
     */
    List<String> levelkeyName3_0_2();


    /**
     * 查询key1 四级查询
     * @return
     */
    List<String> levelkeyName1_2_4();
    /**
     * 查询key2
     * @return
     */
    List<String> levelkeyName2_2_4();
    /**
     * 查询key3
     * @return
     */
    List<String> levelkeyName3_2_4();

    /**
     * 查询key1 五级查询
     * @return
     */
    List<String> levelkeyName1_4_6();
    /**
     * 查询key2
     * @return
     */
    List<String> levelkeyName2_4_6();
    /**
     * 查询key3
     * @return
     */
    List<String> levelkeyName3_4_6();


    /**
     * 查询详情
     */

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
