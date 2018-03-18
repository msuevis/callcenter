package com.demo.almundo.callcenter.messaging.consumer.events.impl;

import com.demo.almundo.callcenter.models.Call;

/**
 *  A {@link DispatchCallEvent} should be dispatched whenever
 *    {@link Call} object has been created in the CallQueue.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class DispatchCallEvent extends AbstractEvent {

    /**
     * default construct to {@link DispatchCallEvent} class
     */
    public DispatchCallEvent(){

    }

}
