package com.monetize.cbook.dao;

import com.monetize.cbook.domain.Contact;
import com.monetize.cbook.util.DbConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDaoImpl implements ContactDao {
  private static final String GET_CONTACTS = "select id,first_name,last_name,mobile,email,deleted from contact where deleted=false";
  private static final String ADD_CONTACT = "insert into contact(id,first_name,last_name,email,mobile) values(?,?,?,?,?)";

  public Contact insertContact(Contact contact) {
    Connection con = null;
    PreparedStatement pst = null;
    try {
      con = DbConnectionUtil.getConnection();
      pst = con.prepareStatement(ADD_CONTACT);
      pst.setObject(1,contact.getId());
      pst.setString(2,contact.getFirstName());
      pst.setString(3,contact.getLastName());
      pst.setString(4,contact.getEmail());
      pst.setString(5,contact.getMobile());
      int res= pst.executeUpdate();
      if(res!=0){
        System.out.println("Contact is added with id :"+contact.getId());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      DbConnectionUtil.close(pst,con);
    }
    return contact;
  }

  public List<Contact> selectContacts() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Contact> contacts = new ArrayList<>();
    try {
      con = DbConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery(GET_CONTACTS);
      while (rs.next()) {
        Contact contact = covertResSetToContact(rs);
        contacts.add(contact);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbConnectionUtil.close(rs, st, con);
    }
    return contacts;
  }

  public List<Contact> searchContact(String str) {
    return null;
  }

  public Contact selectContact(UUID id) {
    return null;
  }

  public Contact updateContact(Contact contact) {
    return null;
  }

  public boolean deleteContact(UUID id) {
    return false;
  }

  public boolean isContactExists(String mobile) {
    return false;
  }

  private static Contact covertResSetToContact(ResultSet rs) throws SQLException {
    UUID id = UUID.fromString(rs.getString("id"));
    String firstName = rs.getString("first_name");
    String lastName = rs.getString("last_name");
    String mobile = rs.getString("mobile");
    String email = rs.getString("email");
    boolean deleted = rs.getBoolean("deleted");
    return Contact.builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .mobile(mobile)
        .deleted(deleted)
        .build();
  }
}
