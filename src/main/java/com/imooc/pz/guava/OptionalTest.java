package com.imooc.pz.guava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 学习java8中的Optional的使用方法
 */
public class OptionalTest {

    @Test
    public  void  test(){
        /**
         * 三种创建Optional对象的方式
         * 1.创建空的Optional对象
         */
        Optional.empty();

        //2.使用of入参不为null,使用非NuLL值创建Optional对象
       // Optional.of("pizhou");

        //3.使用任意值创建Optional对象
        Optional<Object> optional = Optional.ofNullable(" ");

        /**
         * 判断是否引用缺失的方法（建议不直接使用）
         */
        //optional.isPresent();

        /**
         * 当Optional引用存在时执行
         * 类似的方法：map filter flatMap
         */
        optional.ifPresent(System.out::println);


        /**
         * 当Optional引用缺失时执行
         */
        optional.orElse("不存在");

        optional.orElseGet(()->{
            //自定义引用缺失时的返回值
           return "自定义引用缺失";
        });


        /*optional.orElseThrow(()->{
                    throw new RuntimeException("引用缺失异常");
                });*/
    }


    public static  void strema(List<String> list){

        //list.stream().forEach(System.out::println);
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("you di xi ");
        strema(list);
    }



}
