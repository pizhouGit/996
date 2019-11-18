package com.imooc.pz.lambda.Stream;


import com.alibaba.fastjson.JSON;
import com.imooc.pz.lambda.cart.CartService;
import com.imooc.pz.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *常见预定义收集器的使用
 */
public class StreamCollector {

    /**
     * 集合收集器
     */
    @Test
    public void toList(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> collect = cartSkuList.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(
                JSON.toJSONString(collect,true)
        );
    }


    /**
     * 分组
     */
    @Test
    public void group(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //map<分组条件，结果集合>
        Map<Enum, List<Sku>> collect = cartSkuList.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(
                JSON.toJSONString(collect,true)
        );

    }

    /**
     * 分区---以true和false区分
     */
    @Test
    public void partition(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Boolean, List<Sku>> collect = cartSkuList.stream()
                .collect(Collectors.partitioningBy(
                        sku -> sku.getTotalPrice() > 100
                ));

        System.out.println(
                JSON.toJSONString(collect,true)
        );
    }




}
