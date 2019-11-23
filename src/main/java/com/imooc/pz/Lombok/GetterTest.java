package com.imooc.pz.Lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

/**
 * @Getter注解---生成get方法
 */
public class GetterTest {

    @Getter
    private String file;

    /**
     * 设置访问级别
     */
    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_ = {@NonNull}
    )
    private String file2;
}
