package com.demo.almundo.callcenter.models;

/**
 * Concrete employee class that instance a operator object
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class Operator extends Employee{

    /**
     * Operator constructor from a builder instance
     *
     * @param builder The builder that contains all the information to create the Operator
     */
    protected Operator(Builder builder){
        super(builder);
    }

}
