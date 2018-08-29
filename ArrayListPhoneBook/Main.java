package ArrayListPhoneBook;

import java.util.Scanner;

// Prosty telefon komórkowy z możliwością przechowywania, modyfikowania
// usuwania i wysyłania zapytań o nazwy kontaktów

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone=new MobilePhone("12345");

    public static void main(String[] args) {

        boolean quit = true;
        printInstrutions();
        int choice = 0;

        while (quit) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    quit = false;
                    break;
                case 1:
                    mobilePhone.printListOfContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printInstrutions();
                    break;
            }
        }
    }

    public static void printInstrutions() {
        System.out.println("Press \n" +
                "0 - close \n" +
                "1 - print list of contact \n" +
                "2 - add contact \n" +
                "3 - update contact \n" +
                "4 - remove contact \n" +
                "5 - find contact \n" +
                "6 - display instructions \n");
    }


    private static void addContact() {
        System.out.print("Please enter name: ");
        String name=scanner.nextLine();
        System.out.print("Please enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addContact(newContact)) {
            System.out.println("New contact added");
        } else {
            System.out.println("Error this contact is on the phone book");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("ArrayListPhoneBook.Contact not found.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("ArrayListPhoneBook.Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("ArrayListPhoneBook.Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }
}


