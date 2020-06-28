/**
 *
 */
package com.ironhack.midtermProject;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
@SpringBootApplication
@EnableSwagger2
public class MidtermProjectApplication  implements ApplicationRunner {

	@Autowired
	private Environment env;

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MidtermProjectApplication.class, args);
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.ironhack"))
				.build();
	}

	/**
	 *
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
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
		} catch (Exception e) {
			System.err.println("Failed to Execute" + aSQLScriptFilePath
					+ " The error is " + e.getMessage());
		} finally {
			if (con != null){
				con.close();
			}
		}
	}
}
