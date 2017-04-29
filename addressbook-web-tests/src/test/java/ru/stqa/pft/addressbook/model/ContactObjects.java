package ru.stqa.pft.addressbook.model;

public class ContactObjects {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String addresss;
  private final String home;
  private final String email;

  public ContactObjects(String firstname, String middlename, String lastname, String nickname, String title, String company, String addresss, String home, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.addresss = addresss;
    this.home = home;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddresss() {
    return addresss;
  }

  public String getHome() {
    return home;
  }

  public String getEmail() {
    return email;
  }
}