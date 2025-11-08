//package com.yl.paperservice.event;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yl.paperservice.config.WebClientConfig;
//import com.yl.paperservice.dto.SearchTaskDTO;
//import com.yl.paperservice.utils.Constant;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.MediaType;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//
///**
// * @author yl
// * @date 2025-11-07 16:58
// */
//@Component
//@Slf4j
//public class EventConsumer implements Constant {
//    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
//    @Autowired
//    @Qualifier("arxivWebClient")
//    private WebClient webClient;
//    @KafkaListener(topics = {TOPIC_SEARCH})
//    public void handlerSearch(ConsumerRecord record){
//        if (record == null ||record.value() == null) {
//            logger.error("消息内容为空");
//            return;
//        }
//        SearchTaskDTO searchTask = JSONObject.parseObject(record.value().toString(), SearchTaskDTO.class);
//        if(searchTask == null){
//            logger.error("消息格式不符合");
//            return;
//        }
//        webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/query")
//                        .queryParam("search_query", "all:" + searchTask.getSearchWord())
//                        .queryParam("start", 0)
//                        .queryParam("max_results", 10)
//                        .build())
//                .retrieve()
//                .bodyToMono(String.class)
//                .map()
//    }
//}
