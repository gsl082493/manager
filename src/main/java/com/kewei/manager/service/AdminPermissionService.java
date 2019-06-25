package com.kewei.manager.service;

import com.kewei.manager.dto.PermissionDTO;
import com.kewei.manager.pojo.BaseAdminPermission;
import com.kewei.manager.pojo.BaseAdminUser;
import com.kewei.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;

/**
 * @Title: PermissionService
 * @Description:
 * @auther: Administrator
 * @date: 2019/5/17 9:22
 */
public interface AdminPermissionService {

    /**
     *
     * 功能描述: 添加权限
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    Map<String,Object> addPermission(BaseAdminPermission permission);

    /**
     *
     * 功能描述: 修改权限
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    Map<String,Object> updatePermission(BaseAdminPermission permission);

    /**
     *
     * 功能描述: 获取权限菜单列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    PageDataResult getPermissionList(Integer pageNum, Integer pageSize);

    /**
     *
     * 功能描述: 获取根权限菜单列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    List<PermissionDTO> parentPermissionList();

    /**
     *
     * 功能描述: 删除权限菜单
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    Map<String, Object> del(long id);

    /**
     *
     * 功能描述: 根据id获取权限
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    BaseAdminPermission getById(Object id);


    /**
     *
     * 功能描述: 获取当前登陆用户的权限
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/17 9:22
     */
    Map<String, Object> getUserPerms(BaseAdminUser user);

}
