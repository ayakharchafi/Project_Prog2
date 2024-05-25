/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

/**
 *
 * @author ayakh
 */
abstract class User extends Person {


    abstract public void cancelMemberShip();

    public User(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nPhone Number: " + phoneNumber + "\nAddress: " + address + "\nId: " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
