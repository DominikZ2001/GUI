package gui.application;

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

import gui.ressources.i18n.deutsch.LoginI18NDeutsch;

/**
 * Loginseite
 * 
 * @author mmo
 */
@Route(Login.LOGIN_URL)
@PageTitle("Login")
@CssImport("./login.css")
public class Login extends HorizontalLayout implements BeforeEnterObserver
{
	private static final long serialVersionUID = -1103649478869376806L;
	
	public static final String LOGIN_URL = "/login";
	
	private final LoginForm loginForm = new LoginForm();
	
	/**
	 * Konstruktor zur Erstellung des Logins
	 */
	public Login()
	{
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);
		
		VerticalLayout loginFenster = new VerticalLayout();
		loginFenster.getStyle().set("opacity", "0.97").set("background-color", "#fff")
				.set("align-self", "center").set("border-radius", "15px")
				.set("border", "2px solid #0e669d").set("margin-left", "0")
				.set("display", "flex").set("flex-wrap", "wrap");
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
	}
}
