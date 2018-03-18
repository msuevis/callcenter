package com.demo.almundo.callcenter.messaging.consumer.routers;

import com.demo.almundo.callcenter.messaging.consumer.events.Event;
import com.demo.almundo.callcenter.messaging.consumer.handlers.Handler;

/**
 *
 * Handles the routing of {@link Event} messages to associated handlers.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface DynamicRouter <E extends Event>{

    /**
     * Links an {@link Event} to a specific {@link Handler}.
     *
     * @param eventType The {@link Event} to be registered
     * @param handler   The {@link Handler} that will be handling the {@link Event}
     */
    public void registerChannel(Class<? extends E> eventType, Handler<? extends E> handler);

    /**
     * Dispatches an {@link Event} depending on it's type.
     *
     * @param event The {@link Event} to be dispatched
     */
    public abstract void dispatch(E event);
}
