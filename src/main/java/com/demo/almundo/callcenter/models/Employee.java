package com.demo.almundo.callcenter.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * class that abstracting the behavior of all types of employees
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class Employee {

    /** Default class logger*/
    private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

    /** Unique identification for each employee  */
    private String identification;

    /** Employee status when attending or ending a Call */
    private EmployeeStatus status;

    /** Type of employee that works in the callcenter */
    private EmployeeType type;


    /**
     * Employee constructor from a builder instance
     *
     * @param builder The builder that contains all the information to create the Employee
     */
    protected Employee(Builder builder){

        this.identification = builder.identification;
        this.type = builder.type;
        this.status = builder.status;
    }


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
     * @param identification to set
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
     * @param status to set
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

    /**
     * Sets the employee type
     *
     * @param type to set
     */
    public void setType(EmployeeType type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Employee{" +
                "identification='" + identification + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }

    /**
     * Returns a new {@linkplain Builder Employee builder} instance
     *
     * @return A new {@linkplain Builder Employee builder} instance
     */
    public static Builder create() {

        return new Builder();
    }


    /**
     * Employee builder implementation
     */
    public static class Builder {

        /** Employee identifier (Same as the associated employee identifier) */
        private String identification;

        /** Employee status when attending or ending a Call */
        private  EmployeeStatus status;

        /** Type of employee that works in the callcenter */
        private EmployeeType  type;


        /**
         * default constructor for builder class
         */
        public Builder(){

            this.identification = UUID.randomUUID().toString();
        }


        /**
         * Sets the status with which the object will be built
         *
         * @param status The employee
         * @return This builder
         */
        public Builder withStatus(final EmployeeStatus status){

            this.status = status;
            return this;
        }

        /**
         * Sets the type of employee with whch the object will be built
         *
         * @param type The employee
         * @return This builder
         */
        public Builder withType(final EmployeeType type){

            this.type = type;
            return this;
        }

        /**
         * Creates and returns a new {@linkplain Employee} entity instance with the configured values
         */
        public Employee build() {
            return new Employee(this);
        }
    }

}
