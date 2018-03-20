package com.demo.almundo.callcenter.service;

import com.demo.almundo.callcenter.messaging.queue.EmployeeQueue;
import com.demo.almundo.callcenter.models.Call;
import com.demo.almundo.callcenter.models.Employee;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This class handle different type of operation from {@link EmployeeQueue}.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public interface EmployeeService {

    /**
     * get {@link Employee} avalible form EmployeeQueue
     *
     * @return {@link  Optional<Employee>} from the queue of employees
     */
     Optional<Employee> getAvalibleEmployee();

    /**
     * Add employee to EmployeeQue
     * @param employee to add to Queue of employee
     */
     void addEmployee(Employee employee);


    /**
     * method that contains the logic to process a call by an employee.
     *
     * @param employee that aswer phone call
     * @param call to aswer by employee
     */
     void answerPhoneCall(Employee employee , Call call);

}
