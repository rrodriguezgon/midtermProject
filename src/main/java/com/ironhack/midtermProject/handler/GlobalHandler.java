/**
 * com.ironhack.midtermProject.handler
 */
package com.ironhack.midtermProject.handler;

import com.ironhack.midtermProject.exception.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GlobalHandler Class
 */
@ControllerAdvice()
public class GlobalHandler {
    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(DataNotFoundException.class)
    public void handleDataNotFoundException(DataNotFoundException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage()); }

    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(SecurityAccessException.class)
    public void handleSecurityAccessException(SecurityAccessException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }

    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(FundsException.class)
    public void handleFundsException(FundsException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }

    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(UserExistException.class)
    public void handleUserExistException(UserExistException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, e.getMessage()); }

    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(FraudException.class)
    public void handleFraudException(FraudException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }

    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException IOException Catcher
     */
    @ExceptionHandler(ResetDataException.class)
    public void handleResetDataException(ResetDataException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }
}