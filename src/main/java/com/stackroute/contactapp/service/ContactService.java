package com.stackroute.contactapp.service;

import com.stackroute.contactapp.exception.ContactExistsException;
import com.stackroute.contactapp.model.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact) throws ContactExistsException;
    List<Contact> getAllContacts();
    Contact getAllContactByEmail(String email);


}
