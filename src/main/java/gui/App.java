package gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Applikationsklasse
 * 
 * @author mmo
 */
@SpringBootApplication(
		exclude = ErrorMvcAutoConfiguration.class)
// @EnableJpaRepositories({ "de.exec.feedback.logic.repositories", "de.exec.feedback.security.logic.repositories" })
public class App extends SpringBootServletInitializer
{
	
	/**
	 * Start
	 * 
	 * @param args Programmargumente
	 * @throws Exception exception
	 */
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(App.class, args);
	}
}
