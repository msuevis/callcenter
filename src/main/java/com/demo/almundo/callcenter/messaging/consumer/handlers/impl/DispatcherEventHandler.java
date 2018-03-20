package com.demo.almundo.callcenter.messaging.consumer.handlers.impl;


import com.demo.almundo.callcenter.messaging.consumer.events.impl.DispatchCallEvent;
import com.demo.almundo.callcenter.messaging.consumer.handlers.Handler;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.models.Employee;
import com.demo.almundo.callcenter.service.ICallService;
import com.demo.almundo.callcenter.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Handle the {@link DispatchCallEvent} message.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class DispatcherEventHandler implements Handler<DispatchCallEvent> {

    /**
     * Default class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherEventHandler.class);

    /** ICallService component to retrive call message */
    @Autowired
    private ICallService callService;

    /** component to retrieve avalable employee */
    @Autowired
    private EmployeeService employeeService;

    /** Executor service reference */
    private ExecutorService exectorService;

    @Value("${dispatcher.numConcurrenCall}")
    private int numConcurrentCall;

    /**
     * default constructor for DispatcherEventHandler class
     */
    public DispatcherEventHandler(){

    }

    /**
     * post construct method to init executor
     */
    @PostConstruct
    public void init(){
        this.exectorService = Executors.newFixedThreadPool(numConcurrentCall);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void dispatchCall(DispatchCallEvent event) {

        Optional<Call> call = callService.getCall();
        Optional<Employee> employee = employeeService.getAvalibleEmployee();

        if(isAvalibleCallAndEmployee(call, employee)){

            CompletableFuture.runAsync(()-> {
                employeeService.answerPhoneCall(employee.get(),call.get());
            }, exectorService);
        }

    }

    /**
     * validate is present the result of a call and employee.
     *
     * @param call
     * @param employee
     * @return
     */
    private boolean isAvalibleCallAndEmployee(Optional<Call> call, Optional<Employee> employee){

        return call.isPresent() && employee.isPresent();
    }
}
