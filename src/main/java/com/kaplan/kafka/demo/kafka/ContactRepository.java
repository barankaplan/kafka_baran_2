package com.kaplan.kafka.demo.kafka;

import com.kaplan.kafka.demo.ContactKaplan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactKaplan, Long> {

}