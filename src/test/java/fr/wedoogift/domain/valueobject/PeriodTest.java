package fr.wedoogift.domain.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PeriodTest {

    @Test
    @DisplayName("Should raise a IllegalArgumentException if startDate is null")
    void initPeriodStartDateNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(null, LocalDate.now()));
    }

    @Test
    @DisplayName("Should raise a IllegalArgumentException if endDate is null")
    void initPeriodEndDateNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(LocalDate.now(), null));
    }

    @Test
    @DisplayName("Should raise a IllegalArgumentException if startDate is after endDate")
    void initPeriodStartDateAfterEndDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(LocalDate.now().plusDays(2), LocalDate.now()));
    }

    @Test
    @DisplayName("Should init Period witout Exception")
    void initPeriod() {
        Period period = new Period(LocalDate.now(), LocalDate.now().plusDays(2));

        Assertions.assertEquals(LocalDate.now(), period.getStartDate());
        Assertions.assertEquals(LocalDate.now().plusDays(2), period.getEndDate());
    }
}
