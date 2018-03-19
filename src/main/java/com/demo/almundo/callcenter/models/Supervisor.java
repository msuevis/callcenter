package com.demo.almundo.callcenter.models;

/**
 * Concrete employee class that instance a Supervisor object
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class Supervisor extends Employee{

    /**
     * Supervisor constructor from a builder instance
     *
     * @param builder The builder that contains all the information to create the Supervisor
     */
   protected Supervisor(Builder builder){
       super(builder);
   }

}
