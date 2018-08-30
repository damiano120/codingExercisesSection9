package BankApplication;

// Możliwość dodania nowego oddziału
// Możliwość dodania klienta do oddziału z transakcją początkową
// Możliwość dodania transakcji dla istniejącego klienta oddziału
// Pokazanie listy klientów i ich transakcji

import java.util.ArrayList;

public class Bank {

    private ArrayList<BranchBank> branchesBank;
    private String name;

    public Bank(String name) {
        this.name = name;
        this.branchesBank = new ArrayList<BranchBank>();
    }

    public boolean addBranchBank(String nameBranchBank) {
        if (findBranchBank(nameBranchBank) == null) {
            this.branchesBank.add(new BranchBank(nameBranchBank));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nameBranchBank, String customerName, double initialAmount) {
        BranchBank branchBank = findBranchBank(nameBranchBank);
        if (branchBank != null)
            return branchBank.newCustomer(customerName, initialAmount);
        return false;
    }

    public boolean addCustomerTransaction(String nameBranchBank, String customerName, double amount) {
        BranchBank branchBank = findBranchBank(nameBranchBank);
        if (branchBank != null)
            return branchBank.addCustomerTransaction(customerName, amount);
        return false;
    }

    private BranchBank findBranchBank(String nameBranchBank) {
        for (int i = 0; i < this.branchesBank.size(); i++) {
            BranchBank checkedBranchBank = this.branchesBank.get(i);
            if (checkedBranchBank.getName().equals(nameBranchBank))
                return checkedBranchBank;
        }
        return null;
    }

    public boolean listCustomers(String nameBranchBank, boolean showTransactions) {
        BranchBank branchBank = findBranchBank(nameBranchBank);
        if (branchBank != null) {
            System.out.println("Branch " + branchBank.getName());

            ArrayList<Customer> branchCustomers = branchBank.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println(i + ". Customer " + branchCustomer.getName());
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println((j + 1) + ". Transaction " + transactions.get(j));
                    }
                }
            }
            return true;
        } else
            System.out.println("Error");
            return false;
    }
}
