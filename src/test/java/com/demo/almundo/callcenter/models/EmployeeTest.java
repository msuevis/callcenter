package com.demo.almundo.callcenter.models;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test cases fot {@linkplain Employee} entity
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class EmployeeTest {

    /**
     * If no data is provided to the builder, the instantiated amount entity must have all attributes as {@code null}
     *
     * @author Miguel Angel Suevis
     * @date 19/03/2018
     */
    @Test
    public void testBuilderWithoutData() {

        assertThat(Employee.create().build())
                .isNotNull()
                .satisfies(employee -> {
                    assertThat(employee.getIdentification()).isNull();
                    assertThat(employee.getType()).isNull();
                    assertThat(employee.getState()).isNull();
                });

    }


    /**
     * Test that all the given parameters to the builder are set to the created Employee
     *
     * @author Miguel Angel Suevis (miguelangelsuevis@gmail.com)
     * @date 19/03/2018
     */
    @Test
    public void testBuilderSuccess() {

        final Integer id = 10;
        final String accountName = "PayU Colombia S.A.S.";
        final String commercialName = "PayU";

        assertThat(Account.create()
                .withId(id)
                .withAccountName(accountName)
                .withCommercialName(commercialName)
                .build())
                .isNotNull()
                .satisfies(account -> {
                    assertThat(account.getId())
                            .isNotNull()
                            .isEqualByComparingTo(id);
                    assertThat(account.getAccountName())
                            .isNotNull().isNotEmpty().isNotBlank()
                            .isEqualTo(accountName);
                    assertThat(account.getCommercialName())
                            .isNotNull().isNotEmpty().isNotBlank()
                            .isEqualTo(commercialName);
                });
    }
}
