//package com.kaplan.kafka.demo.kafka;
//
//
//import com.kaplan.kafka.demo.Contact;
//import com.kaplan.kafka.demo.kafka.avro.domain.NavisionContactCreateEvent;
//import com.kaplan.kafka.demo.kafka.avro.domain.NavisionContactFailedEvent;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//import java.util.concurrent.CountDownLatch;
//
//@Component
//@Slf4j
//public class KafkaContactConsumer {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    private String payload;
//
//    //all 3 event via 1 topic ausgesstrahlt
//
//
//    @KafkaListener(topics = {"create-contact-topic"})
//    @Transactional("kafkaTransactionManager")
//    public void receive(ConsumerRecord<String, GenericRecord> consumerRecord) throws Exception {
//        payload = consumerRecord.toString();
//        latch.countDown();
//
//        if (consumerRecord.value() instanceof NavisionContactCreateEvent) {
//            System.out.println("Contact object will be persisted");
//            Thread.sleep(15000);
//        }
//        else{
//            delete(consumerRecord);
//        }
//
//    }
////more listener no need to do generic record
//    @Transactional("transactionManager")
//    public void delete(ConsumerRecord<String, GenericRecord> consumerRecord) throws InterruptedException {
//        if (consumerRecord.value() instanceof NavisionContactFailedEvent) {
//            System.out.println("NavisionContactFailedEvent received");
//            var val= ((NavisionContactFailedEvent) consumerRecord.value()).getContact().getId();
//            System.out.println("and id is "+val);
//            System.out.println("it will be deleted!");
//            Thread.sleep(15000);
//            Optional<Contact> contact=contactRepository.findById(val);
//            if (contact.isPresent()){
//                contactRepository.delete(contact.get());
//            }
//        }
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    public void resetLatch() {
//        latch = new CountDownLatch(1);
//    }
//
//    public String getPayload() {
//        return payload;
//    }
//}
