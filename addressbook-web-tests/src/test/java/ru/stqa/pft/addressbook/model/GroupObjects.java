package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name= "group_list")

public class GroupObjects {
    @Id
    @Column(name= "group_id")
    private int id= Integer.MAX_VALUE;

    @Expose
    @Column(name= "group_name")
    private String name;

    @Expose
    @Column(name= "group_header")
    @Type(type= "text")
    private String header;

    @Expose
    @Column(name= "group_footer")
    @Type(type= "text")
    private String footer;

    @ManyToMany(mappedBy = "groups")
    private Set<ContactObjects> contacts =new HashSet<ContactObjects>();

    public Set<ContactObjects> getContacts() {
        return new Contacts (contacts);
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupObjects withId(int id) {
        this.id = id;
        return this;
    }
    public GroupObjects withName(String name) {
        this.name = name;
        return this;
    }

    public GroupObjects withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupObjects withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupObjects withContacts(Set<ContactObjects> contacts) {
        this.contacts = contacts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupObjects that = (GroupObjects) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        return footer != null ? footer.equals(that.footer) : that.footer == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (footer != null ? footer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupObjects{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}

