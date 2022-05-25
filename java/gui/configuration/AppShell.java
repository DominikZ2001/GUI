package gui.configuration;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * AppShell
 * 
 * @author mmo
 */
@Theme(
		themeClass = Lumo.class,
		variant = Lumo.LIGHT)
public class AppShell implements AppShellConfigurator
{
	private static final long serialVersionUID = -9036882215599881025L;
	
}
