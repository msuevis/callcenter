package com.demo.almundo.callcenter.messaging.producer.impl;

import com.demo.almundo.callcenter.messaging.consumer.EventDispatcher;
import com.demo.almundo.callcenter.messaging.consumer.events.impl.DispatchCallEvent;
import com.demo.almundo.callcenter.messaging.consumer.handlers.impl.DispatcherEventHandler;
import com.demo.almundo.callcenter.messaging.producer.Producer;
import com.demo.almundo.callcenter.messaging.queue.CallQueue;
import com.demo.almundo.callcenter.models.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Handles the call of user and send to messaging system.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class CallProducer implements Producer{


    /**
     * Default class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallProducer.class);

    /** Queue to manager the call message */
    private CallQueue callQueue;

    /** It notifies through an event the placement of messages in the queue for further processing.*/
    private EventDispatcher eventDispatcher;

    @Autowired
    private DispatcherEventHandler dispatcherEventHandler;


    /**
     * constuct of the class {@link CallProducer}
     *
     * @param callQueue to manager the call message
     * @param eventDispatcher to notify event to consumer
     */
    @Autowired
    public CallProducer(final CallQueue callQueue, final EventDispatcher eventDispatcher){

        this.callQueue =  callQueue;
        this.eventDispatcher =  eventDispatcher;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void send(Call call) {

        LOGGER.info("Init to send call to operator ");

        callQueue.add(call);
        eventDispatcher.registerHandler(DispatchCallEvent.class, dispatcherEventHandler);
        eventDispatcher.dispatch(new DispatchCallEvent());

    }


}
