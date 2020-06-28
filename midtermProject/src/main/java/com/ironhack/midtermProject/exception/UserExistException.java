/**
 * com.ironhack.midtermProject.exception
 */
package com.ironhack.midtermProject.exception;

/**
 * UserExistException Class
 */
public class UserExistException extends RuntimeException {
    public UserExistException(String s) {
        super(s);
    }
}
