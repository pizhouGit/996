package com.imooc.pz.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version1Test {

    @Test
    public void filteElectoronicsSkus () {

        //获取商品信息
        List<Sku> cartSkuList = CartService.getCartSkuList();

        //查找出购物车中数码类商品
        List<Sku> skus = CartService.filteElectoronicsSkus(cartSkuList);

        System.out.println(
                //传入true将结果集以json的格式进行格式化
                //JSON.toJSONString将对象转为字符串
                JSON.toJSONString(skus,true)
        );




    }


    @Test
    public void filteSkuByCategory() {

        List<Sku> cartSkuList = CartService.getCartSkuList();

        //查找购物车中图书类商品集合
        List<Sku> skus = CartService.filteSkuByCategory(cartSkuList, SkuCategoryEnum.BOOKS);

        System.out.println(
                JSON.toJSONString(skus,true)
        );
    }

    @Test
    public void filteSus(){

        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skus = CartService.filteSus(cartSkuList, SkuCategoryEnum.CLOTHING, 4000.0, false);

        System.out.println(
                JSON.toJSONString(skus,true)
        );
    }


    @Test
    public void  filterSkus(){

        SkuBooksCategoryPredicate skuBooksCategoryPredicate= new SkuBooksCategoryPredicate();
        SkuTotalPricePredicate skuTotalPricePredicate = new SkuTotalPricePredicate();

        List<Sku> cartSkuList = CartService.getCartSkuList();

        //List<Sku> skus = CartService.filterSkus(cartSkuList, skuBooksCategoryPredicate);
        List<Sku> skus = CartService.filterSkus(cartSkuList, skuTotalPricePredicate);
        System.out.println(
                JSON.toJSONString(skus,true)
        );
    }



}
