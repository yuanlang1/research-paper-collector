package com.yl.paperservice.service;

import com.yl.paperservice.dto.RecentTaskDTO;
import com.yl.paperservice.dto.SearchArgumentDTO;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-03 22:15
 */
public interface SearchService {
    List<RecentTaskDTO> getRecentTask(int limit);

    Long addTask(SearchArgumentDTO searchArgumentDTO);
    ;

    void executeTask(Long id, String searchWord, List<String> keywords);
}
