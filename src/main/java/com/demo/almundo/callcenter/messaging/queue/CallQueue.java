package com.demo.almundo.callcenter.messaging.queue;

import com.demo.almundo.callcenter.models.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * In this class we will create a Concurrent Linked MessageQueue and
 * submit/retrieve all the call from it.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class CallQueue{

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(CallQueue.class);

    /** Default call MessageQueue to save call message */
    private Queue<Call> concurrentCallQueue;

    /**
     * Default constructor when called creates MessageQueue implementation
     */
    public CallQueue() {
        concurrentCallQueue = new ConcurrentLinkedDeque<>();
    }

    /**
     * All the threads will call this method to insert the
     * Messages in to the Concurrent Linked MessageQueue.
     *
     * @param call to add to the queue
     */
    public boolean add(final Call call){

        return concurrentCallQueue.add(call);
    }

    /**
     * Retrieves and removes the head of this queue, or returns
     * a optional if this queue is empty.
     *
     * @return {@link Optional<Call>} element retrieve from MessageQueue
     */
    public Optional<Call> poll(){

        return Optional.ofNullable(concurrentCallQueue.poll());
    }
}
