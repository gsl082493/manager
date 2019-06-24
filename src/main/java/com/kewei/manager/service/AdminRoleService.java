package com.kewei.manager.service;

import com.kewei.manager.pojo.BaseAdminRole;
import com.kewei.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;

/**
 * @Title: AdminRoleService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 14:25
 */
public interface AdminRoleService {

    PageDataResult getRoleList(Integer pageNum, Integer pageSize);

    List<BaseAdminRole> getRoles();

    BaseAdminRole findRoleById(Integer id);

    Map<String,Object> updateRole(BaseAdminRole role);

    Map<String,Object> delRole(Integer id,Integer status);

    Map<String,Object> recoverRole(Integer id,Integer status);

    Map<String,Object> insertRole(BaseAdminRole role);

}
