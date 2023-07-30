package com.kaplan.kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactService contactService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("demo is starting");
		ContactKaplan contactKaplan = new ContactKaplan();
		contactKaplan.setContactName("baran");
		Map<String, String> abc= new HashMap<>();
		abc.put("abc","def");
		abc.put("asd","dsa");
		contactKaplan.setItemPriceMap(abc);
		contactKaplan.setId(1L);
		contactService.createContact(contactKaplan);
		ContactKaplan contactKaplan2 = new ContactKaplan();
		contactKaplan2.setContactName("baran");
		Map<String, String> abc2= new HashMap<>();
		abc2.put("eee","eee");
		abc2.put("fff","fff");
		contactKaplan2.setItemPriceMap(abc2);
		contactKaplan2.setId(2L);
		contactService.createContact(contactKaplan2);
	}
}
