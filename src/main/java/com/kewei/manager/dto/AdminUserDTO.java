package com.kewei.manager.dto;

import lombok.Data;

/**
 * @Title: AdminUserDTO
 * @Description:
 * @auther: Administrator
 * @date: 2019/6/17 9:22
 */
@Data
public class AdminUserDTO {

    private Integer id;

    private String sysUserName;

    private String sysUserPwd;

    private Integer roleId;

    private String roleName;

    private String userPhone;


    private String regTime;


    private Integer userStatus;

}
