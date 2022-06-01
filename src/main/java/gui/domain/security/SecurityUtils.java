package gui.domain.security;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.vaadin.flow.server.HandlerHelper.RequestType;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.shared.ApplicationConstants;

/**
 * Security Utilitys
 * 
 * @author mmo
 */
public final class SecurityUtils
{
	
	private SecurityUtils()
	{}
	
	/**
	 * @param request Anfrage
	 * @return ob die Anfrage eine Vaadininterne Anfrage ist
	 */
	public static boolean isFrameworkInternalRequest(HttpServletRequest request)
	{
		
		final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
		return parameterValue != null
				&& Stream.of(RequestType.values())
						.anyMatch(r -> r.getIdentifier().equals(parameterValue));
	}
	
	/**
	 * @return ob der User angemeldet ist
	 */
	public static boolean isUserLoggedIn()
	{
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null
				&& !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();
	}
	
	/**
	 * Meldet den aktuellen User ab
	 */
	public static void logout()
	{
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(
				VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
				null);
	}
}
