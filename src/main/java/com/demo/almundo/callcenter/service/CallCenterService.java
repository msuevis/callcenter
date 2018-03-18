package com.demo.almundo.callcenter.service;

import com.demo.almundo.callcenter.models.Call;

/**
 * A {@link CallCenterService} interface offers the necessary operations
 * to interact with user.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public interface CallCenterService {

    /**
     * method that receives the calls from the users.
     *
     * @param call to send to the call center to be attended by an operator
     */
    void send(Call call);
}
