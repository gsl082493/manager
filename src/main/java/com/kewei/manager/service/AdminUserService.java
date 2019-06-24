package com.kewei.manager.service;

import com.kewei.manager.dto.UserSearchDTO;
import com.kewei.manager.pojo.BaseAdminUser;
import com.kewei.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface AdminUserService {

    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> updateUser(BaseAdminUser user);

    BaseAdminUser getUserById(Integer id);

    BaseAdminUser findByUserName(String userName);

    int updatePwd(String userName,String password);

    Map<String, Object> delUser(Integer id,Integer status);

    Map<String, Object> recoverUser(Integer id,Integer status);

    List<BaseAdminUser> getUsers();

    Map<String, Object> insertUsers(BaseAdminUser baseAdminUser);
}
