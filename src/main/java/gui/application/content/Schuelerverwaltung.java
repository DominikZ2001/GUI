package gui.application.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import gui.domain.entities.Klasse;
import gui.domain.entities.Schueler;
import gui.domain.services.SchuelerProviderService;
import gui.presentation.ReadOnlyTextField;

public class Schuelerverwaltung extends VerticalLayout
{
	private static final long serialVersionUID = 8171142546713872664L;

	private Klasse klasse;

	private SchuelerProviderService service;

	public Schuelerverwaltung(Klasse klasse, SchuelerProviderService service)
	{
		super();

		this.klasse = klasse;
		this.service = service;

		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();

		add(new ReadOnlyTextField("Temperatur", "13.8°C"), new ReadOnlyTextField("Luftfeuchtigkeit", "56%"),
			new ReadOnlyTextField("CO2 Gehalt", "2%"), createSchuelerGrid());
	}

	private Grid<Schueler> createSchuelerGrid()
	{
		Grid<Schueler> anwesenheit = new Grid<>();
		anwesenheit.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

		// Columns
		anwesenheit.addComponentColumn(schueler -> zentriert(new Span(schueler.getVorname()))).setHeader(zentriert(new Span("Vorname")));
		anwesenheit.addComponentColumn(schueler -> zentriert(new Span(schueler.getNachname()))).setHeader(zentriert(new Span("Nachname")));

		anwesenheit.setClassNameGenerator(schueler ->
		{
			if (schueler.isAnwesened())
				return "anwesend";
			else
				return "abwesend";
		});

		anwesenheit.setItems(service.getAllSchuelerByKlasse(klasse));

		return anwesenheit;
	}

	private VerticalLayout zentriert(Component component)
	{
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.getThemeList().clear();

		layout.setJustifyContentMode(JustifyContentMode.CENTER);
		layout.setAlignItems(Alignment.CENTER);

		layout.add(component);
		return layout;
	}
}
