package ru.stqa.pft.addressbook.model;

public class GroupObjects {
    private int id= Integer.MAX_VALUE;
    private String name;
    private String header;
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
    public String toString() {
        return "GroupObjects{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupObjects that = (GroupObjects) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}

