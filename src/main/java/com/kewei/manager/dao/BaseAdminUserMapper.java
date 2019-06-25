package com.kewei.manager.dao;


import com.kewei.manager.dto.AdminUserDTO;
import com.kewei.manager.dto.UserSearchDTO;
import com.kewei.manager.pojo.BaseAdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseAdminUserMapper extends MyMapper<BaseAdminUser> {
    /**
     * 获取用户信息
     * @param userSearchDTO
     * @return
     */

    List<AdminUserDTO> getUserList(UserSearchDTO userSearchDTO);

    List<BaseAdminUser> getUsers();

    List<BaseAdminUser> getUsersList();

    /**
     * 通过Name、Id查询
     * @param sysUserName
     * @param id
     * @return
     */
    BaseAdminUser getUserByUserName(@Param("sysUserName")String sysUserName,@Param("id") Integer id);

    /**
     * 通过ID、Status修改
     * @param id
     * @param status
     * @return
     */
    int updateUserStatus(@Param("id") Integer id,@Param("status") Integer status);

    int updateUser(BaseAdminUser user);

    /**
     * 查找用户名
     * @param userName
     * @return
     */
    BaseAdminUser findByUserName(@Param("userName") String userName);

    /**
     * 修改用户名、密码
     * @param userName
     * @param password
     * @return
     */
    int updatePwd(@Param("userName") String userName,@Param("password") String password);

    /**
     * 添加用户
     * @param baseAdminUser
     * @return
     */
    int insertUser(BaseAdminUser baseAdminUser);

}