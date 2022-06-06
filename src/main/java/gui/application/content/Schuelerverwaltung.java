package gui.application.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.helger.commons.base64.Base64;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;

import gui.domain.entities.Klasse;
import gui.domain.services.SchuelerProviderService;
import gui.presentation.ReadOnlyTextField;
import gui.presentation.SchuelerGrid;

public class Schuelerverwaltung extends VerticalLayout
{
	private static final long serialVersionUID = 8171142546713872664L;

	private Klasse klasse;

	private SchuelerProviderService service;

	private Image bild = new Image();

	public Schuelerverwaltung(Klasse klasse, SchuelerProviderService service)
	{
		super();

		this.klasse = klasse;
		this.service = service;

		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();

		HorizontalLayout bildUndArduinoDatenLayout = new HorizontalLayout();
		bildUndArduinoDatenLayout.setWidthFull();
		bildUndArduinoDatenLayout.setHeight(60, Unit.PERCENTAGE);

		bildUndArduinoDatenLayout.add(schuelerBildLayout(), arduinoLayout());

		add(bildUndArduinoDatenLayout, createSchuelerGrid());
	}

	private SchuelerGrid createSchuelerGrid()
	{
		SchuelerGrid anwesenheit = new SchuelerGrid();
		anwesenheit.setWidthFull();
		anwesenheit.setHeight(40, Unit.PERCENTAGE);

		anwesenheit.setItems(service.getAllSchuelerByKlasse(klasse));

		anwesenheit.addItemClickListener(e ->
		{
			bild.setSrc(new StreamResource("Bild vom Schüler", () ->
			{
				try
				{
					return new ByteArrayInputStream(Base64.decode(e.getItem().getBild()));
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
				return null;
			}));
		});

		return anwesenheit;
	}

	private VerticalLayout arduinoLayout()
	{
		VerticalLayout arduinoLayout = new VerticalLayout();
		arduinoLayout.setHeightFull();
		arduinoLayout.setWidth(30, Unit.PERCENTAGE);
		arduinoLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		arduinoLayout.setAlignItems(Alignment.CENTER);

		arduinoLayout.add(new ReadOnlyTextField("Temperatur", "13.8°C"), new ReadOnlyTextField("Luftfeuchtigkeit", "56%"),
			new ReadOnlyTextField("CO2 Gehalt", "2%"));
		return arduinoLayout;
	}

	private VerticalLayout schuelerBildLayout()
	{
		VerticalLayout schuelerBildLayout = new VerticalLayout();
		schuelerBildLayout.setHeightFull();
		schuelerBildLayout.setWidth(70, Unit.PERCENTAGE);
		schuelerBildLayout.getStyle().set("border-radius", "15px").set("border", "1px solid black");

		bild.setHeightFull();

		schuelerBildLayout.add(bild);
		return schuelerBildLayout;
	}

}
