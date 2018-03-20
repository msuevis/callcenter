package com.demo.almundo.callcenter.service.impl;

import com.demo.almundo.callcenter.messaging.producer.Producer;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.service.ICallService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CallCenterServiceImplIntegrationTest {

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(CallCenterServiceImplIntegrationTest.class);

    /** producer service reference */
    @Qualifier("callProducer")
    @Autowired
    private Producer producer;

    /** call service reference */
    @Autowired
    private ICallService callService;

    /** Maximun Call duration time */
    private static int MAX_CALL_TIME = 10;

    /**Number of instance of opeator*/
    @Value("${dispatcher.numConcurrenCall}")
    private int numConcurrenCall;


    /**
     * aswer the same number of calls that the service supports.
     *
     * the test validate if the queue of calls is empty.
     *
     * @throws Exception
     */
    @Test
    public void aswerEqualsNumbersCallByEqualsNumeberOfEmpoyee() throws Exception{

        Stream.generate(Call::create)
                .limit(numConcurrenCall)
                .forEach(call -> producer.send(call.build()));

        waitForResponse();

        validateIfProcessAllCalls();
    }


    /**
     * aswer more number of calls that the service supports.
     *
     * the test validate if the queue of calls is empty.
     *
     * @throws Exception
     */
    @Test
    public void aswerGreatherNumbersCallByLessNumeberOfEmpoyee() throws Exception{

        Stream.generate(Call::create)
                .limit(numConcurrenCall+5)
                .forEach(call -> producer.send(call.build()));

        waitForResponse();

        validateIfProcessAllCalls();
    }


    /**
     * aswer less number of calls that the service supports.
     *
     * the test validate if the queue of calls is empty.
     *
     * @throws Exception
     */
    @Test
    public void aswerLessNumbersCallByNumeberOfEmpoyee() throws Exception{

        Stream.generate(Call::create)
                .limit(numConcurrenCall - 5)
                .forEach(call -> producer.send(call.build()));

        waitForResponse();

        validateIfProcessAllCalls();
    }

    /**
     * sleep for timeOut (numComcurentCall * MAX_CALL_TIME)
     */
    private void waitForResponse(){
        try {
            TimeUnit.SECONDS.sleep(numConcurrenCall + MAX_CALL_TIME);
        } catch (InterruptedException e) {
           LOGGER.error("Exception ocurre when calc timeOut of response ",e);
        }
    }

    /**
     * validate if process all calls of queue.
     */
    private void validateIfProcessAllCalls(){
        Assert.assertFalse(callService.getCall().isPresent());
    }
}
