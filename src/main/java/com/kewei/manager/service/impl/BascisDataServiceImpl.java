package com.kewei.manager.service.impl;

import com.kewei.manager.common.utils.DateUtils;
import com.kewei.manager.dao.BaseBascisDataMapper;
import com.kewei.manager.pojo.BaseBascisData;
import com.kewei.manager.service.BascisDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据实现类
 *
 * @author Administrator
 * @date 2019/5/29 0029
 **/
@Service
public class BascisDataServiceImpl implements BascisDataService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
     BaseBascisDataMapper baseBascisDataMapper;

    @Override
    public int getCncount() {
        return baseBascisDataMapper.getCncount();
    }

    @Override
    public List<Map<String, Object>> findBaseData(Map<String, Object> pagemap) {
        List<Map<String, Object>> baseDataList =baseBascisDataMapper.findBaseData(pagemap);
        return baseDataList;
    }

    @Override
    public Map<String, Object> updateBascisData(BaseBascisData baseBascisData) {
        Map<String,Object> data = new HashMap();
        try {
            baseBascisData.setUpdateTime(DateUtils.getCurrentDate());
            int result = baseBascisDataMapper.updateBascisData(baseBascisData);
            if(result == 0){
                data.put("code",0);
                data.put("msg","更新失败！");
                logger.error("数据[更新]，结果=更新失败！");
                return data;
            }
            data.put("code",1);
            data.put("msg","更新成功！");
            logger.info("数据[更新]，结果=更新成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("数据[更新]异常！", e);
            return data;
        }
        return data;
    }

    @Override
    public Map<String, Object> delBascisData(Integer id) {
        Map<String, Object> data = new HashMap<>();
        try{
            int result = baseBascisDataMapper.deleteBascisData(id);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除数据失败");
            }
            data.put("code",1);
            data.put("msg","删除数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除数据异常！", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> insertBascisData(BaseBascisData baseBascisData) {
        Map<String,Object> data = new HashMap();
        try {
            baseBascisData.setCreateTime(DateUtils.getCurrentDate());
            baseBascisData.setUpdateTime(DateUtils.getCurrentDate());
            int result = baseBascisDataMapper.insertBascisDatas(baseBascisData);
            if(result == 0){
                data.put("code",0);
                data.put("msg","新增数据失败");
                logger.error("新增数据失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","新增数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加数据！异常！", e);
        }
        return data;
    }
}
