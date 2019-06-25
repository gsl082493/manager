package com.kewei.manager.dao;

import com.kewei.manager.dto.PermissionDTO;
import com.kewei.manager.pojo.BaseAdminPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseAdminPermissionMapper extends MyMapper<BaseAdminPermission> {

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

    List<PermissionDTO> getPermissionList();

    List<PermissionDTO> parentPermissionList();

    /**
     * 修改数据
     * @param permission
     * @return
     */
    int updatePermission(BaseAdminPermission permission);

    /**
     * 通过Id查询
     * @param pid
     * @return
     */
    List<PermissionDTO> getPermissionListByPId(@Param("pid") Integer pid);
}