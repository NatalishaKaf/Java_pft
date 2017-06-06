package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupObjects that = (GroupObjects) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!header.equals(that.header)) return false;
        return footer.equals(that.footer);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + header.hashCode();
        result = 31 * result + footer.hashCode();
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

