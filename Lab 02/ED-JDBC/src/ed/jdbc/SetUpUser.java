package ed.jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class SetUpUser {

    public static void main(String[] args) {
        MyDB mydb = new MyDB();

//        System.out.println("Welcome to the database");
//        while (true) {
//            System.out.println("1. Check current record\n" +
//                                "2. Update a user\n" +
//                                "3. Exit");
//            Scanner myObj = new Scanner(System.in);
//            int userOption = Integer.parseInt(myObj.nextLine());
//
//            if (userOption == 1) {
//                Scanner myObj2 = new Scanner(System.in);
//                System.out.println("Enter User ID");
//                String userID = myObj2.nextLine();
//                Myuser user = mydb.getRecord(userID);
//                System.out.println("Name: " + user.getName() + "\n" +
//                                    "Password: " + user.getPassword() + "\n" +
//                                    "Email: " + user.getEmail() + "\n" +
//                                    "Phone: " + user.getPhone() + "\n" +
//                                    "Address: " + user.getAddress() + "\n" +
//                                    "SecQn: " + user.getSecQn() + "\n" +
//                                    "SecAns: " + user.getSecAns() + "\n"
//                                    );
//
//            } else if (userOption == 2) {
//                Scanner s = new Scanner(System.in);
//
//                System.out.println("Enter UserID to Update");
//                String userID = s.nextLine();
//
//                System.out.println("Name: ");
//                String name = s.nextLine();
//
//                System.out.println("Password: ");
//                String password = s.nextLine();
//
//                System.out.println("Email: ");
//                String email = s.nextLine();
//
//                System.out.println("Phone: ");
//                String phone = s.nextLine();
//
//                System.out.println("Address: ");
//                String address = s.nextLine();
//
//                System.out.println("Secqn:");
//                String secqn = s.nextLine();
//
//                System.out.println("Secans:");
//                String secans = s.nextLine();
//
//                Myuser updatedUser = new Myuser(userID, name, password, email, phone, address, secqn, secans);
//                mydb.updateRecord(updatedUser);
//            } else if (userOption == 3) {
//                System.exit(1);
//            } else {
//                System.out.println("Invalid Selection");
//            }
//        }



//        Myuser newUser = new Myuser("000001", "Jonathan",
//                "pass", "my email", "12345",
//                "Swinburne", "Helloo","Byee");
//        mydb.updateRecord(newUser);

        mydb.dropMyuserTable();
        mydb.createMyuserTable();
        ArrayList<Myuser> aList = prepareMyuserData();
        mydb.addRecords(aList);
    }

    public static ArrayList<Myuser> prepareMyuserData() { ArrayList<Myuser> myList = new ArrayList<Myuser>();
        Myuser myuser1 = new Myuser("000001", "Peter Smith", "123456", "psmith@swin.edu.au", "9876543210", "Swinburne EN510f", "What is my name?", "Peter");
        Myuser myuser2 = new Myuser("000002", "James T. Kirk", "234567", "jkirk@swin.edu.au", "8765432109", "Swinburne EN511a", "What is my name?", "James");
        Myuser myuser3 = new Myuser("000003", "Sheldon Cooper", "345678", "scooper@swin.edu.au", "7654321098", "Swinburne EN512a", "What is my last name?", "Cooper");
        Myuser myuser4 = new Myuser("000004", "Clark Kent", "456789", "ckent@swin.edu.au", "6543210987", "Swinburne EN513a", "What is my last name?", "Kent");
        Myuser myuser5 = new Myuser("000005", "Harry Potter", "567890", "hpotter@swin.edu.au", "6543210987", "Swinburne EN514a", "What is my last name?", "Potter");
        myList.add(myuser1); myList.add(myuser2); myList.add(myuser3); myList.add(myuser4); myList.add(myuser5);
        return myList;
    }
}
