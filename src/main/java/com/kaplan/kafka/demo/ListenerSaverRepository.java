package com.kaplan.kafka.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerSaverRepository extends JpaRepository<ListenerSaver, Long> {
}