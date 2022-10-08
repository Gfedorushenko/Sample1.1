package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        if (this.name == null)
            this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (this.surname == null)
            this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (this.age == null) {
            if (0 <= age && age <= 200)
                this.age.of(age);
            else
                throw new IllegalArgumentException("Возраст " + age + " недопустимый");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalArgumentException {
        if (name == null || surname == null)
            throw new IllegalArgumentException("Не хватает обязательных полей");
        return new Person(name, surname, age, address);
    }
}
