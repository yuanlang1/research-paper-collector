package com.yl.paperservice.service.Impl;

import com.yl.paperservice.dto.PaperDTO;
import com.yl.paperservice.dto.SearchArgumentDTO;
import com.yl.paperservice.entity.SearchTask;
import com.yl.paperservice.mapper.SearchMapper;
import com.yl.paperservice.service.SearchService;
import com.yl.paperservice.dto.RecentTaskDTO;
import com.yl.paperservice.utils.ArxivParser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-03 22:19
 */
@Service
@Slf4j
public class SearchServiceImpl implements SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);


    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    @Qualifier("arxivWebClient")
    private WebClient arxivWebClient;

    @Autowired
    private ArxivParser arxivParser;

    @Override
    public List<RecentTaskDTO> getRecentTask(int limit) {
        return searchMapper.getRecentTasks(limit);
    }

    @Override
    public Long addTask(SearchArgumentDTO searchArgumentDTO) {
        SearchTask task = new SearchTask()
                .setSearchWord(searchArgumentDTO.getSearchWord())
                .setKeywords(String.join(",", searchArgumentDTO.getKeywords()))
                .setUserId(0L);
        searchMapper.addTask(task);
        return task.getId();
    }

    @Override
    public void executeTask(Long id, String searchWord, List<String> keywords) {
//        System.out.println(searchWord);
        log.info(searchWord);

        Integer start = 0;
        Integer maxResult = 1;

        Flux<PaperDTO> papers = arxivWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("search_query", "all:" + searchWord)
                        .queryParam("start", 0)
                        .queryParam("max_results", 1)
                        .build())
                .accept(MediaType.APPLICATION_ATOM_XML)
                .retrieve()
                .bodyToMono(String.class)
                .flatMapMany(arxivParser::parse);
        papers.subscribe(
                paper -> System.out.println("论文标题: " + paper.toString()),
                error -> log.error("保存失败: {}", error.getMessage())
        );
    }

}
