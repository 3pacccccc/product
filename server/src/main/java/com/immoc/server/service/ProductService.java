package com.immoc.server.service;

import com.immoc.server.dataobject.ProductInfo;
import com.immoc.server.dto.CartDTO;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll(); // 查询所有在架商品列表

    List<ProductInfo> findList(List<String> productIdList); // 根据商品ID查询商品

    void decreaseStock(List<CartDTO> cartDTOList);
}
