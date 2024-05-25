/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.util.Objects;

/**
 *
 * @author ayakh
 */
public class PremiumMember extends Member {

    protected double memberShipCost = 22;
    protected String registrationDate, expirationDate;



    public PremiumMember(String registrationDate, String expirationDate, String memberShipType, String paymentType, double paymentAmount, String name, String phoneNumber, String adress) {
        super(memberShipType, paymentType, paymentAmount, name, phoneNumber, adress);
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
    }

    public double getMemberShipCost() {
        return memberShipCost;
    }

    public void setMemberShipCost(double memberShipCost) {
        this.memberShipCost = memberShipCost;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMemberShipType() {
        return memberShipType;
    }

    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
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

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.memberShipCost) ^ (Double.doubleToLongBits(this.memberShipCost) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.registrationDate);
        hash = 71 * hash + Objects.hashCode(this.expirationDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PremiumMember other = (PremiumMember) obj;
        if (Double.doubleToLongBits(this.memberShipCost) != Double.doubleToLongBits(other.memberShipCost)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(this.expirationDate, other.expirationDate);
    }

    @Override
    public String toString() {
        return "Membership cost: $" + memberShipCost + "\n Member " + id + " registration date: " + registrationDate + "\n Member " + id + " expiration date: " + expirationDate;
    }

}
