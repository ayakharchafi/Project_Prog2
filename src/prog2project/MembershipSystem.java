/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.util.ArrayList;
import java.util.Objects;
import static prog2project.Prog2Project.serializeMembershipSystem;

/**
 *
 * @author ayakh
 */
public class MembershipSystem {
    protected ArrayList<Member> members;
    protected double cashAccountBalance,creditAccountBalance;

    public MembershipSystem() {
        this.members = new ArrayList<>();
        this.cashAccountBalance = 0.0;
        this.creditAccountBalance = 0.0;
    }

    public MembershipSystem(ArrayList<Member> members, double cashAccountBalance, double creditAccountBalance) {
        this.members = members;
        this.cashAccountBalance = cashAccountBalance;
        this.creditAccountBalance = creditAccountBalance;
    }
        public Member getMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null; 
    }

 public void registerMember(String name, String address, String phoneNumber, String membershipType, String paymentType, double paymentAmount) {
    Member member = new Member(membershipType, paymentType, paymentAmount, name, phoneNumber, address);
    members.add(member);
    Member.writeMembersToFile(members, "members.txt"); // Write members to file
    serializeMembershipSystem(this, "membershipSystem.ser"); // Serialize the MembershipSystem object
    if (paymentType.equals("2")) {
        creditAccountBalance += paymentAmount;
    } else if (paymentType.equals("1")) {
        cashAccountBalance += paymentAmount;
    }
    System.out.println("New Member added: Member ID: " + member.getId());
}
   public void showAllMembers() {
    ArrayList<Member> membersFromFile = Member.readMembersFromFile("members.txt");
    for (Member member : membersFromFile) {
        member.showMemberDetails();
        System.out.println();
    }
}
    public void showAccountBalance(){
        System.out.println("Cash Account Balance: $"+cashAccountBalance);
        System.out.println("Credit Card Account Balance: $"+creditAccountBalance);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public double getCashAccountBalance() {
        return cashAccountBalance;
    }

    public void setCashAccountBalance(double cashAccountBalance) {
        this.cashAccountBalance = cashAccountBalance;
    }

    public double getCreditAccountBalance() {
        return creditAccountBalance;
    }

    public void setCreditAccountBalance(double creditAccountBalance) {
        this.creditAccountBalance = creditAccountBalance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.members);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cashAccountBalance) ^ (Double.doubleToLongBits(this.cashAccountBalance) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.creditAccountBalance) ^ (Double.doubleToLongBits(this.creditAccountBalance) >>> 32));
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
        final MembershipSystem other = (MembershipSystem) obj;
        if (Double.doubleToLongBits(this.cashAccountBalance) != Double.doubleToLongBits(other.cashAccountBalance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.creditAccountBalance) != Double.doubleToLongBits(other.creditAccountBalance)) {
            return false;
        }
        return Objects.equals(this.members, other.members);
    }
    
}
