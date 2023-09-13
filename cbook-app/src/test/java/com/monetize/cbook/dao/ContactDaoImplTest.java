package com.monetize.cbook.dao;

import com.monetize.cbook.domain.Contact;
import com.monetize.cbook.util.DbConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class ContactDaoImplTest {

  private ContactDao contactDao;

  @BeforeEach
  void init() {
    contactDao = new ContactDaoImpl();
    deleteAll();
  }

  @Test
  void getContactsTest() {
    List<Contact> contacts = getContacts();
    for (Contact contact : contacts) {
      contactDao.insertContact(contact);
    }
    List<Contact> contactList = contactDao.selectContacts();
    Assertions.assertEquals(3, contactList.size());
  }

  @Test
  void addContact() {
    Contact contact = getContact();
    contactDao.insertContact(contact);
    List<Contact> list = contactDao.selectContacts();
    Assertions.assertEquals(1, list.size());
  }

  private void deleteAll() {
    Connection con = null;
    Statement st = null;
    try {
      con = DbConnectionUtil.getConnection();
      st = con.createStatement();
      st.executeUpdate("delete from contact");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbConnectionUtil.close(st, con);
    }
  }

  Contact getContact() {
    return Contact.builder()
        .id(UUID.randomUUID())
        .firstName("Aruna")
        .lastName("V")
        .email("arun.v@gmail.com")
        .mobile("9876543219")
        .build();
  }

  List<Contact> getContacts() {
    Contact contact1 = Contact.builder()
        .id(UUID.randomUUID())
        .firstName("Aruna")
        .lastName("V")
        .email("arun.v@gmail.com")
        .mobile("9876543219")
        .build();
    Contact contact2 = Contact.builder()
        .id(UUID.randomUUID())
        .firstName("Ramana")
        .lastName("A")
        .email("ramana.a@gmail.com")
        .mobile("9876543217")
        .build();

    Contact contact3 = Contact.builder()
        .id(UUID.randomUUID())
        .firstName("Jayesh")
        .lastName("G")
        .email("jayesh.g@gmail.com")
        .mobile("9876543218")
        .build();
    return List.of(contact3, contact1, contact2);
  }


}
