package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.openqa.selenium.By;

import java.io.File;

public class ContactObjects {
    private int id= Integer.MAX_VALUE;
    @Expose
    private  String firstname;
    private  String middlename;
    @Expose
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String company;
    private  String address;
    private  String home;
    private  String email;
    private  String group;
    private  String homePhone;
    private  String mobilPhone;
    private  String workPhone;
    @Expose
    private  String phones;
    private  File photo;


    public File getPhoto() {
        return photo;
    }

    public ContactObjects withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


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

    public ContactObjects withAddress(String address) {
        this.address = address;
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
    public ContactObjects withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public ContactObjects withMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
        return this;
    }
    public ContactObjects withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
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

    public String getAddress() {
        return address;
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

    public String getHomePhone() {
        return homePhone;
    }
    public String getMobilPhone() {
        return mobilPhone;
    }
    public String getWorkPhone() {
        return workPhone;
    }

    public String getPhones() {
        return phones;
    }

    public ContactObjects withPhones(String phones) {
        this.phones = phones;
        return this;
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

}