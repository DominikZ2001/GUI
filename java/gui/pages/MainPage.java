package java.gui.pages;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import gui.entities.Schueler;

@Route("")
public class MainPage extends VerticalLayout
{
	private static final long serialVersionUID = -6125224633763538070L;
	
	public MainPage()
	{
		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();
		
		TextField temperatur = new TextField();
		temperatur.setEnabled(false);
		temperatur.setValue("13.8°C");
		
		TextField luftfeuchtigkeit = new TextField();
		luftfeuchtigkeit.setEnabled(false);
		luftfeuchtigkeit.setValue("56%");
		
		TextField co2 = new TextField();
		temperatur.setEnabled(false);
		temperatur.setValue("2%");
		
		Grid<Schueler> anwesenheit = new Grid<>(Schueler.class);
		// Vorname Column
		anwesenheit.addComponentColumn(s -> zentriert(s.getVorname())).setHeader(c -> zentriert("Vorname"));
		
		
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
