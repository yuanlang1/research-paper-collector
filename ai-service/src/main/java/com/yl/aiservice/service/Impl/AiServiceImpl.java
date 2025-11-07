package com.yl.aiservice.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yl.aiservice.dto.KeywordResponse;
import com.yl.aiservice.result.ServiceResponse;
import com.yl.aiservice.service.AiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yl
 * @date 2025-11-05 20:48
 */
@Service
public class AiServiceImpl implements AiService {
    private final ChatClient chatClient;
    public AiServiceImpl(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }
    private static final String PROMPT_TEMPLATE = """
        You are an academic keyword extraction assistant.

        Input research topic: "%s"

        Task:
        - Generate EXACTLY %d relevant academic terms
        - Strictly return JSON with field name "keyword"
        - Format:
        [
            "Term1",
            "Term2",
            "Term3"
        ]

        Rules:
        - No explanations
        - No additional text besides JSON
        - Use English terms only
        """;
    @Override
    public List<String> getKeywords(String searchWord) throws JsonProcessingException {
        int topN = 3;
        String prompt = String.format(PROMPT_TEMPLATE, searchWord, topN);
        String content = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        return new ObjectMapper().readValue(content, new TypeReference<List<String>>() {});
    }
}
