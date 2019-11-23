package com.imooc.pz.Valiation;


import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * 待验证对象实体类
 * 用户信息类
 */

public class UserInfo {

    //用户id
    @NotNull(message = "用户id不能为空")
    private String userId;

    //用户姓名---notEmpty 不会去掉前后空格
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    //用户密码---- notBlank 会自动去掉字符串前后空格验证是否为空
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6,max = 20,message = "密码长度不能少于6位，多于20位" )
    private String passWord;

    //用户邮箱
    @Email(message = "邮箱必须为有效邮箱")
    private String email;

    //用户手机号
    private String phone;

    //生日
    @Past(message = "日期不能为未来时间")
    private Date birthday;

    //好友列表
    @Size(min = 1,message = "不能少于1个好友")
    private List<UserInfo> friends;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<UserInfo> friends) {
        this.friends = friends;
    }
}
