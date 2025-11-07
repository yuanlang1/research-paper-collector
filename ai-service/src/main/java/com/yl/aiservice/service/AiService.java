package com.yl.aiservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yl.aiservice.dto.KeywordResponse;
import org.stringtemplate.v4.ST;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-05 10:29
 */
public interface AiService {
    List<String> getKeywords(String searchWord) throws JsonProcessingException;
}
