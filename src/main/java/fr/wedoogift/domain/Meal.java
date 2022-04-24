package fr.wedoogift.domain;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Meal extends Deposit {

    public Meal(Amount amount) {
        super(amount, determineValidityPeriod(LocalDate.now()));
    }

    public Meal(Amount amount, LocalDate startDate) {
        super(amount, determineValidityPeriod(startDate));
    }

    private static Period determineValidityPeriod(LocalDate startDate) {
        LocalDate endDate = LocalDate.of(startDate.getYear() + 1, Month.FEBRUARY, 25).with(TemporalAdjusters.lastDayOfMonth());

        return new Period(startDate, endDate);
    }
}
