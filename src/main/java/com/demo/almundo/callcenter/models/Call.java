package com.demo.almundo.callcenter.models;

import java.util.Random;
import java.util.UUID;

/**
 * This object represents the Call that enters the system
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
public class Call {

    /** Unique identification for each Call  */
    private String identification;

    /** the message in the call*/
    private String message;

    /** Minimum Call duration time */
    private static int MIN_CALL_TIME = 5;

    /** Maximun Call duration time */
    private static int MAX_CALL_TIME = 10;


    /**
     * Returns the call identifier
     *
     * @return identification of call
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Sets the call identifier
     *
     * @param identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Returns the message of call
     *
     * @return message call
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message call
     *
     * @param message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return "Call{" +
                "id='" + identification + '\'' +
                "value=" + message +
                '}';
    }

    /**
     * Return ramdom value for call duration with min value {@code MIN_CALL_TIME}
     * and max value {@code MAX_CALL_TIME}
     *
     * @return time to the call
     */
    public static int getRamdomCallDuration() {

        return new Random().ints(MIN_CALL_TIME, MAX_CALL_TIME).findAny().getAsInt();
    }


    /**
     * Returns a new {@linkplain Builder call builder} instance
     *
     * @return A new {@linkplain Builder call builder} instance
     */
    public static Builder create() {

        return new Builder();
    }


    /**
     * Call builder implementation
     */
    public static class Builder {

        /** Call identifier (Same as the associated call identifier) */
        private String identification;

        /** Call message information*/
        private String message;

        /**
         * Sets the call model identifier (Same as the associated call identifier)
         *
         * @param identification The call
         * @return This builder
         */
        public Builder withIdentification(final String identification){

            this.identification = identification;
            return this;
        }

        /**
         * Sets the message call sent to messaging system
         * @param message
         * @return
         */
        public Builder withMessage(final String message){

            this.identification = UUID.randomUUID().toString();
            this.message = message;
            return this;
        }
    }
}
