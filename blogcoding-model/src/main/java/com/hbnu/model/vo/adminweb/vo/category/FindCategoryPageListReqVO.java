package com.hbnu.model.vo.adminweb.vo.category;

import com.hbnu.model.domain.page.BasePageQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Classname FindCategoryPageListReqVO
 * @Description TODO
 * @Date 2024/10/7 15:26
 * @Created by pht
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCategoryPageListReqVO extends BasePageQuery {
    /**
     * 分类名称
     */
    private String name;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
