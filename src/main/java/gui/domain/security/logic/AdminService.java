package gui.domain.security.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.domain.entities.User;
import gui.domain.security.logic.repositories.UserRepo;

@Service
public class AdminService
{
	
	@Autowired
	private UserRepo adminRepo;
	
	public List<User> getAllAdmins()
	{
		return adminRepo.findAll();
	}
}
