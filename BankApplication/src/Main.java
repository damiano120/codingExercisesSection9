package BankApplication;

// Prosta aplikacja bankowa posiada 3 klasy: Bank, oddział, klient.
// Klasa bank posiada listę oddziałów
// Klasa oddział posiada listę wszystkich klientów
// Klasa klient posiada listę transakcji

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("ING");

        bank.addBranchBank("Bydgoszcz");
        bank.addBranchBank("Warszawa");
        bank.addBranchBank("Wrocław");

        bank.addCustomer("Bydgoszcz", "Tim", 201.45);
        bank.addCustomer("Bydgoszcz", "Paul", 56.22);
        bank.addCustomer("Bydgoszcz", "Tom", 112.77);
        bank.addCustomer("Warszawa", "Ted", 965.44);
        bank.addCustomer("Warszawa", "Mary", 45.88);
        bank.addCustomer("Wrocław", "Donald", 121544.12);

        bank.addCustomerTransaction("Warszawa", "Ted", 54.38);
        bank.addCustomerTransaction("Warszawa", "Ted", 546.46);
        bank.addCustomerTransaction("Warszawa", "Mary", 258.65);

        bank.listCustomers("Bydgoszcz", false);
        System.out.println();
        bank.listCustomers("Warszawa", true);

    }
}
