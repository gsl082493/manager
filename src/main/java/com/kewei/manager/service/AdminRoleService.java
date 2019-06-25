package com.kewei.manager.service;

import com.kewei.manager.pojo.BaseAdminRole;
import com.kewei.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;

/**
 * @Title: AdminRoleService
 * @Description:
 * @auther: Administrator
 * @date: 2019/5/17 9:22
 */
public interface AdminRoleService {
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDataResult getRoleList(Integer pageNum, Integer pageSize);

    List<BaseAdminRole> getRoles();

    /**
     * 查找ID
     * @param id
     * @return
     */
    BaseAdminRole findRoleById(Integer id);

    /**
     * 修改
     * @param role
     * @return
     */
    Map<String,Object> updateRole(BaseAdminRole role);

    /**
     * 删除
     * @param id
     * @param status
     * @return
     */
    Map<String,Object> delRole(Integer id,Integer status);

    /**
     * 恢复
     * @param id
     * @param status
     * @return
     */
    Map<String,Object> recoverRole(Integer id,Integer status);

    Map<String,Object> insertRole(BaseAdminRole role);

}
