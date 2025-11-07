package com.yl.paperservice.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yl
 * @date 2025-11-03 21:09
 */
@Data
public class RecentTaskDTO implements Serializable {
    private Integer id;
    private String searchWord;
}
