package fr.wedoogift.domain;

import java.time.LocalDate;

public class Gift extends Deposit {

    public static final int DAYS_LIFESPAN = 365;

    public Gift(Amount amount) {
        super(amount, new Period(LocalDate.now(), LocalDate.now().plusDays(DAYS_LIFESPAN)));
    }

    public Gift(Amount amount, LocalDate starDate) {
        super(amount, new Period(starDate, starDate.plusDays(DAYS_LIFESPAN)));
    }
}
