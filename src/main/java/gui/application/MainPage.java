package gui.application;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import gui.domain.entities.Schueler;

@Route("")
public class MainPage extends VerticalLayout
{
	private static final long serialVersionUID = -6125224633763538070L;

	public MainPage()
	{
		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();

		TextField temperatur = new TextField();
		temperatur.setLabel("Temperatur");
		temperatur.setValue("13.8°C");
		temperatur.setReadOnly(true);

		TextField luftfeuchtigkeit = new TextField();
		luftfeuchtigkeit.setValue("56%");
		luftfeuchtigkeit.setReadOnly(true);

		TextField co2 = new TextField();
		co2.setLabel("CO2 Gehalt");
		co2.setValue("2%");
		co2.setReadOnly(true);

		VerticalLayout gridLayout = new VerticalLayout();

		H2 gridHeader = new H2("BSFI 20A");
		gridLayout.add(gridHeader);

		Grid<Schueler> anwesenheit = new Grid<>(Schueler.class);
		anwesenheit.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

		// Columns
		anwesenheit.addComponentColumn(s -> zentriert(s.getVorname())).setHeader(zentriert("Vorname"));
		anwesenheit.addComponentColumn(s -> zentriert(s.getNachname())).setHeader(zentriert("Nachname"));
		anwesenheit.addComponentColumn(s -> zentriert(s.isAnwesened() ? "Anwesend" : "Abwesend")).setHeader(zentriert("Anwesenheit"));
		gridLayout.add(anwesenheit);

		add(temperatur, luftfeuchtigkeit, co2, gridLayout);

	}

	private VerticalLayout zentriert(String textString)
	{
		VerticalLayout layout = new VerticalLayout();
		layout.setJustifyContentMode(JustifyContentMode.CENTER);
		Div text = new Div();
		text.setText(textString);
		layout.add(text);
		return layout;
	}
}
