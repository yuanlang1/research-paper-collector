package com.yl.paperservice.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yl
 * @date 2025-11-06 19:50
 */
@Data
@Accessors(chain = true)
public class SearchTask {
    private Long id;
    private Long userId;
    private String searchWord;
    private String keywords;
    private Integer state;
}
