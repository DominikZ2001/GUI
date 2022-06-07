package gui.domain.security;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import gui.application.Login;
import gui.application.MainPage;

/**
 * Service zum festellen, ob der User die benötigten Berechtigungen hat
 * 
 * @author mmo
 */
@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener
{
	private static final long serialVersionUID = 2661613812996180499L;
	
	@Override
	public void serviceInit(ServiceInitEvent event)
	{
		
		event.getSource().addUIInitListener(uiEvent ->
		{
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::authenticateNavigation);
		});
	}
	
	/**
	 * Authentifizierung vor dem Laden einer Seite. Wenn Der Nutzer nicht angemeldet ist,
	 * die Seite auf die er gehen will nicht die Log-In Seite ist und nicht das FeedbackFormular ist,
	 * dann leite ihn auf die Log-In Seite weiter
	 * 
	 * @param event BeforeEvent
	 */
	private void authenticateNavigation(BeforeEnterEvent event)
	{
		if (SecurityUtils.isUserLoggedIn()
				&& event.getNavigationTarget().equals(Login.class))
			event.rerouteTo(MainPage.class);
		
	}
}
