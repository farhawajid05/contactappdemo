package com.stackroute.contactapp.controller;

import com.stackroute.contactapp.exception.ContactExistsException;
import com.stackroute.contactapp.model.Contact;
import com.stackroute.contactapp.service.ContactService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    @GetMapping("/greet")
    public String welcome(){
        return "Welcome to Stackroute";
    }
    @Autowired
    private ContactService contactService;
    
    
    @ApiOperation("Retrieves all Contacts")
    @GetMapping("allContacts")
    public List<Contact> getContacts(){
        return contactService.getAllContacts();
    }
    
    @ApiOperation("Takens a contact object as input and add to the db")
    @PostMapping("addContact")
    public ResponseEntity<?> addContact(@RequestBody Contact contact) throws ContactExistsException {
        return new ResponseEntity<>(contactService.addContact(contact), HttpStatus.CREATED);
    }

    @ApiOperation("Taken an email, and returns the contact object for the given email")
    @GetMapping("/contacts/{email}")
    public Contact getContactByEmail(@PathVariable String email){
        return contactService.getAllContactByEmail(email);
    }

    //@PutMapping("/updateContact")
    //@DeleteMapping("/deleteContact")

}
