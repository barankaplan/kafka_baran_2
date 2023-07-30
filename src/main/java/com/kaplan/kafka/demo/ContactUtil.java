package com.kaplan.kafka.demo;


import com.kaplan.kafka.demo.kafka.avro.domain.ContactAvro;
import com.kaplan.kafka.demo.kafka.avro.domain.CreateContactEvent;
import com.kaplan.kafka.demo.kafka.avro.domain.NavisionContactCreateEvent;

public  class ContactUtil {

    public static CreateContactEvent createContactEvent(ContactKaplan contactKaplan){

        return CreateContactEvent.newBuilder()
                .setCommitId(contactKaplan.getContactName())
                .setContact(createContact(contactKaplan))
                .build();
    }
    public static ContactAvro createContact (ContactKaplan contactKaplan){
        return ContactAvro.newBuilder()
                .setId(contactKaplan.getId())
                .setContactName(contactKaplan.getContactName())
                .build();

    }


    public static NavisionContactCreateEvent navisionContactCreateEvent(){

        return NavisionContactCreateEvent.newBuilder()
                .setCommitId("1")
                .setName("baran")
                .build();
    }

}
