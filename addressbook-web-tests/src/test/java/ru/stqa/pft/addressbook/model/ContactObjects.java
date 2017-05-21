package ru.stqa.pft.addressbook.model;

public class ContactObjects {
    private int id= Integer.MAX_VALUE;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String company;
    private  String addresss;
    private  String home;
    private  String email;
    private  String group;

    public void setId(int id) {
        this.id = id;
    }

    public ContactObjects withId(int id) {
        this.id = id;
        return this;
    }
    public ContactObjects withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactObjects withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactObjects withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactObjects withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactObjects withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactObjects withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactObjects withAddresss(String addresss) {
        this.addresss = addresss;
        return this;
    }

    public ContactObjects withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactObjects withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactObjects withGroup(String group) {
        this.group = group;
        return this;
    }
    public int getId() {
        return id;
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


    @Override
    public String toString() {
        return "ContactObjects{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactObjects that = (ContactObjects) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

}