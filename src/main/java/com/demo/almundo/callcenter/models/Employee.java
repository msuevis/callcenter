package com.demo.almundo.callcenter.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class that abstracting the behavior of all types of employees
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public  abstract class Employee {

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

    /** Unique identification for each employee  */
    private String identification;

    /** Employee status when attending or ending a Call */
    private EmployeeStatus status;

    /** Type of employee that works in the callcenter */
    private EmployeeType type;

    /**
     * Returns the Employee identifier
     *
     * @return identification the employeer
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Sets the employee identifier
     *
     * @param identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Returns The employee status
     *
     * @return identification the employeer
     */
    public EmployeeStatus getStatus() {
        return status;
    }

    /**
     * Sets the employee status
     *
     * @param status
     */
    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    /**
     * Returns The employee status
     *
     * @return identification the employeer
     */
    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
}
