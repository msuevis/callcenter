package com.demo.almundo.callcenter.messaging.producer;

import com.demo.almundo.callcenter.models.Call;

/**
 * A {@link Producer} object offers the necessary operations
 * to interact with the messaging system.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface Producer {

    /**
     * send call to messaging system.
     *
     * @param call
     */
    void send(Call call);
}
