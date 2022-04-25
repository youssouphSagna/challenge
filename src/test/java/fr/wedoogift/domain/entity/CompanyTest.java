package fr.wedoogift.domain.entity;

import fr.wedoogift.domain.valueobject.Amount;
import fr.wedoogift.domain.valueobject.Deposit;
import fr.wedoogift.domain.valueobject.Gift;
import fr.wedoogift.domain.valueobject.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyTest {

    @Test
    @DisplayName("Should init company uuid and balance")
    void initId() {
        Company company = new Company("Apple");

        Assertions.assertNotNull(company.getUuid());
        Assertions.assertNotNull(company.getBalance());
        Assertions.assertEquals("Apple", company.getName());
    }

    @Test
    @DisplayName("Should credit company balance")
    void credit() {
        Company company = new Company("Tesla");

        company.credit(new Amount(200D));

        Assertions.assertEquals(200D, company.getBalance().getValue());
    }


    @Test
    @DisplayName("Should distribute Gift deposit to employee")
    void distributeGift() {
        Company company = new Company("Apple");
        company.credit(new Amount(500D));

        Deposit deposit = new Gift(new Amount(100D));

        Employee employee = new Employee();

        company.distributeGift(employee, deposit.getAmount());

        Assertions.assertEquals(100D , employee.calculateBalance());
        Assertions.assertEquals(400D , company.getBalance().getValue());
    }



    @Test
    @DisplayName("Should distribute Meal deposit to employee")
    void distributeMeal() {
        Company company = new Company("AWS");
        company.credit(new Amount(1000D));

        Deposit deposit = new Meal(new Amount(200D));

        Employee employee = new Employee();

        company.distributeMeal(employee, deposit.getAmount());

        Assertions.assertEquals(200D , employee.calculateBalance());
        Assertions.assertEquals(800D , company.getBalance().getValue());
    }
}
