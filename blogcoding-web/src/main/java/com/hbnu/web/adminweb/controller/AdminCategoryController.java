package com.hbnu.web.adminweb.controller;

import com.hbnu.common.response.PageResponse;
import com.hbnu.common.response.Response;
import com.hbnu.model.vo.adminweb.vo.category.AddCategoryReqVO;
import com.hbnu.model.vo.adminweb.vo.category.DeleteCategoryReqVO;
import com.hbnu.model.vo.adminweb.vo.category.FindCategoryPageListReqVO;
import com.hbnu.model.vo.adminweb.vo.category.FindCategoryPageListRspVO;
import com.hbnu.web.adminweb.service.impl.AdminCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AdminCategoryController
 * @Description 分类模块
 * @Date 2024/10/7 15:00
 * @Created by pht
 */
@RestController
@RequestMapping("/admin")
public class AdminCategoryController {
    @Autowired
    private AdminCategoryServiceImpl categoryService;

    @PostMapping("/category/add")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO){
        return categoryService.addCategory(addCategoryReqVO);

    }

    @PostMapping("/category/list")
    public PageResponse findCategoryPageList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO){
        return categoryService.findCategoryPageList(findCategoryPageListReqVO);
    }

    @PostMapping("/category/delete")
    public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO){
        return categoryService.deleteCategory(deleteCategoryReqVO);
    }

    @PostMapping("/category/search/list")
    public Response findCategorySelectList( ){
        return categoryService.findCategorySelectList();
    }


}
