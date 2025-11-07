package com.yl.paperservice.controller;

import com.yl.paperservice.dto.SearchDTO;
import com.yl.paperservice.result.ServiceResponse;
import com.yl.paperservice.service.SearchService;
import com.yl.paperservice.dto.RecentTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-01 13:11
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/recentSearch")
    public ServiceResponse<List<RecentTaskDTO>> getRecentTask(@RequestParam("limitNum") int limitNum){
        List<RecentTaskDTO> recentTask = searchService.getRecentTask(limitNum);
        return ServiceResponse.success(recentTask);
    }

    @PostMapping("/submitSearch")
    public ServiceResponse<Long> addTask(@RequestBody SearchDTO searchDTO){
        Long id = searchService.addTask(searchDTO);
        searchService.executeTask(id, searchDTO.getSearchWord(), searchDTO.getKeywords());
        return ServiceResponse.success(id);
    }

}