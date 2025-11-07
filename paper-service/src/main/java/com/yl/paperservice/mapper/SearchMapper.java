package com.yl.paperservice.mapper;

import com.yl.paperservice.dto.RecentTaskDTO;
import com.yl.paperservice.dto.SearchDTO;
import com.yl.paperservice.entity.SearchTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-03 22:21
 */
@Mapper
public interface SearchMapper {
    List<RecentTaskDTO> getRecentTasks(int limit);

    Long addTask(SearchTask task);
}
