package com.stackroute.contactapp.dao;

import com.stackroute.contactapp.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactDAO  extends MongoRepository<Contact, String> {

    Optional<Contact> findByContactEmail(String email);


}
