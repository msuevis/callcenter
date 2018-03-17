package com.demo.almundo.callcenter.models;

/**
 * This enum refers to the different kind of employee.
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public enum EmployeeType {

    /**
     * This is an individual at a Call center who is appointed for answering customer calls
     */
    OPERATOR,

    /** This is the person in a Call center who provides additional support and technical knowledge to operator*/
    SUPERVISOR,

    /**
     * This is a Employee who is responsible for budget execution, operation, business performance and overall direction of the Call centre management software.
     */
    DIRECTOR;

}