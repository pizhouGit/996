package com.imooc.pz.lambda.Stream;

import com.alibaba.fastjson.JSON;
import com.imooc.pz.lambda.cart.CartService;
import com.imooc.pz.lambda.cart.Sku;
import com.imooc.pz.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 演示流的各种操作
 */
public class StreamOperator {


    List<Sku> list ;

    @Before //在test注解之前执行
    public void init(){
        list = CartService.getCartSkuList();
    }


    /**
     * filter使用：过滤掉不符合断言判断的数据
     */
    @Test
    public void filterTest(){

        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()
                ))
                .forEach(item-> System.out.println(
                        JSON.toJSONString(item,true)
                ));

    }


    /**
     * map使用：将一个元素转换成另外一个元素
     */
    @Test
    public void mapTest(){
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(System.out::println);
    }


    /**
     * flatMap:将一个对象转换为流
     */
    @Test
    public void flatMapTest(){
        list.stream()
                .flatMap(sku -> Arrays.stream(
                        sku.getSkuName().split("")
                ))
                .forEach(item-> System.out.println(
                        JSON.toJSONString(item,true)
                ));
    }

    /**
     * peek:对流中的元素进行遍历操作-----是中间操作不是终结操作
     */
    @Test
    public void peek(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))//没有返回值，就是单纯的进行操作
                .forEach(
                        item-> System.out.println(
                                JSON.toJSONString(item,true)
                        )
                );
    }

    /**
     * sorted:排序---默认是自然排序
     */
    @Test
    public void sortTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(
                        item-> System.out.println(
                                JSON.toJSONString(item,true)
                        )
                );
    }

    /**
     * distinct：去重
     */
    @Test
    public void distinctTest(){
         list.stream()
            .map(sku -> sku.getSkuCategory())

                 .distinct()
                 .forEach(
                         item-> System.out.println(
                                 JSON.toJSONString(item,true)
                         )
                 );

    }

    /**
     * skip:跳过多少元素
     */
    @Test
    public void skipTest(){
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(
                        item-> System.out.println(
                                JSON.toJSONString(item,true)
                        )
                );
    }

    /**
     * limit:截取
     */
    @Test
    public void limitTest(){
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(2*3)
                .limit(3)
                .forEach(
                        item-> System.out.println(
                                JSON.toJSONString(item,true)
                        )
                );
    }

    /**
     * findFirst找到第一个元素
     */
    @Test
    public void findFisTest(){
        Optional<Sku> first = list.stream()
                .findFirst();
        System.out.println(first);
    }


    /**
     * findAny找到任意一个元素，随机
     */
    @Test
    public void findAnTest(){
        Optional<Sku> any = list.stream().findAny();
        System.out.println(any);
    }


    /**
     * max:获取最大值
     * mapToDouble：将一个元素映射为Double类型的
     */
    @Test
    public void maxTest(){
        OptionalDouble max = list.stream()
                //获取总价
                .mapToDouble(Sku::getTotalPrice)
                .max();
        System.out.println(max.getAsDouble());
    }

    /**
     * min:获取最小值
     * mapToDouble：将一个元素映射为Double类型的
     */
    @Test
    public void minTest(){
        OptionalDouble min = list.stream()
                //获取总价
                .mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(min.getAsDouble());
    }

    /**
     * count:获取元素中的总元素数
     */
    @Test
    public void countTset(){
        long count = list.stream().count();
        System.out.println(count);
    }


}
