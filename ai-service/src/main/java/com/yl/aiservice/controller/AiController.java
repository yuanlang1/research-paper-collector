package com.yl.aiservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yl.aiservice.dto.KeywordResponse;
import com.yl.aiservice.result.ServiceResponse;
import com.yl.aiservice.service.AiService;
import com.yl.aiservice.service.Impl.AiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yl
 * @date 2025-11-05 9:44
 */
@RestController
@RequestMapping("/ai")
public class AiController {
    @Autowired
    private AiService aiService;
    @GetMapping("keywords")
    public ServiceResponse<List<String>> getAiKeywords(@RequestParam("search_word") String searchWord) throws JsonProcessingException {
        return ServiceResponse.success(aiService.getKeywords(searchWord));
    }
}
