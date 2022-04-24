package fr.wedoogift.domain.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    @DisplayName("Should raise a IllegalArgumentException if value is invalid")
    void initAmoutValueInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(-5D));
    }

    @Test
    @DisplayName("Should instantiate a Amount without exception")
    void initAmount() {
        Assertions.assertDoesNotThrow(() -> new Amount(5D));
        Assertions.assertDoesNotThrow(() -> new Amount(0D));
    }

    @Test
    @DisplayName("Should return the value")
    void getValue() {
        Amount amount = new Amount(5D);

        Assertions.assertNotNull(amount);
        Assertions.assertEquals(5D, amount.getValue());
    }


    @Test
    @DisplayName("Should increase the amount")
    void increase() {
        Amount amount = new Amount(10D);

        amount.increase(new Amount(25D));

        Assertions.assertEquals(35D, amount.getValue());
    }


    @Test
    @DisplayName("Should raise a IllegalStateException if the Amount is lower than zéro")
    void decreaseResultNotValid() {
        Amount amount = new Amount(10D);

        Assertions.assertThrows(IllegalStateException.class, () -> amount.decrease(new Amount(25D)));
    }

    @Test
    @DisplayName("Should decrease the amount")
    void decrease() {
        Amount amount = new Amount(10D);

        amount.decrease(new Amount(5D));

        Assertions.assertEquals(5D, amount.getValue());
    }
}
