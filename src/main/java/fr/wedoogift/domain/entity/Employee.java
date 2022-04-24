package fr.wedoogift.domain.entity;

import fr.wedoogift.domain.valueobject.Amount;
import fr.wedoogift.domain.valueobject.Deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee {

    private final UUID uuid;
    private List<Deposit> deposits = new ArrayList<>();

    public Employee() {
        uuid = UUID.randomUUID();
    }

    public void addDeposit(Deposit deposit) {
        if (deposit == null) {
            throw new IllegalArgumentException("");
        }
        deposits.add(deposit);
    }

    public Double calculateBalance() {
        Double balance = 0.0;
        balance = deposits
                        .stream()
                            .filter(Deposit::isValid)
                            .map(Deposit::getAmount)
                            .map(Amount::getValue)
                            .reduce(balance, Double::sum);
        return balance;
    }

    public UUID getUuid() {
        return uuid;
    }
}
