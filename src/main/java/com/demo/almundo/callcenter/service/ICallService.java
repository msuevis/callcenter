package com.demo.almundo.callcenter.service;


import com.demo.almundo.callcenter.models.Call;

import java.util.Optional;

/**
 * A {@link ICallService} interface offers the necessary operations
 * to interact with callQueue.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface ICallService {

    /**
     * retrieve the {@link Call} from call.
     *
     * @return the {@link Call} take from queue
     */
    Optional<Call> getCall();
}
