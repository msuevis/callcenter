package com.demo.almundo.callcenter.messaging.consumer;

import com.demo.almundo.callcenter.messaging.consumer.events.Event;
import com.demo.almundo.callcenter.messaging.consumer.handlers.Handler;
import com.demo.almundo.callcenter.messaging.consumer.routers.DynamicRouter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles the routing of {@link Event} messages to associated handlers.
 * A {@link java.util.HashMap} is used to store the association between events and their respective handlers.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class EventDispatcher implements DynamicRouter<Event>{


    /** save the event and associated handlers */
    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;

    /**
     * default constructor
     */
    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerHandler(final Class<? extends Event> eventType,final  Handler<? extends Event> handler) {

        handlers.put(eventType,handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispatch(final Event event) {

        Handler<Event> handler = (Handler<Event>) handlers.get(event.getClass());
        if (handler != null) {
            handler.dispatchCall(event);
        }
    }
}
