package com.kewei.manager.controller.system;

import com.kewei.manager.pojo.BaseBascisData;
import com.kewei.manager.service.BascisDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础管理控制层
 *
 * @author Administrator
 * @date 2019/5/29 0029
 **/
@Controller
@RequestMapping("data")
public class BascisDataController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BascisDataService bascisDataService;

    /**
     * 跳转到角色管理
     * @return
     */
    @RequestMapping("/dataManage")
    public String toPage() {
        logger.info("进入数据管理");
        return "/data/dataManage";
    }

    /**
     * 获取全部数据加所有数据条数
     * @param page
     * @param limit
     * @param pagemap
     * @return
     */
    @GetMapping("/selectBaseData")
    @ResponseBody
    public Map<String , Object> selectBaseData(int page,int limit,Map<String,Object> pagemap){
        pagemap.put("page",(page-1)*limit);
        pagemap.put("num",limit);
        List<Map<String,Object>> cnlist = bascisDataService.findBaseData(pagemap);
        HashMap<String,Object> map=new HashMap<>();
        //获取数据库总数
        int count = bascisDataService.getCncount();
        map.put("code",0);
        map.put("count", count);
        map.put("data",cnlist);
        return map;
    }
    @GetMapping("/getCount")
    @ResponseBody
    public Map<String , Object> getCount(){
        HashMap<String,Object> map=new HashMap<>();
        //获取数据库总数
        int result = bascisDataService.getCncount();
        map.put("result", result);
        return map;
    }

    /**
     * 设置数据[新增或更新]
     * @param baseBascisData
     * @return
     */
    @PostMapping("setDatas")
    @ResponseBody
    public Map<String,Object> setDatas(BaseBascisData baseBascisData){
        logger.info("设置数据[新增或更新]！baseBascisData:" + baseBascisData);
        Map<String,Object> data = new HashMap();
        if(baseBascisData.getId() == null){
            //新增数据
            data = bascisDataService.insertBascisData(baseBascisData);
        }else{
            //修改数据
            data = bascisDataService.updateBascisData(baseBascisData);
        }
        return data;
    }
    /**
     * 删除数据
     * @param id
     * @return
     */
    @PostMapping("delDatas")
    @ResponseBody
    public Map<String,Object> delDatas(@RequestParam("id") Integer id){
        logger.info("删除数据！id:" + id);
        Map<String, Object> data = new HashMap<>();
            //删除角色
            data = bascisDataService.delBascisData(id);
        return data;
    }
}
