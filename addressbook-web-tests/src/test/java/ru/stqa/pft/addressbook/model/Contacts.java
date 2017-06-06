package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactObjects> {

    private Set<ContactObjects> delegate;

    public Contacts (Contacts contacts){
        this.delegate = new HashSet<ContactObjects>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactObjects>();
    }

    public Contacts(Collection<ContactObjects> contacts) {
        this.delegate =new HashSet<ContactObjects>(contacts);
    }

    @Override
    protected Set<ContactObjects> delegate() {
        return delegate;
    }

    public Contacts withAdded (ContactObjects contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }
    public Contacts withOut (ContactObjects contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
