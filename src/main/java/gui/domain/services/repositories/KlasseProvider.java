package gui.domain.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gui.domain.entities.Klasse;

@Repository
public interface KlasseProvider extends JpaRepository<Klasse, Integer>
{
}
