package com.demo.almundo.callcenter.service.impl;

import com.demo.almundo.callcenter.messaging.queue.CallQueue;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.service.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A {@link CallService} Class offers the necessary operations
 * to interact with callQueue.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class CallService implements ICallService {

    @Autowired
    private CallQueue callQueue;

    @Override
    public Optional<Call> getCall() {
        return callQueue.poll();
    }
}
