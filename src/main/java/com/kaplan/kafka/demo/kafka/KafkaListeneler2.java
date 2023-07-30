//package com.kaplan.kafka.demo.kafka;
//
//
//import com.kaplan.kafka.demo.ContactUtil;
//import com.kaplan.kafka.demo.kafka.avro.domain.CreateContactEvent;
//import com.kaplan.kafka.demo.kafka.avro.domain.NavisionContactCreateEvent;
//import com.kaplan.kafka.demo.kafka.avro.domain.NavisionContactFailedEvent;
//import org.apache.avro.specific.SpecificRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaHandler;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//@KafkaListener(id = "class-level-contact", topics = "contact-topic")
//public class KafkaListeneler2 {
//
//
//    @Transactional("kafkaTransactionManager")
//    @KafkaHandler
//    public void receive2(NavisionContactCreateEvent consumerRecord) throws Exception {
//
//        System.out.println("NavisionContactCreateEvent is caught!!!");
//
//    }
//
//    @Transactional("kafkaTransactionManager")
//    @KafkaHandler
//    public void receive3(NavisionContactFailedEvent consumerRecord) throws Exception {
//
//        System.out.println("NavisionContactCreateEvent is caught!!!");
//
//    }
//}
