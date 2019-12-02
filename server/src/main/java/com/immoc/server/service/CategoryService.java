package com.immoc.server.service;

import com.immoc.server.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

        List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
