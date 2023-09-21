package com.monetize.cbook.service;

import com.monetize.cbook.domain.Contact;

import java.util.List;
import java.util.UUID;

public class ContactServiceImpl implements  ContactService{
  @Override
  public Contact addContact(Contact contact) {
    return null;
  }

  @Override
  public List<Contact> getContacts() {
      System.out.println("We will get contacts from DB");
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
