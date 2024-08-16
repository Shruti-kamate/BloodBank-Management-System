package com.example.Bloodbank.service;

import com.example.Bloodbank.entity.Contact;
import com.example.Bloodbank.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public boolean updateContact(Long id, Contact newContact) {
        if (contactRepository.existsById(id)) {
            newContact.setId(id);
            contactRepository.save(newContact);
            return true;
        }
        return false;
    }

    public Contact deleteContact(Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contactRepository.deleteById(id);
        }
        return contact;
    }

    // Method to add 3 users prior
    public void addPriorContacts() {
        Contact contact1 = new Contact("John Doe", "john@example.com", "Message 1");
        Contact contact2 = new Contact("Alice Smith", "alice@example.com", "Message 2");
        Contact contact3 = new Contact("Bob Johnson", "bob@example.com", "Message 3");

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);
    }
}
