package gui.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gui.domain.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{
}
