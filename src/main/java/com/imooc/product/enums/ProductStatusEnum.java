package com.imooc.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    // 商品状态枚举
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
