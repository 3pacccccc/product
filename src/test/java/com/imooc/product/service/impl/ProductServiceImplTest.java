package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService service;

    @Test
    void findUpAll() {
    }

    @Test
    public void findList() {
        List<ProductInfo> productInfoList = service.findList(Arrays.asList("1234567", "789jhiortlmtqqq"));
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void decreaseTest(){
        CartDTO cartDTO = new CartDTO("dsfq865321", 6);
        service.decreaseStock(Arrays.asList(cartDTO));
    }
}