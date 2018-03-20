package com.demo.almundo.callcenter.service.impl;

import com.demo.almundo.callcenter.messaging.queue.EmployeeQueue;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.models.Employee;
import com.demo.almundo.callcenter.models.EmployeeStatus;
import com.demo.almundo.callcenter.models.Operator;
import com.demo.almundo.callcenter.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * This concrete class handle different type of operation from {@link EmployeeQueue}.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class EmployeeServiceImpl implements EmployeeService{

    /**
     * Default class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeQueue employeeQueue;


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Employee> getAvalibleEmployee(){

        return employeeQueue.poll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEmployee(final Employee employee) {
        employeeQueue.add(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void answerPhoneCall(final Employee employee, final Call call) {

        employee.setStatus(EmployeeStatus.BUSY);
        notifyEmployeeStatus(employee);

        try {

            TimeUnit.SECONDS.sleep(call.getCallDuration());

        } catch (final InterruptedException e) {

           LOGGER.error("An error occurred during the " +
                           "call attended by the [{}] , " +
                           "with id [{}]" +
                           " and error detail : {} ",
                         employee.getType(),
                         employee.getIdentification(),
                   e);

        }finally {
            employee.setStatus(EmployeeStatus.AVAILABLE);
            addEmployee(employee);
            notifyEmployeeStatus(employee);
        }


    }

    /**
     * the user's status is notified during the execution of the call
     *
     * @param employee to notify status
     */
    private void notifyEmployeeStatus(final Employee employee){

        LOGGER.info("The employee with id [{}] and position [{}] is [{}]",
                employee.getIdentification(),
                employee.getType(),
                employee.getStatus());
    }


}
