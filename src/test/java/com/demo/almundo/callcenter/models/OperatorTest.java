package com.demo.almundo.callcenter.models;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases fot {@linkplain Operator} entity
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class OperatorTest {

    /**
     * If no data is provided to the builder, the instantiated amount entity must have all attributes as {@code null}
     *
     * @author Miguel Angel Suevis
     * @date 19/03/2018
     */
    @Test
    public void testBuilderWithoutData() {

        assertThat(Operator.create().build())
                .isNotNull()
                .satisfies(operator -> {
                    assertThat(operator.getIdentification()).isNotNull();
                    assertThat(operator.getType()).isNull();
                    assertThat(operator.getStatus()).isNull();
                });

    }


    /**
     * Test that all the given parameters to the builder are set to the created Operator
     *
     * @author Miguel Angel Suevis (miguelangelsuevis@gmail.com)
     * @date 19/03/2018
     */
    @Test
    public void testBuilderSuccess() {


        final EmployeeStatus status =  EmployeeStatus.AVAILABLE;
        final EmployeeType type = EmployeeType.OPERATOR;

        assertThat(Operator.create()
                .withStatus(status)
                .withType(type)
                .build())
                .isNotNull()
                .satisfies(operator -> {
                    assertThat(operator.getIdentification())
                            .isNotNull();
                    assertThat(operator.getType())
                            .isNotNull()
                            .isEqualTo(type);
                    assertThat(operator.getStatus())
                            .isNotNull()
                            .isEqualTo(status);
                });
    }
}
