package gui.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "klasse")
public class Klasse extends AEntity
{
	private static final long serialVersionUID = -5307986530355302336L;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "klasse")
	private List<Schueler> schueler;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Schueler> getSchueler()
	{
		return schueler;
	}

	public void setSchueler(List<Schueler> schueler)
	{
		this.schueler = schueler;
	}

}
