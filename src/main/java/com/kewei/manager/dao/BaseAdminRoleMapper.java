package com.kewei.manager.dao;

import com.kewei.manager.pojo.BaseAdminRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseAdminRoleMapper extends MyMapper<BaseAdminRole> {
    /**
     * 获取角色信息
     * @return
     */
    List<BaseAdminRole> getRoleList();

    List<BaseAdminRole> getRoles();

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    int updateRole(BaseAdminRole role);

    int updateRoleStatus(@Param("id") Integer id,@Param("roleStatus") Integer roleStatus);

    /**
     * 添加信息
     * @param baseAdminRole
     * @return
     */
    int insertRoles(BaseAdminRole baseAdminRole);

}