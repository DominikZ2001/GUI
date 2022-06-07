package gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

/**
 * Applikationsklasse
 * 
 * @author mmo
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EntityScan("gui.domain.entities")
@Theme(value = "schule")
public class App extends SpringBootServletInitializer implements AppShellConfigurator
{
	private static final long serialVersionUID = 8000412176660488541L;

	/** Test
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
