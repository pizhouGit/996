package com.imooc.pz.lambda.Stream;

import com.alibaba.fastjson.JSON;
import com.imooc.pz.lambda.cart.CartService;
import com.imooc.pz.lambda.cart.Sku;
import com.imooc.pz.lambda.cart.SkuCategoryEnum;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 对比原始集合操作和Stream集合操作
 */
public class StreamVs {

    /**
     * 1.想看购物车中都有什么商品
     * 2.图书类商品都给买
     * 3.其余的商品中买两件最贵的
     * 4.只需要两件商品的名称和总价
     */

    /**
     * 以原始集合操作实现需求
     */
    @Test
    public void oldCartHandle(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        /**
         * 1.打印所有商品
         */
        for (Sku sku : cartSkuList) {
            System.out.println(
                    JSON.toJSONString(sku,true)
            );
        }

        /**
         * 2.图书类过滤
         */
        List<Sku> notBooksSkuList = new ArrayList<Sku>();

        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())){
                notBooksSkuList.add(sku);
            }
        }

        /**
         * 3.排序--降序(大--小)
         */

        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()){
                    return -1;
                }else if (sku1.getTotalPrice() < sku2.getTotalPrice()){
                    return 1;
                }else {
                    return 0;
                }
            }

        });

        List<Sku> top2SkuList = new ArrayList<>();
        for (int i = 0; i< 2; i++){
            top2SkuList.add(notBooksSkuList.get(i));
        }

        /**
         * 4.求两件商品总价
         */

        Double money = 0.0;
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }

        /**
         * 获取两件商品的名称
         */
        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        System.out.println(
                JSON.toJSONString(resultSkuNameList,true)
        );
        System.out.println("商品总价"+money);
    }



    /**
     * 以Stream流方式实现需求
     */

    public void newCartHandle(){

    }

}
