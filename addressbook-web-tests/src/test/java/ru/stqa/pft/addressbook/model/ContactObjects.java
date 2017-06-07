package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import org.openqa.selenium.By;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name= "addressbook")

public class ContactObjects {
    @Id
    @Column(name= "id")
    private int id;
    @Column(name= "firstname")
    private  String firstname;
    @Transient
    private  String middlename;
    @Column(name= "lastname")
    private  String lastname;
    @Transient
    private  String nickname;
    @Transient
    private  String title;
    @Transient
    private  String company;
    @Transient
    private  String address;
    @Transient
    private  String home;
    @Transient
    private  String email;
    @Transient
    private  String group;
    @Column(name= "home")
    @Type(type= "text")
    private  String homePhone;
    @Column(name= "mobile")
    @Type(type= "text")
    private  String mobilPhone;
    @Column(name= "work")
    @Type(type= "text")
    private  String workPhone;
    @Transient
    private  String phones;
    @Column(name= "photo")
    @Type(type= "text")
    private String photo;


    public File getPhoto() {
        return new File (photo);
    }

    public ContactObjects withPhoto(File photo) {
        this.photo = photo.getPath();
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