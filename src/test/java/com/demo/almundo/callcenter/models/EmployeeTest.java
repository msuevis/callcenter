package com.demo.almundo.callcenter.models;


import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
                    assertThat(employee.getIdentification()).isNotNull();
                    assertThat(employee.getType()).isNull();
                    assertThat(employee.getStatus()).isNull();
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


        final EmployeeStatus status =  EmployeeStatus.AVAILABLE;
        final EmployeeType type = EmployeeType.OPERATOR;

        assertThat(Employee.create()
                .withStatus(status)
                .withType(type)
                .build())
                .isNotNull()
                .satisfies(employee -> {
                    assertThat(employee.getIdentification())
                            .isNotNull();
                    assertThat(employee.getType())
                            .isNotNull()
                            .isEqualTo(type);
                    assertThat(employee.getStatus())
                            .isNotNull()
                            .isEqualTo(status);
                });
    }
}
