package com.kewei.manager.service;

import com.kewei.manager.dto.UserSearchDTO;
import com.kewei.manager.pojo.BaseAdminUser;
import com.kewei.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @auther: Administrator
 * @date: 2019/5/17 9:22
 */
public interface AdminUserService {
    /**
     * 分页查询数据
     * @param userSearch
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    /**
     * 修改数据
     * @param user
     * @return
     */
    Map<String,Object> updateUser(BaseAdminUser user);

    /**
     * 获取ID
     * @param id
     * @return
     */
    BaseAdminUser getUserById(Integer id);

    /**
     * 查找用户名
     * @param userName
     * @return
     */
    BaseAdminUser findByUserName(String userName);

    /**
     * 修改账号密码
     * @param userName
     * @param password
     * @return
     */
    int updatePwd(String userName,String password);

    /**
     * 删除
     * @param id
     * @param status
     * @return
     */
    Map<String, Object> delUser(Integer id,Integer status);

    /**
     * 恢复
     * @param id
     * @param status
     * @return
     */
    Map<String, Object> recoverUser(Integer id,Integer status);

    /**
     * 获取数据
     * @return
     */
    List<BaseAdminUser> getUsers();

    /**
     * 添加
     * @param baseAdminUser
     * @return
     */
    Map<String, Object> insertUsers(BaseAdminUser baseAdminUser);
}
