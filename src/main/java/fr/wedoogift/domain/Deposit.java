package fr.wedoogift.domain;


import java.time.LocalDate;

public abstract class Deposit {
    protected Amount amount;
    protected final Period validityPeriod;

    public Deposit(Amount amount, Period validityPeriod) {
        this.amount = amount;
        this.validityPeriod = validityPeriod;
    }

    public Amount getAmount() {
        return amount;
    }

    public Period getValidityPeriod() {
        return validityPeriod;
    }


    public boolean isValid() {
        return validityPeriod.getEndDate().isAfter(LocalDate.now());
    }
}
