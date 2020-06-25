package com.ironhack.midtermProject.handler;

import com.ironhack.midtermProject.exception.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice()
public class GlobalHandler {
    /**
     * Exception Handler to handle exceptions.
     * @param e Receives an Exception.
     * @param response Receives an HTTP Response.
     * @throws IOException
     */
    @ExceptionHandler(DataNotFoundException.class)
    public void handleDataNotFoundException(DataNotFoundException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage()); }

    @ExceptionHandler(SecurityAccessException.class)
    public void handleSecurityAccessException(SecurityAccessException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }

    @ExceptionHandler(FundsException.class)
    public void handleFundsException(FundsException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }

    @ExceptionHandler(UserExistException.class)
    public void handleUserExistException(UserExistException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, e.getMessage()); }

    @ExceptionHandler(FraudException.class)
    public void handleFraudException(FraudException e, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()); }
}