package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void testFindByProductIdIn(){
        List<ProductInfo> productInfoList = repository.findByProductIdIn(Arrays.asList("1234567", "789jhiortlmtqqq"));
        Assert.assertNotEquals(0, productInfoList.size());
    }
}