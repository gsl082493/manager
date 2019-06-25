package com.kewei.manager.controller.system;

import com.kewei.manager.pojo.BaseBascisData;
import com.kewei.manager.service.ExcelBascisDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 数据库数据导入Excel
 *
 * @author Administrator
 * @date 2019/6/3 0003
 **/
@Controller
@RequestMapping("/display")
public class ExcelBascisDataController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcelBascisDataService excelBascisDataService;

    /**
     * 获取折线图数据
     * @return
     */
    @GetMapping("/getExcel")
    @ResponseBody
    public Map<String , Object> getExcelBascisBase(){
        logger.info("获取折线图数据");
        List<BaseBascisData> list = excelBascisDataService.getExcelBase();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    /**
     * 获取时间
     * @return
     */
    @GetMapping("/getTime")
    @ResponseBody
    public Map<String , Object> getTimeBases(){
        logger.info("获取时间");
        List<BaseBascisData> list = excelBascisDataService.getTimeBase();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     * 查询符合条件的个数
     * @return
     */
    @GetMapping("/levelCount")
    public String levelCount(HttpServletRequest request){
        logger.info("获取一级参数数量");
        Integer int1 = excelBascisDataService.selectKeylevel1();
        request.setAttribute("key1",int1);

        logger.info("获取二级参数数量");
        Integer int2 = excelBascisDataService.selectKeylevel2();
        request.setAttribute("key2",int2);

        logger.info("获取三级参数数量");
        Integer int3 = excelBascisDataService.selectKeylevel3();
        request.setAttribute("key3",int3);

        logger.info("获取四级参数数量");
        Integer int4 = excelBascisDataService.selectKeylevel4();
        request.setAttribute("key4",int4);

        logger.info("获取五级参数数量");
        Integer int5 = excelBascisDataService.selectKeylevel5();
        request.setAttribute("key5",int5);
        return "display/display";
    }

    /**
     * 查询一级的数据
     */
    @GetMapping("/levelData1")
    @ResponseBody
    public Map<String , Object> levelData1(){
        logger.info("获取一级数据");
        List<String> str1_2_1 = excelBascisDataService.selectKeyName1_2_1();
        List<String> str2_2_1 = excelBascisDataService.selectKeyName2_2_1();
        List<String> str3_2_1 = excelBascisDataService.selectKeyName3_2_1();
        List<List<String>> list = new ArrayList();
        list.add(str1_2_1);
        list.add(str2_2_1);
        list.add(str3_2_1);
        List lists = new ArrayList();
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j< list.get(i).size(); j++){
                    lists.add(list.get(i).get(j));
                }
            }
            Collections.sort(lists);
            List list2 = new ArrayList();
            Map<String , Object> map = new HashMap<>();
        if(lists.size() > 0){
            list2.add(lists.get(lists.size()-1));
            map.put("list2",list2);
            return map;
        }
            return null;
    }

    /**
     * 查询二级的数据
     */
    @GetMapping("/levelData2")
    @ResponseBody
    public Map<String ,Object> levelData2() {
        logger.info("二级数据");
        List<String> str1_1_0 = excelBascisDataService.selectKeyName1_1_0();
        List<String> str2_1_0 = excelBascisDataService.selectKeyName2_1_0();
        List<String> str3_1_0 = excelBascisDataService.selectKeyName3_1_0();
        List<List<String>> list = new ArrayList();
        list.add(str1_1_0);
        list.add(str2_1_0);
        list.add(str3_1_0);
        List lists = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j< list.get(i).size(); j++){
                lists.add(list.get(i).get(j));
            }
        }
        Collections.sort(lists);
        List list2 = new ArrayList();
        Map<String , Object> map = new HashMap<>();
        if(lists.size() > 0){
            list2.add(lists.get(lists.size()-1));
            map.put("list2",list2);
            return map;
        }
        return null;
    }
    /**
     * 查询三级的数据
     */
    @GetMapping("/levelData3")
    @ResponseBody
    public Map<String , Object> levelData3() {
        logger.info("三级数据");
        List<String> str1_0_2 = excelBascisDataService.selectKeyName1_0_2();
        List<String> str2_0_2 = excelBascisDataService.selectKeyName2_0_2();
        List<String> str3_0_2 = excelBascisDataService.selectKeyName3_0_2();
        List<List<String>> list = new ArrayList();
        list.add(str1_0_2);
        list.add(str2_0_2);
        list.add(str3_0_2);
        List lists = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j< list.get(i).size(); j++){
                lists.add(list.get(i).get(j));
            }
        }
        Collections.sort(lists);
        List list2 = new ArrayList();
        Map<String , Object> map = new HashMap<>();
        if(lists.size() > 0){
            list2.add(lists.get(lists.size()-1));
            map.put("list2",list2);
            return map;
        }
        return null;
    }
    /**
     * 查询四级的数据
     */
    @GetMapping("/levelData4")
    @ResponseBody
    public Map<String , Object> levelData4() {
        logger.info("四级数据");
        List<String> str1_2_4 = excelBascisDataService.selectKeyName1_2_4();
        List<String> str2_2_4 = excelBascisDataService.selectKeyName2_2_4();
        List<String> str3_2_4 = excelBascisDataService.selectKeyName3_2_4();
        List<List<String>> list = new ArrayList();
        list.add(str1_2_4);
        list.add(str2_2_4);
        list.add(str3_2_4);
        List lists = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j< list.get(i).size(); j++){
                lists.add(list.get(i).get(j));
            }
        }
        Collections.sort(lists);
        List list2 = new ArrayList();
        Map<String , Object> map = new HashMap<>();
        if(lists.size() > 0){
            list2.add(lists.get(lists.size()-1));
            map.put("list2",list2);
            return map;
        }
        return null;
    }
    /**
     * 查询五级的数据
     */
    @GetMapping("/levelData5")
    @ResponseBody
    public Map<String , Object> levelData5() {
        logger.info("五级数据");
        List<String> str1_4_6 = excelBascisDataService.selectKeyName1_4_6();
        List<String> str2_4_6 = excelBascisDataService.selectKeyName2_4_6();
        List<String> str3_4_6 = excelBascisDataService.selectKeyName3_4_6();
        List<List<String>> list = new ArrayList();
        list.add(str1_4_6);
        list.add(str2_4_6);
        list.add(str3_4_6);
        List lists = new ArrayList();
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j< list.get(i).size(); j++){
                    lists.add(list.get(i).get(j));
                }
            }
            Collections.sort(lists);
            List list2 = new ArrayList();
            Map<String , Object> map = new HashMap<>();
            if(lists.size() > 0){
            list2.add(lists.get(lists.size()-1));
            map.put("list2",list2);
            return map;
        }
        return null;
    }

    /**
     * 查询一级所有相关属性
     * @return
     */
    @GetMapping("/selectOne")
    @ResponseBody
    public Map<String , Object> selectOne(){
        logger.info("查询一级所有相关属性");
        List<BaseBascisData> list = excelBascisDataService.selectParticulars1();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
     }
    /**
     * 查询二级所有相关属性
     * @return
     */
    @GetMapping("/selectTwo")
    @ResponseBody
    public Map<String ,Object> selectTwo(){
        logger.info("查询二级所有相关属性");
        List<BaseBascisData> list = excelBascisDataService.selectParticulars2();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     * 查询三级所有相关属性
     * @return
     */
    @GetMapping("/selectThree")
    @ResponseBody
    public Map<String, Object> selectThree(){
        logger.info("查询三级所有相关属性");
        List<BaseBascisData> list = excelBascisDataService.selectParticulars3();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     * 查询四级所有相关属性
     * @return
     */
    @GetMapping("/selectFour")
    @ResponseBody
    public Map<String ,Object> selectFour(){
        logger.info("查询四级所有相关属性");
        List<BaseBascisData> list = excelBascisDataService.selectParticulars4();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     * 查询五级所有相关属性
     * @return
     */
    @GetMapping("/selectFive")
    @ResponseBody
    public Map<String , Object> selectFive(){
        logger.info("查询五级所有相关属性");
        List<BaseBascisData> list = excelBascisDataService.selectParticulars5();
        Map<String , Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
}
