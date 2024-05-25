/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog2project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ayakh
 */
public class Prog2Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
            Scanner scanner = new Scanner(System.in);
        MembershipSystem system = deserializeMembershipSystem("membershipSystem.ser");
//        if (system == null) {
//            system = new MembershipSystem();
//        }
        int choice;
        do {
            System.out.println("(1) Register a new Member\n"
                    + "(2) Show all Members\n"
                    + "(3) Update a member\n"
                    + "(4) Show Account Balance\n"
                    + "(5) To Exit System");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerNewMember(scanner, system);
                    break;
                case 2:
                    System.out.println("Member List: ");
                   // MembershipSystem deserializedSystem = deserializeMembershipSystem("membershipSystem.ser");
//                    if (deserializedSystem != null) {
//                        deserializedSystem.showAllMembers();
//                    } else {
//                        System.out.println("No members found.");
//                    }
                    Member.readMembersFromFile("members.txt");
                    break;
                case 3:
                    System.out.println("Enter the ID of the member you want to update: ");
                    String id = scanner.next();
                    Member memberToUpdate = system.getMemberById(id);
                    if (memberToUpdate == null) {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.println("What do you want to update?");
                    System.out.println("(1) Phone Number\n"
                            + "(2) Address");
                    System.out.println("Enter your choice: ");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (updateChoice) {
                        case 1:
                            System.out.println("Enter the new phone number: ");
                            String newPhoneNumber = scanner.nextLine();
                            memberToUpdate.setPhoneNumber(newPhoneNumber);
                            System.out.println("Phone number updated successfully.");
                            break;
                        case 2:
                            System.out.println("Enter the new address: ");
                            String newAddress = scanner.nextLine();
                            memberToUpdate.setAddress(newAddress);
                            System.out.println("Address updated successfully.");
                            break;
                        
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 4:
                    system.showAccountBalance();
                    break;
                case 5:
                   // serializeMembershipSystem(system, "membershipSystem.ser");
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void registerNewMember(Scanner scanner, MembershipSystem system) {
        System.out.println("Please enter Member's name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter Member's address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter Member's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter (R) Regular or (P) Premium for Member's membership type: ");
        String memberShipType = scanner.nextLine();
        System.out.println("Please enter payment type (1) Cash or (2) Credit that Member is going to pay membership: ");
        String paymentType = scanner.nextLine();
        System.out.println("Please enter how much the Member paid: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        system.registerMember(name, address, phoneNumber, memberShipType, paymentType, paymentAmount);
        ArrayList<Member> members = system.getMembers();
        Member.writeMembersToFile(members, "members.txt");
    }

//    public static void serializeMembershipSystem(MembershipSystem system, String fileName) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(system);
//            System.out.println("Membership system serialized successfully.");
//        } catch (IOException e) {
//            System.out.println("Error occurred while serializing membership system: " + e.getMessage());
//        }
//    }
//
//    public static MembershipSystem deserializeMembershipSystem(String fileName) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
//            return (MembershipSystem) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error occurred while deserializing membership system: " + e.getMessage());
//            return null;
//        }
//    }

}


