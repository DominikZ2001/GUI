package gui.application;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import gui.application.content.Schuelerverwaltung;
import gui.domain.entities.Klasse;
import gui.domain.security.SecurityUtils;
import gui.domain.services.KlasseService;
import gui.domain.services.SchuelerProviderService;

@Route(MainPage.ROUTE)
public class MainPage extends AppLayout
{
	private static final long serialVersionUID = -6125224633763538070L;
	
	public static final String ROUTE = "/";
	
	private KlasseService klasseService;
	
	private SchuelerProviderService schuelerService;
	
	public MainPage(KlasseService klasseService, SchuelerProviderService schuelerService)
	{
		super();
		
		this.klasseService = klasseService;
		this.schuelerService = schuelerService;
		
		createNavbar();
	}
	
	private void createNavbar()
	{
		HorizontalLayout layout = new HorizontalLayout();
		layout.getThemeList().add("padding");
		layout.setSizeFull();
		layout.setJustifyContentMode(JustifyContentMode.BETWEEN);
		layout.setAlignItems(Alignment.CENTER);
		
		H2 text = new H2("Bubatz");
		text.getStyle().set("margin", "0px");
		
		Button logout = new Button(VaadinIcon.EXIT.create());
		logout.setText("Logout");
		logout.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		logout.addClickListener(e -> SecurityUtils.logout());
		
		ComboBox<Klasse> klassen = new ComboBox<>();
		klassen.setItems(klasseService.getAllKlassen());
		klassen.setItemLabelGenerator(klasse -> klasse.getName());
		klassen.addValueChangeListener(e -> setContent(new Schuelerverwaltung(e.getValue(), schuelerService)));
		klassen.setValue(klasseService.getAllKlassen().get(0));
		
		layout.add(text, klassen, logout);
		
		addToNavbar(layout);
	}
}
