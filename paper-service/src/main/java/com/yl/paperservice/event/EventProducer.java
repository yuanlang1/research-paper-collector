//package com.yl.paperservice.event;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author yl
// * @date 2025-11-07 16:58
// */
//@Component
//public class EventProducer {
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    public void fireEvent(String topic, String message){
//        kafkaTemplate.send(topic, message);
//    }
//}
