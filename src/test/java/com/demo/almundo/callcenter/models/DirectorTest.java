package com.demo.almundo.callcenter.models;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases fot {@linkplain Director} entity
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class DirectorTest {

    /**
     * If no data is provided to the builder, the instantiated amount entity must have all attributes as {@code null}
     *
     * @author Miguel Angel Suevis
     * @date 19/03/2018
     */
    @Test
    public void testBuilderWithoutData() {

        assertThat(Director.create().build())
                .isNotNull()
                .satisfies(director -> {
                    assertThat(director.getIdentification()).isNotNull();
                    assertThat(director.getType()).isNull();
                    assertThat(director.getStatus()).isNull();
                });

    }


    /**
     * Test that all the given parameters to the builder are set to the created Director
     *
     * @author Miguel Angel Suevis (miguelangelsuevis@gmail.com)
     * @date 19/03/2018
     */
    @Test
    public void testBuilderSuccess() {


        final EmployeeStatus status =  EmployeeStatus.AVAILABLE;
        final EmployeeType type = EmployeeType.DIRECTOR;

        assertThat(Director.create()
                .withStatus(status)
                .withType(type)
                .build())
                .isNotNull()
                .satisfies(director -> {
                    assertThat(director.getIdentification())
                            .isNotNull();
                    assertThat(director.getType())
                            .isNotNull()
                            .isEqualTo(type);
                    assertThat(director.getStatus())
                            .isNotNull()
                            .isEqualTo(status);
                });
    }
}
