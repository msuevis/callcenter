package com.demo.almundo.callcenter.messaging.consumer;

/**
 *  A {@link Event} object is a specific event a asocciated a Handler.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface Event {

    /**
     * Return the message type as a {@link Class}. this type is
     * used to handle event by type.
     *
     * @return the message type as a {@link Class}
     */
    Class<? extends Event> getType();
}
