package com.demo.almundo.callcenter.service.impl;

import com.demo.almundo.callcenter.messaging.producer.Producer;
import com.demo.almundo.callcenter.messaging.producer.impl.CallProducer;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.service.CallCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A {@link CallCenterServiceImpl} object offers the necessary operations
 * to interact with user.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Service
public class CallCenterServiceImpl implements CallCenterService {

    /**
     * Default class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallCenterServiceImpl.class);

    /** the producer class to send call to messaging system */
    @Autowired
    private Producer callProducer;

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(final Call call) {

        LOGGER.info("Request call from user and send call to messaging system");

        callProducer.send(call);
    }
}
