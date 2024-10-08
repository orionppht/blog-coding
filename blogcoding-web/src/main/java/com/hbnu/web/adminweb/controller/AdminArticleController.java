package com.hbnu.web.adminweb.controller;

import com.hbnu.model.vo.adminweb.vo.article.PublishArticleReqVO;
import com.hbnu.common.aspect.ApiOperationLog;
import com.hbnu.common.response.Response;
import com.hbnu.web.adminweb.service.AdminArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AdminArticleController
 * @Description 文章模块
 * @Date 2024/9/26 23:50
 * @Created by pht
 */
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {
    @Autowired
    private AdminArticleService articleService;

    @PostMapping("/publish")
    @ApiOperationLog(description = "发布文章")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response publishArticle(@RequestBody @Validated PublishArticleReqVO publishArticleReqVO){

        return articleService.publishArticle(publishArticleReqVO);
    }


}
