package gui.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.domain.entities.Klasse;
import gui.domain.entities.Schueler;
import gui.domain.services.repositories.SchuelerProvider;

@Service
public class SchuelerProviderService
{
	@Autowired
	private SchuelerProvider schuelerRepository;

	public List<Schueler> getAllSchuelerByKlasse(Klasse klasse)
	{
		return schuelerRepository.getAllSchuelerByKlasse(klasse);
	}

	public void save(Schueler schueler)
	{
		schuelerRepository.save(schueler);
	}
}
