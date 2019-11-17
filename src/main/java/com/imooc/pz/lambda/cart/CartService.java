package com.imooc.pz.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {

    //加入到购物车中的商品的信息
    private static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
            add(new Sku(654032,"无人机",
                    4999.00, 1,
                    4999.00,SkuCategoryEnum.ELECTRONICS));

            add(new Sku(642934,"VR-一体机",
                    2999.0,1,
                    2999.0,SkuCategoryEnum.ELECTRONICS));

            add(new Sku(675489,"跑步机",
                    2699.0,1,
                    2699.0,SkuCategoryEnum.SPORTS));

            add(new Sku(644564,"JAVA编程思想",
                    79.8,1,
                    79.8,SkuCategoryEnum.BOOKS));

            add(new Sku(697894,"算法",
                    78.20,1,
                    78.20,SkuCategoryEnum.BOOKS));

            add(new Sku(696968,"TensorFlow进阶指南",
                    85.10,1,
                    85.10,SkuCategoryEnum.BOOKS));

            add(new Sku(642321,"纯色衬衣",
                    120.50,3,
                    120.50,SkuCategoryEnum.CLOTHING));

            add(new Sku(654327,"牛仔ku",
                    875.10,1,
                    875.10,SkuCategoryEnum.CLOTHING));
        }

    };


    /**
     * 获取商品信息列表
     * @return
     */
    public static List<Sku> getCartSkuList(){
        return cartSkuList;
    }


    /**
     * Version 1.0.0
     * 找出购物车中所有电子产品
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filteElectoronicsSkus(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            //如果商品类型等于电子类型
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())){
                result.add(sku);
            }

        }

        return result;

    }



    /**
     * Version 2.0.0
     * 根据传入商品类型参数，找出购物车中同种商品类型的商品列表
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filteSkuByCategory(List<Sku> cartSkuList,SkuCategoryEnum categoryEnum) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            //如果商品类型等于传入商品类型参数
            if (categoryEnum.equals(sku.getSkuCategory())){
                result.add(sku);
            }

        }

        return result;

    }


    /**
     * Version 3.0.0
     * 通过商品类型和总价来过滤商品
     * @param cartSkuList
     * categORprice true ---根据商品类型  false --根据总价
     * @return
     */
    public static List<Sku> filteSus(List<Sku> cartSkuList,SkuCategoryEnum categoryEnum,
                                     Double totalPrice ,Boolean categoryOrPrice) {
        List<Sku> result = new ArrayList<Sku>();

        for (Sku sku : cartSkuList) {
            //如果根据商品类型判断，sku类型与输入类型比较
            //如果根据商品总价判断，sku总价与输入总价比较
            if (
                    (categoryOrPrice && categoryEnum.equals(sku.getSkuCategory()))
                    ||
                    (!categoryOrPrice && sku.getTotalPrice() > totalPrice)

                    ){
                result.add(sku);
            }


        }

        return result;

    }


    /**
     * Version 4.0.0
     * 根据不同的sku判断标准，对sku列表进行过滤
     * @param cartSkuList
     * @param predicate----不同的sku判断标准策略
     * @return
     */
    public static List<Sku> filterSkus(
            List<Sku> cartSkuList ,SkuPredicate predicate) {

        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            //根据不同的Sku判断标准策略，对sku进行判断
            if (predicate.test(sku)){
                result.add(sku);
            }

        }
        return result;
    }
}
