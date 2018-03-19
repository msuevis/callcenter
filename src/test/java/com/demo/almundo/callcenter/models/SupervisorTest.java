package com.demo.almundo.callcenter.models;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases fot {@linkplain Supervisor} entity
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class SupervisorTest {

    /**
     * If no data is provided to the builder, the instantiated amount entity must have all attributes as {@code null}
     *
     * @author Miguel Angel Suevis
     * @date 19/03/2018
     */
    @Test
    public void testBuilderWithoutData() {

        assertThat(Supervisor.create().build())
                .isNotNull()
                .satisfies(supervisor -> {
                    assertThat(supervisor.getIdentification()).isNotNull();
                    assertThat(supervisor.getType()).isNull();
                    assertThat(supervisor.getStatus()).isNull();
                });

    }


    /**
     * Test that all the given parameters to the builder are set to the created Supervisor
     *
     * @author Miguel Angel Suevis (miguelangelsuevis@gmail.com)
     * @date 19/03/2018
     */
    @Test
    public void testBuilderSuccess() {


        final EmployeeStatus status =  EmployeeStatus.AVAILABLE;
        final EmployeeType type = EmployeeType.SUPERVISOR;

        assertThat(Supervisor.create()
                .withStatus(status)
                .withType(type)
                .build())
                .isNotNull()
                .satisfies(supervisor -> {
                    assertThat(supervisor.getIdentification())
                            .isNotNull();
                    assertThat(supervisor.getType())
                            .isNotNull()
                            .isEqualTo(type);
                    assertThat(supervisor.getStatus())
                            .isNotNull()
                            .isEqualTo(status);
                });
    }
}

