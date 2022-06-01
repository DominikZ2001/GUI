// package gui.security.entities;
//
// import java.util.Arrays;
// import java.util.Collection;
//
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.Table;
//
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
//
/// **
// * Userentität
// *
// * @author mmo
// */
// @Entity
// @Table(
// name = "login")
// public class User implements UserDetails
// {
// private static final long serialVersionUID = -321112336613654208L;
//
// @GeneratedValue
// @Id
// private int id;
//
// @Column(
// name = "username")
// private String username;
//
// @Column(
// name = "passwort")
// private String passwort;
//
// @Column(
// name = "aktiv")
// private boolean aktiv;
//
// @Override
// public Collection<? extends GrantedAuthority> getAuthorities()
// {
// return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
// }
//
// @Override
// public String getPassword()
// {
// return passwort;
// }
//
// @Override
// public String getUsername()
// {
// return username;
// }
//
// @Override
// public boolean isAccountNonExpired()
// {
// return true;
// }
//
// @Override
// public boolean isAccountNonLocked()
// {
// return true;
// }
//
// @Override
// public boolean isCredentialsNonExpired()
// {
// return true;
// }
//
// @Override
// public boolean isEnabled()
// {
// return aktiv;
// }
//
// /**
// * @return die ID des Users
// */
// public int getId()
// {
// return id;
// }
//
// }
