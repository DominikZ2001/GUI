package gui.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import gui.domain.security.SecurityConfig;
import gui.domain.security.logic.AdminService;
import gui.ressources.i18n.deutsch.LoginI18NDeutsch;

/**
 * Loginseite
 * 
 * @author mmo
 */
@Route(Login.ROUTE)
@PageTitle("Login")
@CssImport("./login.css")
public class Login extends HorizontalLayout implements BeforeEnterObserver
{
	private static final long serialVersionUID = -1103649478869376806L;
	
	public static final String ROUTE = "/login";
	
	private final LoginForm loginForm = new LoginForm();
	
	@Autowired
	private InMemoryUserDetailsManager inMemoryManager;
	
	private AdminService service;
	
	/**
	 * Konstruktor zur Erstellung des Logins
	 */
	public Login(AdminService service)
	{
		this.service = service;
		
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);
		
		VerticalLayout loginFenster = new VerticalLayout();
		loginFenster.getStyle().set("opacity", "0.97").set("background-color", "#fff").set("align-self", "center").set("border-radius", "15px")
				.set("border", "2px solid #0e669d").set("margin-left", "0").set("display", "flex").set("flex-wrap", "wrap");
		loginFenster.setMinWidth(272, Unit.PIXELS);
		loginFenster.setWidth("25%");
		loginFenster.setAlignItems(Alignment.CENTER);
		loginFenster.setJustifyContentMode(JustifyContentMode.CENTER);
		
		loginForm.setAction("login");
		loginForm.setI18n(new LoginI18NDeutsch());
		loginForm.setForgotPasswordButtonVisible(false);
		
		H1 login = new H1("Login");
		login.getStyle().set("margin-top", "30px").set("margin-bottom", "20px");
		loginFenster.add(login, loginForm);
		add(loginFenster);
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event)
	{
		if (event.getLocation().getQueryParameters().getParameters().containsKey("error"))
			loginForm.setError(true);
		List<UserDetails> userDetails = service.getAllAdmins().stream().map(u -> User.withUserDetails(u).password(SecurityConfig.PASSWORT_VERSCHLUESSELUNG + u.getPassword()).build()).collect(Collectors.toList());
		userDetails.forEach(ud ->
		{
			if (!inMemoryManager.userExists(ud.getUsername()))
				inMemoryManager.createUser(ud);
		});
		
	}
}
