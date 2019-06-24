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

    List<AdminUserDTO> getUserList(UserSearchDTO userSearchDTO);

    List<BaseAdminUser> getUsers();

    List<BaseAdminUser> getUsersList();

    BaseAdminUser getUserByUserName(@Param("sysUserName")String sysUserName,@Param("id") Integer id);

    int updateUserStatus(@Param("id") Integer id,@Param("status") Integer status);

    int updateUser(BaseAdminUser user);

    BaseAdminUser findByUserName(@Param("userName") String userName);

    int updatePwd(@Param("userName") String userName,@Param("password") String password);

    int insertUser(BaseAdminUser baseAdminUser);

}