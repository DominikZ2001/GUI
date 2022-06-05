package gui.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "schueler")
@Table(name = "schueler")
public class Schueler extends AEntity
{
	private static final long serialVersionUID = 2328039783516311730L;

	@Column(name = "vorname", nullable = false)
	private String vorname;

	@Column(name = "nachname", nullable = false)
	private String nachname;

	@Column(name = "anwesend", nullable = false, columnDefinition = "boolean default false")
	private boolean anwesened = false;

	@ManyToOne
	@JoinColumn(name = "klasse", nullable = false)
	private Klasse klasse;

	public boolean isAnwesened()
	{
		return anwesened;
	}

	public void setAnwesened(boolean anwesened)
	{
		this.anwesened = anwesened;
	}

	public Klasse getKlasse()
	{
		return klasse;
	}

	public void setKlasse(Klasse klasse)
	{
		this.klasse = klasse;
	}

	public String getVorname()
	{
		return vorname;
	}

	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	public String getNachname()
	{
		return nachname;
	}

	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

}
