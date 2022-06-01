package gui.domain.security.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gui.domain.entities.Admin;
import gui.domain.repositories.AdminRepo;

@Service
public class AdminService
{

	@Autowired
	private AdminRepo adminRepo;

	public List<Admin> getAllAdmins()
	{
		return adminRepo.findAll();
	}
}
