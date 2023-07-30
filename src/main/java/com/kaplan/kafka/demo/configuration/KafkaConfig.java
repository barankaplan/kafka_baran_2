package com.kaplan.kafka.demo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;


@Configuration
@Profile("kafka")
public class KafkaConfig {

//    @Bean
//    public NewTopic transactionTopic() {
//        System.out.println("topic is being created!");
//        return TopicBuilder.name("create-contact-topic")
//                .build();
//    }

//    @Bean
//    public NewTopic logTopicCreated() {
//        return TopicBuilder.name("navision-created-topic")
//                .partitions(3)
//                .replicas(1)
//                .build();
//    }
//    @Bean
//    public NewTopic logTopicFailed() {
//        return TopicBuilder.name("navision-failed-topic")
//                .partitions(3)
//                .replicas(1)
//                .build();
//    }

/*    @Bean
    public NewTopic logTopic() {
        return TopicBuilder.name("log-topic")
                .partitions(3)
                .replicas(2)
                .build();
    }*/

    @Bean
    @Primary
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
