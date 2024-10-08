package com.hbnu.web.adminweb.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbnu.common.response.PageResponse;
import com.hbnu.common.response.Response;
import com.hbnu.model.domain.dos.TagDO;
import com.hbnu.model.domain.mapper.TagMapper;
import com.hbnu.model.vo.adminweb.vo.category.SelectRspVO;
import com.hbnu.model.vo.adminweb.vo.tag.*;
import com.hbnu.web.adminweb.service.AdminTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname AdminTagServiceImpl
 * @Description 标签模块
 * @Date 2024/10/7 20:56
 * @Created by pht
 */
@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 新增标签
     *
     * @param addTagReqVO
     * @return
     */
    @Override
    public Response addTag(AddTagReqVO addTagReqVO) {
        //vo 转do
        List<TagDO> tagDOS = addTagReqVO.getTags()
                .stream().map(TagName -> TagDO.builder()
                        .name(TagName.trim()) //去掉前后空格
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
        try {


            //批量插入
            saveBatch(tagDOS);

        } catch (Exception e) {
            log.warn("该标签已存在", e);
        }
        return Response.success();
    }

    /**
     * 分页查询标签
     *
     * @param findTagPageListReqVO
     * @return
     */

    @Override
    public PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO) {
        //分页参数，条件参数
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();
        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDate();
        LocalDate endDate = findTagPageListReqVO.getEndDate();

        //分页查询
        Page<TagDO> page = tagMapper.selectPageList(current, size, name, startDate, endDate);
        List<TagDO> records = page.getRecords();
        List<FindTagPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(records)) {
            vos = records.stream().map(tagDO -> FindTagPageListRspVO.builder()
                    .id(tagDO.getId())
                    .name(tagDO.getName())
                    .createTime(tagDO.getCreateTime())
                    .build()).collect(Collectors.toList());
        }
        return PageResponse.success(page, vos);
    }

    /**
     * 删除标签
     *
     * @param deleteTagReqVO
     * @return
     */

    @Override
    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        Long id = deleteTagReqVO.getTagId();
        tagMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public Response searchTag(SearchTagReqVO searchTagReqVO) {
        String key = searchTagReqVO.getKey();

        //执行模糊查询
        List<TagDO> tagDOS = tagMapper.selectByKey(key);
        //do转vo
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }
}
