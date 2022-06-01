package gui.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends AEntity
{
	private static final long serialVersionUID = 2328039783516311730L;

	@Column(name = "vorname")
	private String vorname;

	@Column(name = "nachname")
	private String nachname;

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
