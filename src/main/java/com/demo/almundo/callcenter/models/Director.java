package com.demo.almundo.callcenter.models;

/**
 * Concrete employee class that instance a Director object
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class Director extends Employee{

    /**
     * Director constructor from a builder instance
     *
     * @param builder The builder that contains all the information to create the Director
     */
    protected Director(Builder builder){
        super(builder);
    }

}
