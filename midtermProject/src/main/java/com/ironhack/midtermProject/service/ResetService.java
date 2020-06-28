package com.ironhack.midtermProject.service;

import com.ironhack.midtermProject.exception.ResetDataException;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Service
public class ResetService {

    private static final Logger LOGGER = LogManager.getLogger(CreditCardAccountService.class);

    @Autowired
    private Environment env;

    public void resetData() {
        String aSQLScriptFilePath = "./src/main/resources/populate.sql";
        Connection con = null;
        try {
        env.getProperty("spring.datasource.url");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password"));

            ScriptRunner scriptRunner = new ScriptRunner(con);
            Reader reader = new BufferedReader(
                    new FileReader(aSQLScriptFilePath));
            scriptRunner.runScript(reader);
            con.close();
        } catch (Exception e) {
            ResetDataException ex = new ResetDataException("Failed to Execute" + aSQLScriptFilePath
                    + " The error is " + e.getMessage());
            LOGGER.error(ex);
            throw ex;
        }
    }
}
