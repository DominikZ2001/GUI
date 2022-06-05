package gui.domain.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/***
 * Abstrakte Klasse zu Entitäten**
 * 
 * @author mmo
 */
@MappedSuperclass
public abstract class AEntity implements Serializable
{
	private static final long serialVersionUID = -3840478635693945533L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * @return die Id
	 */
	public Integer getId()
	{
		return id;
	}
}
