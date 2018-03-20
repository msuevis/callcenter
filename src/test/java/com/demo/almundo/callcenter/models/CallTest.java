package com.demo.almundo.callcenter.models;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases fot {@linkplain Call} entity
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class CallTest {

    /**
     * If no data is provided to the builder, the instantiated amount entity must have all attributes as {@code null}
     *
     * @author Miguel Angel Suevis
     * @date 19/03/2018
     */
    @Test
    public void testBuilderWithoutData() {

        assertThat(Call.create().build())
                .isNotNull()
                .satisfies(call -> {
                    assertThat(call.getIdentification()).isNotNull();
                    assertThat(call.getMessage()).isNull();
                });

    }


    /**
     * Test that all the given parameters to the builder are set to the created Call
     *
     * @author Miguel Angel Suevis (miguelangelsuevis@gmail.com)
     * @date 19/03/2018
     */
    @Test
    public void testBuilderSuccess() {


        final String message =  "Hellow good morning";

        assertThat(Call.create()
                .withMessage(message)
                .build())
                .isNotNull()
                .satisfies(call -> {
                    assertThat(call.getIdentification())
                            .isNotNull();
                    assertThat(call.getMessage())
                            .isNotNull()
                            .isEqualTo(message);
                });
    }
}
