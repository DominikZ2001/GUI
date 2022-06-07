package gui.domain.entities;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/***
 * Userentität**
 * 
 * @author mmo
 */
@Entity
@Table(
		name = "admin")
@Proxy(
		lazy = false)
public class User implements UserDetails
{
	private static final long serialVersionUID = -321112336613654208L;
	
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(
			name = "username")
	private String username;
	
	@Column(
			name = "password")
	private String passwort;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	@Override
	public String getPassword()
	{
		return passwort;
	}
	
	@Override
	public String getUsername()
	{
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isEnabled()
	{
		return true;
	}
	
	/**
	 * @return die ID des Users
	 */
	public int getId()
	{
		return id;
	}
	
}
