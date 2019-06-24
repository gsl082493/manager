package com.kewei.manager.service;

import com.kewei.manager.pojo.BaseBascisData;
import java.util.List;
import java.util.Map;

public interface BascisDataService {

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

    Map<String,Object> updateBascisData(BaseBascisData baseBascisData);

    Map<String, Object> delBascisData(Integer id);

    Map<String,Object> insertBascisData(BaseBascisData baseBascisData);
}
