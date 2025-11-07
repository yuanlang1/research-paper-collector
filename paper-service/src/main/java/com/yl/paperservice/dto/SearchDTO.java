package com.yl.paperservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-06 19:36
 */
@Data
public class SearchDTO {
    @JsonProperty("search_word")
    private String searchWord;
    private List<String> Keywords;
}
