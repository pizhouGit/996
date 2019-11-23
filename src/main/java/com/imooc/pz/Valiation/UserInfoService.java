package com.imooc.pz.Valiation;

import javax.validation.Valid;

/**
 * 用户信息服务类
 */
public class UserInfoService {

    /**
     * UserInfO 作为输入参数
     * @param userInfo
     */
    public void setUserInfo(@Valid UserInfo userInfo){

    }

    /**
     * UserInfo 作为输出参数
     * @return
     */
    public @Valid UserInfo getUserInfo(){
        return new UserInfo();
    }

    /**
     * 默认构造
     */
    public UserInfoService() {
    }

    public UserInfoService(UserInfo userInfo) {}

}
