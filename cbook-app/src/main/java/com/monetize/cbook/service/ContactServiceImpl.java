package com.monetize.cbook.service;

import com.monetize.cbook.domain.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactServiceImpl implements  ContactService{
  private List<Contact> contacts = new ArrayList<>();
  @Override
  public Contact addContact(Contact contact) {
     contacts.add(contact);
     return contact;
  }

  @Override
  public List<Contact> getContacts() {
    return contacts;
  }

  @Override
  public List<Contact> searchContact(String str) {
    return null;
  }

  @Override
  public Contact getContact(UUID id) {
    return null;
  }

  @Override
  public Contact updateContact(Contact contact) {
    return null;
  }

  @Override
  public boolean deleteContact(UUID id) {
    return false;
  }
}
