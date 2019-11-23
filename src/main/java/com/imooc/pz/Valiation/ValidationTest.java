package com.imooc.pz.Valiation;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

/**
 * 验证测试类
 */
public class ValidationTest {

    //验证器对象
    private Validator validator;

    //待验证对象
    private UserInfo userInfo;

    //验证结果集合
    private Set<ConstraintViolation<UserInfo>> set;

    /**
     * 初始化
     */
    @Before
    public void init(){
        //初始化验证器
     validator = Validation.buildDefaultValidatorFactory()
             .getValidator();

     //初始化待验证对象---用户信息
        userInfo = new UserInfo();
        userInfo.setUserId("0001");
        userInfo.setUserName("上市玩");
        userInfo.setPassWord("111111");
        userInfo.setEmail("asldhj@lfkjalsd");
        Calendar instance = Calendar.getInstance();
        instance.set(2019,1,1);
        userInfo.setBirthday(instance.getTime());
        userInfo.setFriends(new ArrayList(){
            {
                add(new UserInfo());
            }
        });
    }

    /**
     * 对结果打印
     */
    @After
    public void print(){
        set.forEach(
                item->{
                    //输出验证错误信息
                    System.out.println(item.getMessage());
                }
        );
    }

    @Test
    public void nullValidation() {

        //使用验证器对对象进行验证
        set = validator.validate(userInfo);

    }
}
