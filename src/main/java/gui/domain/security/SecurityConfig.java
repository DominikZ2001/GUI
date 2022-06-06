package gui.domain.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import gui.application.Login;
import gui.application.MainPage;
import gui.domain.security.logic.AdminService;

/**
 * Konfigurationsklasse für den Zugriff von Nutzern und dem Log-In
 * 
 * @author mmo
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	// private final UserService service;
	private static final String PASSWORT_VERSCHLUESSELUNG = "{bcrypt}";

	private AdminService service;

	/**
	 * Konstruktor um User zu laden
	 * 
	 * @param service zum Laden der Benutzer
	 */
	public SecurityConfig(AdminService service)
	{
		super();
		this.service = service;
	}

	/**
	 * Konfiguration zum Login
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		// CSRF wird von Vaadin behandelt
		http.csrf().disable().headers().frameOptions().disable().and()
			// Registriere RequestCache für gespeicherte Anfragen von einem nicht
			// autorisierten Nutzer für redirection nach dem login
			.requestCache().requestCache(new CustomRequestCache())

			// Zugang verbieten
			.and().authorizeRequests()

			// Weiterleitung durch Vaadin erlauben
			.requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()

			.and().formLogin().loginPage(Login.ROUTE).loginProcessingUrl(Login.ROUTE).failureForwardUrl(Login.ROUTE + "?error")
			.successForwardUrl(MainPage.ROUTE)

			.and().logout().logoutSuccessUrl(Login.ROUTE);
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService()
	{
		List<UserDetails> userDetails = service.getAllAdmins().stream()
			.map(u -> User.builder().username(u.getUsername()).password(PASSWORT_VERSCHLUESSELUNG + u.getPassword()).build())
			.collect(Collectors.toList());
		return new InMemoryUserDetailsManager(userDetails);
	}

	/**
	 * Zugriff für nicht Authentifizierten Nutzer
	 */
	@Override
	public void configure(WebSecurity web)
	{
		web.ignoring().antMatchers(
			// Client-side JS
			"/VAADIN/**",

			// standard favicon URI
			"/favicon.ico",

			// robots exclusion standard
			"/robots.txt",

			// web application manifest
			"/manifest.webmanifest", "/sw.js", "/offline.html",

			// icons and images
			"/icons/**", "/frontend/images/**", "/styles/**");
	}
}
// Passwortverschluesselung mit BCrypt
//passwort = 1234567890
//passwort = passwort
//passwort = yasser
//passwort = till
