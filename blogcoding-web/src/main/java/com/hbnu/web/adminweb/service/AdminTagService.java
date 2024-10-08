package com.hbnu.web.adminweb.service;

import com.hbnu.common.response.PageResponse;
import com.hbnu.common.response.Response;
import com.hbnu.model.vo.adminweb.vo.tag.AddTagReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.DeleteTagReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.FindTagPageListReqVO;
import com.hbnu.model.vo.adminweb.vo.tag.SearchTagReqVO;

/**
 * @Classname AdminTagService
 * @Description 标签模块
 * @Date 2024/10/7 20:53
 * @Created by pht
 */
public interface AdminTagService {
    /**
     * 新增标签
     * @param addTagReqVO
     * @return
     */
    Response addTag(AddTagReqVO addTagReqVO);

    /**
     * 标签分页查询
     * @param findTagPageListReqVO
     * @return
     */

    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);


    /**
     * 删除标签
     * @param deleteTagReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteTagReqVO);

    /**
     * 下拉搜索
     * @param searchTagReqVO
     * @return
     */

    Response searchTag(SearchTagReqVO searchTagReqVO);
}
