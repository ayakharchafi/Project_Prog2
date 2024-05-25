/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction extends Person {
    protected int transactionId = 1;
    protected String typePayment;
    protected double amount;
    protected String transactionDate;

    public Transaction(String typePayment, double amount, String transactionDate, String name, String phoneNumber, String adress) {
        super(name, phoneNumber, adress);
        this.typePayment = typePayment;
        this.amount = amount;
        this.transactionDate = transactionDate;
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
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
        hash = 43 * hash + Objects.hashCode(this.transactionId);
        hash = 43 * hash + Objects.hashCode(this.typePayment);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.transactionDate);
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
        final Transaction other = (Transaction) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (!Objects.equals(this.transactionId, other.transactionId)) {
            return false;
        }
        if (!Objects.equals(this.typePayment, other.typePayment)) {
            return false;
        }
        return Objects.equals(this.transactionDate, other.transactionDate);
    }

    @Override
    public String toString() {
        return "Member id: " + id + "\nTransactionId: " + transactionId + "\nTypePayment: " + typePayment + "\namount: " + amount + "\ntransactionDate: " + transactionDate;
    }

    public void payBill(Bill bill) {
        bill.payBill(this);
    }

    private void updateBillNextDueDate(Bill bill) {
        LocalDate currentDueDate = bill.getNextDueDate();
        LocalDate updatedDueDate = currentDueDate.plusMonths(1);

        // LocalDate automatically handles year changes, so no need to manually check for month > 12
        bill.setNextDueDate(updatedDueDate);
    }
}
