package com.example.about.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String first;

    private final String middle;

    private final String last;

    @OneToOne
    private final Address address;

    private final String email;

    @OneToMany
    private final List<Link> links;

    @OneToMany
    private final List<Company> employment;

    @OneToMany
    private final List<University> education;

    public Person(Builder builder) {
        this.first = builder.first;
        this.middle = builder.middle;
        this.last = builder.last;
        this.address = builder.address;
        this.email = builder.email;
        this.links = builder.links;
        this.employment = builder.employment;
        this.education = builder.education;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Person() {
        this.first = null;
        this.middle = null;
        this.last = null;
        this.address = null;
        this.email = null;
        this.links = null;
        this.employment = null;
        this.education = null;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public List<Link> getLinks() {
        if (links == null) {
            return new ArrayList<>();
        }
        return links;
    }

    public List<Company> getEmployment() {
        if (employment == null) {
            return new ArrayList<>();
        }
        return employment;
    }

    public List<University> getEducation() {
        if (education == null) {
            new ArrayList<>();
        }
        return education;
    }

    public static class Builder {

        private String first;

        private String middle;

        private String last;

        private Address address;

        private String homePhone;

        private String mobilePhone;

        private String email;

        private List<Link> links;

        private List<Company> employment;

        private List<University> education;

        public Person build(PersonRepository repository) {
            Person person = new Person(this);

            if (repository != null) {
                repository.save(person);
            }

            return person;
        }

        public Builder first(String first) {
            this.first = first;
            return this;
        }

        public Builder middle(String middle) {
            this.middle = middle;
            return this;
        }

        public Builder last(String last) {
            this.last = last;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public Builder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder links(List<Link> links) {
            this.links = links;
            return this;
        }

        public Builder employment(List<Company> employment) {
            this.employment = employment;
            return this;
        }

        public Builder education(List<University> education) {
            this.education = education;
            return this;
        }
    }
}
