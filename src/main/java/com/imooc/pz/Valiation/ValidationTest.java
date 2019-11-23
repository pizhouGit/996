package com.imooc.pz.Valiation;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
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

    //验证结果集合
    private Set<ConstraintViolation<UserInfoService>> otherSet;




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

        UserInfo friend = new UserInfo();
        friend.setUserId("002");
        friend.setUserName("lis");
        friend.setPassWord("98766555");
        friend.setEmail("sdf@qq.com");

        userInfo.setFriends(new ArrayList(){
            {
                add(friend);
            }
        });
    }

    /**
     * 对结果打印
     */
    @After
    public void print(){
        otherSet.forEach(
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

    /**
     * 级联验证测试方法
     */
    @Test
    public void test() {
       set = validator.validate(userInfo);

    }

    /**
     * 分组验证测试
     */
    @Test
    public void test2() {
        //登陆
      // set = validator.validate(userInfo,UserInfo.LoginGroup.class);
       //注册
       set = validator.validate(userInfo,UserInfo.RegisterGroup.class);

    }


    /**
     * 组排序
     */
    @Test
    public void test3() {
        set = validator.validate(userInfo,UserInfo.Group.class);

    }


    /**
     * 对方法输入参数进行约束注解校验
     */
    @Test
    public void paramVaildation() throws NoSuchMethodException {
        //获取验证校验执行器
        ExecutableValidator executableValidator =
                validator.forExecutables();

        //待验证对象
        UserInfoService userInfoService = new UserInfoService();

        //待验证方法
        Method setUserInfo = userInfoService.getClass().
                getMethod("setUserInfo", UserInfo.class);

        //方法输入参数
        Object[] param = new Object[]{new UserInfo()};

        //对方法的输入参数进行校验
        otherSet = executableValidator.validateParameters(
                userInfoService,
                setUserInfo,
                param);

    }

    /**
     * 对方法返回值进行约束注解校验
     * @throws NoSuchMethodException
     */
    @Test
    public void paramVaildatio2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取验证校验执行器
        ExecutableValidator executableValidator =
                validator.forExecutables();

        //待验证对象
        UserInfoService userInfoService = new UserInfoService();

        //待验证方法
        Method getUserInfo = userInfoService.getClass().
                getMethod("getUserInfo");

        //调用方法得到返回值
        Object invoke = getUserInfo.invoke(userInfoService);

        //对方法的输入参数进行校验
        otherSet = executableValidator.validateReturnValue(
                userInfoService,
                getUserInfo,
                invoke
        );

    }



}
