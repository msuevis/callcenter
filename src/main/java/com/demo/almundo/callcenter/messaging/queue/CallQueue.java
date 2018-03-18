package com.demo.almundo.callcenter.messaging.queue;

import com.demo.almundo.callcenter.models.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * In this class we will create a Concurrent Linked Queue and
 * submit/retrieve all the call from it.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class CallQueue {

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(CallQueue.class);

    /** Default call Queue to save call message */
    private Queue<Call> concurrentCallQueue;

    /**
     * Default constructor when called creates Queue implementation
     */
    public CallQueue(){
        concurrentCallQueue = new ConcurrentLinkedDeque<>();
    }


}
