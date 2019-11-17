package com.imooc.pz.lambda.cart;

/**
 * 对sku的总价是否超出2000作为判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate{

    public boolean test(Sku sku) {
        return sku.getTotalPrice()>2000;
    }
}
