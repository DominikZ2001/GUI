package gui.ressources.i18n.deutsch;

import com.vaadin.flow.component.login.LoginI18n;

/**
 * I18N Deutsch
 * 
 * @author mmo
 */
public class LoginI18NDeutsch extends LoginI18n
{
	private static final long serialVersionUID = 3061744202510326958L;
	
	/**
	 * Konstruktor mit den deutschen Standardkonfigurationen
	 */
	public LoginI18NDeutsch()
	{
		// Header
		Header logInHeader = new Header();
		logInHeader.setTitle("Log-In");
		setHeader(logInHeader);
		
		// Form
		Form logInForm = new Form();
		logInForm.setForgotPassword("Passwort vergessen");
		logInForm.setSubmit("Anmelden");
		logInForm.setPassword("Passwort");
		logInForm.setUsername("Benutzername");
		setForm(logInForm);
		
		// Error
		ErrorMessage logInError = new ErrorMessage();
		logInError.setMessage("Ungültiger Benutzername oder Passwort");
		setErrorMessage(logInError);
	}
}
