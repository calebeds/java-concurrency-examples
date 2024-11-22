package me.calebeoliveira.streams;

import java.io.Serializable;

public class Person implements Serializable {
    private static final Long serialVersionUID = 1L;

    private int personId;

    public Person(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
