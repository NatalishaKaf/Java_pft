package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupObjects>{

    private Set<GroupObjects> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupObjects>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupObjects>();
    }

    @Override
    protected Set<GroupObjects> delegate() {
        return delegate;
    }

    public Groups withAdded (GroupObjects group){
        Groups groups = new Groups (this);
        groups.add(group);
        return groups;
    }
    public Groups withOut (GroupObjects group){
        Groups groups = new Groups (this);
        groups.remove(group);
        return groups;
    }
}
