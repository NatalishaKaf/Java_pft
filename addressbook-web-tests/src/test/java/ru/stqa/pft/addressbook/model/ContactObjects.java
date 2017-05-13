package ru.stqa.pft.addressbook.model;

public class ContactObjects {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String addresss;
  private final String home;
  private final String email;
  private final String group;

  public void setId(int id) {
    this.id = id;
  }

  public ContactObjects(String firstname, String middlename, String lastname, String nickname, String title, String company, String addresss,
                        String home, String email, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;

    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.addresss = addresss;
    this.home = home;
    this.email = email;
    this.group = group;
  }

  public ContactObjects(int id,String firstname, String middlename, String lastname, String nickname, String title, String company, String addresss,
                        String home, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.addresss = addresss;
    this.home = home;
    this.email = email;
    this.group = group;
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

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactObjects that = (ContactObjects) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactObjects{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}