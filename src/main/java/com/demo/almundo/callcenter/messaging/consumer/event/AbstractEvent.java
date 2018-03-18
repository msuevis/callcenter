package com.demo.almundo.callcenter.messaging.consumer.event;

import com.demo.almundo.callcenter.messaging.consumer.Event;

/**
 *  A {@link AbstractEvent} class is a base class for defining custom behavior.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class AbstractEvent implements Event{

    /**
     * Return the event type as {@link Class} object.
     * in this case is used to create {@link DispatchCallEvent} class.
     *
     * @return the AbstractEvent type as a {@link Class}.
     */
    @Override
    public Class<? extends Event> getType() {
        return null;
    }
}
