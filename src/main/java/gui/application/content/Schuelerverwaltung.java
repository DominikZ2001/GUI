package gui.application.content;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import com.helger.commons.base64.Base64;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.server.StreamResource;

import gui.domain.entities.Klasse;
import gui.domain.entities.Schueler;
import gui.domain.services.SchuelerProviderService;
import gui.presentation.ReadOnlyTextField;
import gui.presentation.SchuelerGrid;
import gui.ressources.i18n.deutsch.UploadI18NDeutsch;

public class Schuelerverwaltung extends VerticalLayout
{
	private static final long serialVersionUID = 8171142546713872664L;

	private Klasse klasse;

	private SchuelerProviderService service;

	private Image bild = new Image();

	private SchuelerGrid schuelerGrid;

	public Schuelerverwaltung(Klasse klasse, SchuelerProviderService service)
	{
		super();

		this.klasse = klasse;
		this.service = service;
		this.schuelerGrid = schuelerGrid();

		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();

		HorizontalLayout bildUndArduinoDatenLayout = new HorizontalLayout();
		bildUndArduinoDatenLayout.setWidthFull();
		bildUndArduinoDatenLayout.setHeight(60, Unit.PERCENTAGE);

		bildUndArduinoDatenLayout.add(schuelerBildLayout(), arduinoLayout());

		add(bildUndArduinoDatenLayout, schuelerGridEditSplitLayout());
	}

	private SplitLayout schuelerGridEditSplitLayout()
	{

		SplitLayout split = new SplitLayout(schuelerGrid, editLayout(null));
		split.setWidthFull();
		split.setHeight(40, Unit.PERCENTAGE);
		split.setSplitterPosition(70);

		schuelerGrid.addItemClickListener(e -> split.addToSecondary(editLayout(e.getItem())));

		return split;
	}

	private SchuelerGrid schuelerGrid()
	{
		SchuelerGrid anwesenheit = new SchuelerGrid();
		anwesenheit.setMinWidth(500, Unit.PIXELS);

		anwesenheit.setItems(service.getAllSchuelerByKlasse(klasse));

		anwesenheit.addItemClickListener(e -> setImageSrc(e.getItem()));

		anwesenheit.getDataProvider().addDataProviderListener(e -> e.getSource());

		return anwesenheit;
	}

	private HorizontalLayout editLayout(Schueler schueler)
	{

		HorizontalLayout komponentenLayout = new HorizontalLayout();
		komponentenLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		komponentenLayout.setAlignItems(Alignment.CENTER);
		komponentenLayout.setSizeFull();
		komponentenLayout.setMinWidth(600, Unit.PIXELS);

		if (Objects.nonNull(schueler))
		{
			VerticalLayout editierbareDaten = new VerticalLayout();
			editierbareDaten.setHeightFull();
			editierbareDaten.setWidth(40, Unit.PERCENTAGE);
			editierbareDaten.setJustifyContentMode(JustifyContentMode.CENTER);
			editierbareDaten.setAlignItems(Alignment.END);

			TextField vorname = new TextField();
			vorname.setLabel("Vorname");

			TextField nachname = new TextField();
			nachname.setLabel("Nachname");

			Checkbox anwesenheit = new Checkbox();
			anwesenheit.setLabel("Anwesend");
			// Auf TextField Höhe setzen
			anwesenheit.getStyle().set("margin-right", "81.1px");

			Binder<Schueler> binding = new Binder<>(Schueler.class);
			binding.withValidator(vornameText -> !vornameText.getVorname().isBlank(), "Das Feld muss gefüllt sein").bind(vorname,
				Schueler::getVorname, Schueler::setVorname);
			binding.withValidator(vornameText -> !vornameText.getNachname().isBlank(), "Das Feld muss gefüllt sein").bind(nachname,
				Schueler::getNachname, Schueler::setNachname);
			binding.bind(anwesenheit, Schueler::isAnwesened, Schueler::setAnwesened);

			binding.setBean(schueler);

			binding.addValueChangeListener(e -> updateGridAndSave(binding.getBean()));
			binding.addStatusChangeListener(e -> updateGridAndSave(binding.getBean()));

			editierbareDaten.add(vorname, nachname, anwesenheit);

			VerticalLayout imageUploadLayout = new VerticalLayout();
			imageUploadLayout.setHeightFull();
			imageUploadLayout.setWidth(60, Unit.PERCENTAGE);
			imageUploadLayout.setJustifyContentMode(JustifyContentMode.CENTER);
			imageUploadLayout.setAlignItems(Alignment.START);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			Upload upload = new Upload();
			upload.setI18n(new UploadI18NDeutsch());

			upload.setReceiver(new Receiver()
			{
				private static final long serialVersionUID = -3504494076211932802L;

				@Override
				public OutputStream receiveUpload(String filename, String mimeType)
				{
					return baos;
				}
			});
			upload.setAcceptedFileTypes("image/*");
			upload.addSucceededListener(e ->
			{
				binding.getBean().setBild(java.util.Base64.getEncoder().encodeToString(baos.toByteArray()));
				setImageSrc(binding.getBean());
				updateGridAndSave(binding.getBean());
			});

			imageUploadLayout.add(upload);

			komponentenLayout.add(editierbareDaten, imageUploadLayout);
		}

		return komponentenLayout;
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
		bild.setWidth(50, Unit.PERCENTAGE);

		schuelerBildLayout.add(bild);
		return schuelerBildLayout;
	}

	private void updateGridAndSave(Schueler schueler)
	{
		schuelerGrid.getDataProvider().refreshItem(schueler);
		service.save(schueler);
	}

	private void setImageSrc(Schueler schueler)
	{
		bild.setSrc(new StreamResource("Bild vom Schüler", () ->
		{
			try
			{
				return new ByteArrayInputStream(Base64.decode(schueler.getBild()));
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			return null;
		}));
	}

}
