package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address.length() > 0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder newChildBuilder() throws IllegalArgumentException {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAge(15);
        child.setAddress(address);
        return child;
    }

    public OptionalInt getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge())
            age.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        return name;
    }

}