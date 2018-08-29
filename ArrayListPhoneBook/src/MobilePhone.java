package ArrayListPhoneBook;

// Klasa zawiera listę kontaktów
// Klasa zawiera funkcje dodaj kontakt, zaktualizuj kontakt, znajdź kontakt,
// usuń kontakt, wypisz listę kontaktów

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if (findContact(contact.getName()) >=0) {
            System.out.println("Error, this contact is on phone book");
            return false;
        }
        if (findContact(contact.getPhoneNumber()) >=0){
            System.out.println("Error, this number is on phone book");
            return false;
        }
        myContacts.add(contact);
        System.out.println("ArrayListPhoneBook.Contact has been added");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition=findContact(oldContact);
        if (foundPosition<0){
            System.out.println("Error, this contact was not found");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("ArrayListPhoneBook.Contact with name " + newContact.getName() +
                    " already exists.  Update was not successful.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println("ArrayListPhoneBook.Contact has been updated");
        return true;
    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.myContacts.size();i++){
            Contact contact=this.myContacts.get(i);
            if (contact.getName().equals(contactName))
                return i;
            }
        return -1;
    }

    public boolean removeContact(Contact contact){
        int foundPosition=findContact(contact);
        if (foundPosition<0){
            System.out.println("Error, this contact was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println("ArrayListPhoneBook.Contact has been remove");
        return true;
    }

    public void printListOfContacts() {
        System.out.println("ArrayListPhoneBook.Contact list:");
        for (int i=0; i<this.myContacts.size(); i++){
            System.out.println(i+1+" . "+this.myContacts.get(i).getName()+" - "+this.myContacts.get(i).getPhoneNumber());
        }
    }
    public String queryContact(Contact contact) {
        if(findContact(contact) >=0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }

        return null;
    }
}