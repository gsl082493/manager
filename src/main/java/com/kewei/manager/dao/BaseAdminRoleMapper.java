package com.kewei.manager.dao;

import com.kewei.manager.pojo.BaseAdminRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseAdminRoleMapper extends MyMapper<BaseAdminRole> {
    List<BaseAdminRole> getRoleList();

    List<BaseAdminRole> getRoles();

    int updateRole(BaseAdminRole role);

    int updateRoleStatus(@Param("id") Integer id,@Param("roleStatus") Integer roleStatus);

    int insertRoles(BaseAdminRole baseAdminRole);

}