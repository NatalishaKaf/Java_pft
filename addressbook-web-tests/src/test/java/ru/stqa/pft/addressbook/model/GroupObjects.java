package ru.stqa.pft.addressbook.model;

public class GroupObjects {
  private int id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupObjects(String name, String header, String footer ) {
    this.id=0;
    this.name = name;
    this.header = header;
    this.footer = footer;

  }

  public void setId(int id) {
    this.id = id;
  }

  public GroupObjects(int id, String name, String header, String footer ) {
    this.id=id;
    this.name = name;
    this.header = header;

    this.footer = footer;

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
  public int getId() {
    return id;
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
