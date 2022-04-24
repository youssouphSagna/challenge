package fr.wedoogift.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class GiftTest {


    @Test
    @DisplayName("Should init Gift with the default period")
    void initWithoutStartDate() {
        Deposit deposit = new Gift(new Amount(15D));

        Assertions.assertEquals(15D, deposit.getAmount().getValue());
        Assertions.assertEquals(LocalDate.now(), deposit.getValidityPeriod().getStartDate());
        Assertions.assertEquals(LocalDate.now().plusDays(Gift.DAYS_LIFESPAN), deposit.getValidityPeriod().getEndDate());
    }

    @Test
    @DisplayName("Should init Gift with the given period")
    void initWithStartDate() {
        LocalDate starDate = LocalDate.now().plusDays(5);

        Deposit deposit = new Gift(new Amount(15D), starDate);

        Assertions.assertEquals(15D, deposit.getAmount().getValue());
        Assertions.assertEquals(starDate, deposit.getValidityPeriod().getStartDate());
        Assertions.assertEquals(starDate.plusDays(Gift.DAYS_LIFESPAN), deposit.getValidityPeriod().getEndDate());
    }

    @Test
    @DisplayName("Should return false if Gift validity period is exceeded")
    void giftInvalid() {
        Deposit deposit = new Gift(new Amount(25D), LocalDate.of(2019, Month.FEBRUARY, 15));

        Assertions.assertFalse(deposit.isValid());
    }

    @Test
    @DisplayName("Should return true if Gift validity period is not exceeded")
    void giftValid() {
        Deposit deposit = new Gift(new Amount(25D));

        Assertions.assertTrue(deposit.isValid());
    }
}
