/**
 * com.ironhack.midtermProject.exception;
 */
package com.ironhack.midtermProject.exception;

/**
 * DataNotFoundException Class
 */
public class DataNotFoundException extends RuntimeException {
    /**
     * Constructor DataNotFoundException
     * @param message Message to Show
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
