package fr.wedoogift.domain.entity;

import fr.wedoogift.domain.valueobject.Amount;
import fr.wedoogift.domain.valueobject.Gift;
import fr.wedoogift.domain.valueobject.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class EmployeeTest {

    @Test
    @DisplayName("Should init employee uuid and list of deposits")
    void initId() {
        Employee employee = new Employee();

        Assertions.assertNotNull(employee.getUuid());
        Assertions.assertEquals(0.0, employee.calculateBalance());
    }


    @Test
    @DisplayName("Should add deposit to employee balance")
    void addDeposit() {
        Employee employee = new Employee();

        employee.addDeposit(new Gift(new Amount(50D)));
        employee.addDeposit(new Meal(new Amount(100D)));

        Assertions.assertEquals(150D, employee.calculateBalance());
    }

    @Test
    @DisplayName("Should raise a IllegalArgumentException if deposit to add is null")
    void addDepositNull() {
        Employee employee = new Employee();
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.addDeposit(null));
    }

    @Test
    @DisplayName("Should return employee balance")
    void caculateBalance() {
        Employee employee = new Employee();

        employee.addDeposit(new Meal(new Amount(100D)));
        employee.addDeposit(new Gift(new Amount(25D)));

        employee.addDeposit(new Meal(new Amount(50D), LocalDate.of(2019, Month.FEBRUARY, 15)));
        employee.addDeposit(new Gift(new Amount(80D), LocalDate.of(2018, Month.DECEMBER, 15)));


        Assertions.assertEquals(125, employee.calculateBalance());
    }
}
