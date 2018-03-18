package com.demo.almundo.callcenter.messaging.consumer.handlers.impl;


import com.demo.almundo.callcenter.messaging.consumer.events.impl.DispatchCallEvent;
import com.demo.almundo.callcenter.messaging.consumer.handlers.Handler;
import com.demo.almundo.callcenter.messaging.queue.CallQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Handle the {@link DispatchCallEvent} message.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class DispatcherEventHandler implements Handler<DispatchCallEvent> {

    /**
     * Default class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherEventHandler.class);

    /** callQueue component to retrive call message */
    @Autowired
    private CallQueue callQueue;


    /**
     * {@inheritDoc}
     */
    @Override
    public void dispatch(DispatchCallEvent event) {
        LOGGER.info("Execute dispatch method to event type [{}] ",event.getType());

        LOGGER.info("return information [{}] ",callQueue.poll().isPresent());
    }
}
