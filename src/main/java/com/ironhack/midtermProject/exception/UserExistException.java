/**
 * com.ironhack.midtermProject.exception
 */
package com.ironhack.midtermProject.exception;

/**
 * UserExistException Class
 */
public class UserExistException extends RuntimeException {
    /**
     * Constructor UserExistException
     * @param message Message to Show
     */
    public UserExistException(String message) {
        super(message);
    }
}
