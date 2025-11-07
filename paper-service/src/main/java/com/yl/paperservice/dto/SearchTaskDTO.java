package com.yl.paperservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-07 17:47
 */
@Data
public class SearchTaskDTO {
    private Integer id;
    private String searchWord;
    private List<String> keyWords;
}
