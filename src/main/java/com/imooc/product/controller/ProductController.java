package com.imooc.product.controller;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVoUtil;
import com.imooc.product.vo.ProductInfoVo;
import com.imooc.product.vo.ProductVo;
import com.imooc.product.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("product")
public class ProductController {
    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {
        // 1.查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        //3.查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4.构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);  // 直接将productInfo的字段拷贝到productInfoVo
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVoUtil.success(productVoList);
    }

    /**
     * 获取商品列表(给订单服务用的)
     * @param productIdList 商品ID列表
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
