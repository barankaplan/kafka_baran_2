//package com.kaplan.kafka.demo.kafka;
//
//
//import com.kaplan.kafka.demo.ContactUtil;
//import com.kaplan.kafka.demo.kafka.avro.domain.CreateContactEvent;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//public class KafkaNavisionConsumer {
//
//    @Autowired
//    private KafkaTemplate<String, GenericRecord> kafkaTemplate;
//
//
//    @KafkaListener(topics = "create-contact-topic")
//    @Transactional("kafkaTransactionManager")
//    public void receive(ConsumerRecord<String, CreateContactEvent> consumerRecord) {
//
//
//        if (consumerRecord.value().getCommitId().toString().equals("1")) {
//            kafkaTemplate.send("create-contact-topic", consumerRecord.value().getCommitId().toString(), ContactUtil.navisionContactCreateEvent());
//        } else {
//            kafkaTemplate.send("create-contact-topic", consumerRecord.value().getCommitId().toString(), ContactUtil.navisionContactFailedEvent());
//        }
//    }
//
//
//
//}
