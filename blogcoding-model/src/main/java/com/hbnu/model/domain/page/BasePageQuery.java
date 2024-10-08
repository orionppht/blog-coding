package com.hbnu.model.domain.page;

import lombok.Data;

/**
 * @Classname BasePageQuery
 * @Description TODO
 * @Date 2024/10/7 15:23
 * @Created by pht
 */
@Data
public class BasePageQuery {
    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;
}
