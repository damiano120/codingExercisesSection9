package BankApplication;

// Możliwość dodania nowego klienta i początkowej kwoty transakcji
// Możliwość dodania transakcji dla klienta oddziału

import java.util.ArrayList;
import java.util.Scanner;

public class BranchBank {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Customer> customers;
    private String name;

    public BranchBank(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
          if (findCustomer(customerName) == null){
              this.customers.add(new Customer(customerName, initialAmount));
              return true;
          }
          System.out.println("Error, customer not find");
          return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            System.out.println("Add transaction");
            return true;
        }
        System.out.println("Error transaction");
        return false;
    }

    private Customer findCustomer(String customerName){
        for (int i=0; i<this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(customerName))
                return this.customers.get(i);
        }
        return null;
    }
}
