package fr.wedoogift.domain.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class MealTest {

    @Test
    @DisplayName("Should init Meal with the default period")
    void initWithoutStartDate() {
        LocalDate startDate = LocalDate.now();

        Deposit deposit = new Meal(new Amount(15D));

        Period validityPeriod = deposit.getValidityPeriod();

        Assertions.assertEquals(15D, deposit.getAmount().getValue());
        Assertions.assertEquals(startDate, validityPeriod.getStartDate());
        Assertions.assertEquals(startDate.getYear() + 1, validityPeriod.getEndDate().getYear());
        Assertions.assertEquals(Month.FEBRUARY, validityPeriod.getEndDate().getMonth());
        Assertions.assertTrue(validityPeriod.getEndDate().getDayOfMonth() >= 28);
    }

    @Test
    @DisplayName("Should init Meal with the given period")
    void initWithStartDate() {
        LocalDate startDate = LocalDate.of(2023, Month.MARCH, 25);

        Deposit deposit = new Meal(new Amount(50D), startDate);

        Period validityPeriod = deposit.getValidityPeriod();

        Assertions.assertEquals(50D, deposit.getAmount().getValue());
        Assertions.assertEquals(startDate, validityPeriod.getStartDate());
        Assertions.assertEquals(startDate.getYear() + 1, validityPeriod.getEndDate().getYear());
        Assertions.assertEquals(Month.FEBRUARY, validityPeriod.getEndDate().getMonth());
        Assertions.assertTrue(validityPeriod.getEndDate().getDayOfMonth() >= 28);
    }

    @Test
    @DisplayName("Should return false if Meal validity period is exceeded")
    void giftInvalid() {
        Deposit deposit = new Meal(new Amount(25D), LocalDate.of(2019, Month.FEBRUARY, 15));

        Assertions.assertFalse(deposit.isValid());
    }

    @Test
    @DisplayName("Should return true if Meal validity period is not exceeded")
    void giftValid() {
        Deposit deposit = new Meal(new Amount(25D));

        Assertions.assertTrue(deposit.isValid());
    }

}
