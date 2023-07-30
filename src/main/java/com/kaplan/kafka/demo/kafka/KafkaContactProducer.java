package com.kaplan.kafka.demo.kafka;


import com.kaplan.kafka.demo.ContactKaplan;
import com.kaplan.kafka.demo.ContactUtil;
import com.kaplan.kafka.demo.kafka.avro.domain.CreateContactEvent;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KafkaContactProducer {

    @Autowired
    private KafkaTemplate<String, SpecificRecord> kafkaTemplate;


    @Transactional("kafkaTransactionManager")
    public void send(ContactKaplan contactKaplan) throws InterruptedException {
        CreateContactEvent contactEvent = ContactUtil.createContactEvent(contactKaplan);
        ProducerRecord<String, SpecificRecord> producerRecord = new ProducerRecord<>("create-contact-topic",contactEvent);
        Thread.sleep(5000);
        kafkaTemplate.send(producerRecord);
        System.out.println("sendingavro!");
        //extracted();



    }

    private static void extracted() {
        throw new RuntimeException();
    }






}