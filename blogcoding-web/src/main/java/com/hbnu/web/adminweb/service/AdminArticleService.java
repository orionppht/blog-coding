package com.hbnu.web.adminweb.service;
import com.hbnu.common.response.Response;
import com.hbnu.model.vo.adminweb.vo.article.PublishArticleReqVO;

/**
 * @Classname AdminArticleService
 * @Description TODO
 * @Date 2024/9/27 16:05
 * @Created by pht
 */
public interface AdminArticleService {
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);
}
