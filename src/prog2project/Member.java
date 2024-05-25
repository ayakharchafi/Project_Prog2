/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ayakh
 */
public class Member extends Person{

  
    protected String memberShipType;
    protected String paymentType;
    protected double paymentAmount;

    public Member(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.memberShipType = "";
        this.paymentType = "";
        this.paymentAmount = 0.0;
    }

    public Member(String memberShipType, String paymentType, double paymentAmount, String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.memberShipType = memberShipType;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
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

    public String getMemberShipType() {
        return memberShipType;
    }

    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
    }

    public void showMemberDetails() {
        System.out.println("\nMember ID: " + id + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Membership Type: " + memberShipType + "\n"
                + "Payment Type: " + paymentType + "\n"
                + "Payment Amount: $" + paymentAmount);
    }

    public static void writeMembersToFile(ArrayList<Member> members, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Member member : members) {
                writer.write(member.toString() + System.lineSeparator());
            }
            System.out.println("Members have been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static ArrayList<Member> readMembersFromFile(String fileName) {
        ArrayList<Member> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] memberDetails = line.split(","); // Assuming the details are separated by commas
                if (memberDetails.length >= 6) {
                    String name = memberDetails[0];
                    String address = memberDetails[1];
                    String phoneNumber = memberDetails[2];
                    String membershipType = memberDetails[3];
                    String paymentType = memberDetails[4];
                    double paymentAmount = Double.parseDouble(memberDetails[5]);

                    Member member = new Member(membershipType, paymentType, paymentAmount, name, phoneNumber, address);
                    members.add(member);
                } else {
                    System.out.println("Invalid member details in the file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
        return members;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.memberShipType);
        hash = 11 * hash + Objects.hashCode(this.paymentType);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.paymentAmount) ^ (Double.doubleToLongBits(this.paymentAmount) >>> 32));
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
        final Member other = (Member) obj;
        if (Double.doubleToLongBits(this.paymentAmount) != Double.doubleToLongBits(other.paymentAmount)) {
            return false;
        }
        if (!Objects.equals(this.memberShipType, other.memberShipType)) {
            return false;
        }
        return Objects.equals(this.paymentType, other.paymentType);
    }

    
    
}
