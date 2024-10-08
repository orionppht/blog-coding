package com.hbnu.model.vo.adminweb.vo.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Classname FindTagPageListRspVO
 * @Description TODO
 * @Date 2024/10/7 22:46
 * @Created by pht
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindTagPageListRspVO {
    /**
     * 标签 ID
     */
    private Long id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
