package com.hbnu.model.vo.adminweb.vo.tag;

import com.hbnu.model.domain.page.BasePageQuery;
import lombok.*;

import java.time.LocalDate;

/**
 * @Classname FindTagPageListReqVO
 * @Description TODO
 * @Date 2024/10/7 22:29
 * @Created by pht
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindTagPageListReqVO extends BasePageQuery {
    /**
     * 标签名称
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
