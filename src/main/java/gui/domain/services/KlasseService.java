package gui.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.domain.entities.Klasse;
import gui.domain.services.repositories.KlasseProvider;

@Service
public class KlasseService
{
	@Autowired
	private KlasseProvider klasseRepo;

	public List<Klasse> getAllKlassen()
	{
		return klasseRepo.findAll();
	}
}
