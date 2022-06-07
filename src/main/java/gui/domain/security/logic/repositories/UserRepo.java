package gui.domain.security.logic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gui.domain.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{}
