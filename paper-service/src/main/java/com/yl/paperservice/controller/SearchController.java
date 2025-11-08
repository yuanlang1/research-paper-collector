package com.yl.paperservice.controller;

import com.yl.paperservice.dto.SearchArgumentDTO;
import com.yl.paperservice.service.SearchService;
import com.yl.paperservice.dto.RecentTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stark.dataworks.boot.web.ServiceResponse;

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

    // We need 2 pagination parameters: pageIndex & pageSize
    @GetMapping("/recentSearch")
    public ServiceResponse<List<RecentTaskDTO>> getRecentTask(@RequestParam("limitNum") int limitNum){
        List<RecentTaskDTO> recentTask = searchService.getRecentTask(limitNum);
        return ServiceResponse.buildSuccessResponse(recentTask);
    }

    @PostMapping("/submitSearch")
    public ServiceResponse<Long> addTask(@RequestBody SearchArgumentDTO searchArgumentDTO){
        Long id = searchService.addTask(searchArgumentDTO);
        searchService.executeTask(id, searchArgumentDTO.getSearchWord(), searchArgumentDTO.getKeywords());
        return ServiceResponse.buildSuccessResponse(id);
    }

}