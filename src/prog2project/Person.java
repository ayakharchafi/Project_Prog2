/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;


/**
 *
 * @author ayakh
 */
public abstract class Person {
  protected String name, address, id;
    protected PhoneNumber phoneNumber;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.address = address;
        this.id = generateRandomId();
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberValid() {
        return phoneNumber.isValid();
    }

    public String generateRandomId() {
        Random random = new Random();
        int randomId = 1000000 + random.nextInt(9000000); 
        return String.valueOf(randomId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber tempPhoneNumber = new PhoneNumber(phoneNumber);
        if (tempPhoneNumber.isValid()) {
            this.phoneNumber = tempPhoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number. Please input a valid phone number.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, address, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) &&
               Objects.equals(phoneNumber, person.phoneNumber) &&
               Objects.equals(address, person.address) &&
               Objects.equals(id, person.id);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "PhoneNumber: " + phoneNumber + "\n" +
               "Address: " + address + "\n" +
               "Id: " + id;
    }
}
