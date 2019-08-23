package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVo;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Kelvin
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){

        //1. 查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();

        //2. 查询类目(一次性查询)
        Set<Integer> categoryTypeSet = new HashSet<>();
        //获取已上架商品所包含的所有类目(ProductCategory)
        for (ProductInfo info : productInfos) {
            categoryTypeSet.add(info.getCategoryType());
        }

        //将其转为List<Integer>类型
        List<Integer> categoryTypeList = new ArrayList<>();
        Iterator<Integer> iterator = categoryTypeSet.iterator();
        while(iterator.hasNext()){
            categoryTypeList.add(iterator.next());
        }

        //根据categoryType获取类目具体信息
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        ResultVo resultVo = new ResultVo();
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList ){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo pinfo : productInfos) {
                if(pinfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(pinfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(productVOList);
        return resultVo;

    }


}
