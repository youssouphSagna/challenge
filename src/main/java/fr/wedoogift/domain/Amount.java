package fr.wedoogift.domain;

import java.util.Objects;

public class Amount {

    private Double value;

    public Amount(Double value) {
        if (isNotValid(value)) {
            throw new IllegalArgumentException("Value must be greater than or equal to zero");
        }
        this.value = value;
    }

    private boolean isNotValid(Double value) {
        return Objects.isNull(value) || value < 0;
    }


    public Double getValue() {
        return value;
    }

    public void increase(Amount amount) {
        this.value = this.value + amount.getValue();
    }

    public void decrease(Amount amount) {
        Double result = this.value - amount.getValue();

        if (isNotValid(result)) {
            throw new IllegalStateException("Impossible to have a Amount/Balance lower than zero");
        }

        this.value = result;
    }
}
