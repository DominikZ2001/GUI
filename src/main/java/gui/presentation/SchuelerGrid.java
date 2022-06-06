package gui.presentation;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import gui.domain.entities.Schueler;

public class SchuelerGrid extends Grid<Schueler>
{
	private static final long serialVersionUID = -7022986260912054265L;

	public SchuelerGrid()
	{
		super();
		addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

		// Columns
		addComponentColumn(schueler -> zentriert(fettgedrucktSpan(schueler.getVorname()))).setHeader(zentriert(new Span("Vorname")));
		addComponentColumn(schueler -> zentriert(fettgedrucktSpan(schueler.getNachname()))).setHeader(zentriert(new Span("Nachname")));

		setClassNameGenerator(schueler -> schueler.isAnwesened() ? "anwesend" : "abwesend");
	}

	private Span fettgedrucktSpan(String text)
	{
		Span span = new Span(text);
		span.getStyle().set("font-weight", "bold");
		return span;
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
