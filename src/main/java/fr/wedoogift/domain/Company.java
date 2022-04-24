package fr.wedoogift.domain;

import java.util.UUID;

public class Company {

    private final UUID uuid;
    private final Amount balance;
    private String name;

    public Company(String name) {
        uuid = UUID.randomUUID();
        balance = new Amount(0.0);
        this.name = name;
    }


    public void distributeMeal(Employee employee, Amount amount) {
        Deposit deposit = new Meal(amount);
        this.debit(amount);
        employee.addDeposit(deposit);
    }

    public void distributeGift(Employee employee, Amount amount) {
        Deposit deposit = new Gift(amount);
        this.debit(amount);
        employee.addDeposit(deposit);
    }

    public void credit(Amount amount) {
        this.balance.increase(amount);
    }

    private void debit(Amount amount) {
        this.balance.decrease(amount);
    }

    public UUID getUuid() {
        return uuid;
    }

    public Amount getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
