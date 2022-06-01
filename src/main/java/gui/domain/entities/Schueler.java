package gui.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Schueler")
public class Schueler extends Person
{
	private static final long serialVersionUID = 5953910174373564970L;

	@Column(name = "anwesend")
	private boolean anwesened = false;

	@Column(name = "klasse")
	private String klasse;

	public boolean isAnwesened()
	{
		return anwesened;
	}

	public void setAnwesened(boolean anwesened)
	{
		this.anwesened = anwesened;
	}

	public String getKlasse()
	{
		return klasse;
	}

	public void setKlasse(String klasse)
	{
		this.klasse = klasse;
	}

}
