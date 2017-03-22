package com.example.about.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String address;

    private final String city;

    private final String region;

    private final String postalCode;

    public Address(Builder builder) {
        this.address = builder.address;
        this.city = builder.city;
        this.region = builder.region;
        this.postalCode = builder.postalCode;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Address() {
        this.address = null;
        this.city = null;
        this.region = null;
        this.postalCode = null;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder {

        private String address;

        private String city;

        private String region;

        private String postalCode;

        public Address build(AddressRepository repository) {
            Address address = new Address(this);

            if (repository != null) {
                repository.save(address);
            }

            return address;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
    }
}
