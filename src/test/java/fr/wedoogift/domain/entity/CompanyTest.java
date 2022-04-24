package fr.wedoogift.domain.entity;

import fr.wedoogift.domain.valueobject.Amount;
import fr.wedoogift.domain.valueobject.Deposit;
import fr.wedoogift.domain.valueobject.Gift;
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
    void distributeDeposit() {
        Company company = new Company("Apple");
        company.credit(new Amount(500D));

        Deposit deposit = new Gift(new Amount(100D));

        Employee employee = new Employee();

        company.distributeMeal(employee, deposit.getAmount());
    }
}
