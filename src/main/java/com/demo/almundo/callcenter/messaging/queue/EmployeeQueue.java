package com.demo.almundo.callcenter.messaging.queue;

import com.demo.almundo.callcenter.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * In this class we will create a Priority Blocking Queue and
 * submit/retrieve all the call from it.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@Component
public class EmployeeQueue{

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeQueue.class);

    /** Default employee Queue to save employee for priority */
    private Queue<Employee> priorityEmployeeQueue;

    /**Number of instance of opeator*/
    @Value("${employee.instanceOperator}")
    private int instanceOperator;

    /**Number of instance of supervisor*/
    @Value("${employee.instanceSupervisor}")
    private int instanceSupervisor;

    /**Number of instance of director*/
    @Value("${employee.instanceDirector}")
    private int instanceDirector;

    @PostConstruct
    public void init(){
        priorityEmployeeQueue = new PriorityBlockingQueue<Employee>();
        loadEmployees();
    }

    /**
     * add {@link Employee} to queue.
     *
     * @param employee to add to priority employee queue
     * @return if employee is add to queue
     */
    public boolean add(Employee employee) {

        return priorityEmployeeQueue.add(employee);
    }


    /**
     * retrieve {@link Optional<Employee>} from queue.
     *
     * @return  {@link Optional<Employee>} from queue.
     */
    public Optional<Employee> poll() {

        return  Optional.ofNullable(priorityEmployeeQueue.poll());
    }


    /**
     * load all list of employee to queue
     */
    private void loadEmployees(){

        addOperatorToQuee();

        addSupervisorToQuee();

        addDiretorToQuee();
    }

    /**
     * fill list of operator
     */
    private void addOperatorToQuee(){
        for (int i=0; i <  instanceOperator; i++){
            priorityEmployeeQueue.add(Operator.create().withType(EmployeeType.OPERATOR).build());
        }
    }

    /**
     * fill list of Supervisor
     */
    private void addSupervisorToQuee(){
        for (int i=0; i <  instanceSupervisor; i++){
            priorityEmployeeQueue.add(Supervisor.create().withType(EmployeeType.SUPERVISOR).build());
        }
    }

    /**
     * fill list of Director
     */
    private void addDiretorToQuee(){
        for (int i=0; i < instanceDirector; i++){
            priorityEmployeeQueue.add(Director.create().withType(EmployeeType.DIRECTOR).build());
        }
    }

}
