/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Bill {
    protected LocalDate nextDueDate;
    protected double billAmount;
    protected DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Bill(LocalDate nextDueDate, double billAmount) {
        this.nextDueDate = nextDueDate;
        this.billAmount = billAmount;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public void updateNextDueDate() {
        nextDueDate = nextDueDate.plusMonths(1);

        if (nextDueDate.getMonthValue() > 12) {
            nextDueDate = nextDueDate.withMonth(1);
            nextDueDate = nextDueDate.plusYears(1);
        }
    }

    public void payBill(Transaction transaction) {
        // Update the next due date
        updateNextDueDate();
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nextDueDate);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.billAmount) ^ (Double.doubleToLongBits(this.billAmount) >>> 32));
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
        final Bill other = (Bill) obj;
        if (Double.doubleToLongBits(this.billAmount) != Double.doubleToLongBits(other.billAmount)) {
            return false;
        }
        return Objects.equals(this.nextDueDate, other.nextDueDate);
    }

    @Override
    public String toString() {
        return "Bill next due date: " + dateFormatter.format(nextDueDate) + "\nBill Amount: " + billAmount;
    }

    public DateTimeFormatter getDateFormatter() {
        return dateFormatter;
    }

    public void setDateFormatter(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }
    
}
