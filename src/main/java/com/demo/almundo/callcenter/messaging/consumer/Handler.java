package com.demo.almundo.callcenter.messaging.consumer;

/**
 * This class handle different type of {@link Event}.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface Handler<E extends Event>{

    /**
     * this method should handle the behavior associated with
     * the past event as a reference.
     *
     * @param event the {@link Event} to be handled
     */
    void dispatch(E event);
}
