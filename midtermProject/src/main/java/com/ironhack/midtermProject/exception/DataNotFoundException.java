/**
 * com.ironhack.midtermProject.exception;
 */
package com.ironhack.midtermProject.exception;

/**
 * DataNotFoundException Class
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
