package com.hbnu.web.adminweb.controller;

import com.hbnu.common.response.PageResponse;
import com.hbnu.common.response.Response;
import com.hbnu.model.vo.adminweb.vo.category.DeleteCategoryReqVO;
import com.hbnu.model.vo.adminweb.vo.category.FindCategoryPageListReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.AddTagReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.DeleteTagReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.FindTagPageListReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.SearchTagReqVO;
import com.hbnu.web.adminweb.service.AdminTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AdminTagController
 * @Description 标签模块
 * @Date 2024/10/8 17:27
 * @Created by pht
 */
@RestController
@RequestMapping("/admin")
public class AdminTagController {
    @Autowired
    private AdminTagService tagService;

    @PostMapping("/tag/add")
    public Response addTag(@RequestBody @Validated AddTagReqVO addTagReqVO){
        return tagService.addTag(addTagReqVO);
    }

    @PostMapping("/tag/list")
    public PageResponse findTagPageList(@RequestBody @Validated FindTagPageListReqVO findTagPageListReqVO){
        return tagService.findTagPageList(findTagPageListReqVO);
    }

    @PostMapping("/tag/delete")
    public Response deleteCategory(@RequestBody @Validated DeleteTagReqVO deleteTagReqVO) {
        return tagService.deleteTag(deleteTagReqVO);
    }
    @PostMapping("tag/search")
    public Response searchTag(@RequestBody @Validated SearchTagReqVO searchTagReqVO){
        return tagService.searchTag(searchTagReqVO);
    }

}
