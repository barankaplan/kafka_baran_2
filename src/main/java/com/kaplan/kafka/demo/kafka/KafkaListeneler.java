package com.kaplan.kafka.demo.kafka;


import com.kaplan.kafka.demo.ContactKaplan;
import com.kaplan.kafka.demo.ContactUtil;
import com.kaplan.kafka.demo.ListenerSaver;
import com.kaplan.kafka.demo.ListenerSaverRepository;
import com.kaplan.kafka.demo.kafka.avro.domain.CreateContactEvent;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@KafkaListener(id = "class-level", topics = "create-contact-topic")
public class KafkaListeneler {


    @Autowired
    private KafkaTemplate<String, SpecificRecord> kafkaTemplate2;
    private int i;

    @Autowired
    ListenerSaverRepository listenerSaverRepository;

    @KafkaHandler
    @Transactional("kafkaTransactionManager")
    public void receive(CreateContactEvent consumerRecord) {
        System.out.println("recordisreceived");
        //System.out.println(i);
        //i++;
        if ((consumerRecord).getCommitId().toString().equals("baran")) {
            System.out.println("CreateContactEvent-navisionContactCreateEvent");
            var val=new ListenerSaver();
            val.setContactName(consumerRecord.getCommitId().toString()+"saved by listener");
            listenerSaverRepository.save(val);
            //extracted();
//            CreateContactEvent contactEvent = ContactUtil.createContactEvent(new ContactKaplan());
//
//            ProducerRecord<String, SpecificRecord> producerRecord = new ProducerRecord<>("create-contact-topic",contactEvent);
            //kafkaTemplate2.send(producerRecord );
        } else {
            System.out.println("CreateContactEvent-navisionContactFailedEvent");
//            ProducerRecord<String, SpecificRecord> producerRecord = new ProducerRecord<>("create-contact-topic", ContactUtil.navisionContactCreateEvent());
//
//            kafkaTemplate2.send(producerRecord);
        }

    }


    private static void extracted() {
        throw new RuntimeException();
    }


}
