package com.stackroute.contactapp.service;

import com.stackroute.contactapp.dao.ContactDAO;
import com.stackroute.contactapp.exception.ContactExistsException;
import com.stackroute.contactapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
   private ContactDAO contactDAO;

    @Override
    public Contact addContact(Contact contact) throws ContactExistsException {
        Optional<Contact> contactNew = contactDAO.findById(contact.getContactId());
        if(contactNew.isPresent())
            throw new ContactExistsException();
        else
            return contactDAO.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contactList = contactDAO.findAll();
        if(contactList.size()>0)
            return contactList;
        else
            return null;

    }

    @Override
    public Contact getAllContactByEmail(String email) {
        return contactDAO.findByContactEmail(email).get();
    }
}
