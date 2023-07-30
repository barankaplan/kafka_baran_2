package com.kaplan.kafka.demo;



import com.kaplan.kafka.demo.kafka.ContactRepository;
import com.kaplan.kafka.demo.kafka.KafkaContactProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Slf4j

//@Transactional("transactionManager")
public class ContactService {

    @PersistenceContext
    EntityManager entityManager;

//    @Autowired
//    EntityManagerFactory entityManagerFactory;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private KafkaContactProducer kafkaContactProducer;

    //catch etmeden ilk vers calistir kayit edilmemeli
    //
    @Transactional("transactionManager")
    public ResponseEntity<?> createContact(ContactKaplan contactKaplan) throws InterruptedException {
//        var em=entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction=em.getTransaction() ;

        try {
            //entityTransaction.begin();
            //persistcontext
            //contact.setId(10L);
            //entityManager.persist(contact);
            contactRepository.save(contactKaplan);
            //contactRepository.save(contact);
            //entityTransaction.commit();
            //em.detach();
            kafkaContactProducer.send(contactKaplan);
            //return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (OptimisticLockingFailureException e) {
            throw new ResponseStatusException(HttpStatus.LOCKED, e.getMessage(), e);
        }
//        catch (RuntimeException e) {
//            //System.out.println("rollback!");
//            //entityManager.getTransaction().rollback();
//
//        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}