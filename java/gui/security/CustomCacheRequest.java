package gui.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

/**
 * Klasse zum speichern von Anfragen von nicht angemeldelten Nutzern.
 * Zum Beispiel zur weiterleitung an die angefragten Seite nach dem Log-In
 * 
 * @author mmo
 */
class CustomRequestCache extends HttpSessionRequestCache
{
	
	@Override
	public void saveRequest(HttpServletRequest request, HttpServletResponse response)
	{
		if (!SecurityUtils.isFrameworkInternalRequest(request))
			super.saveRequest(request, response);
	}
}
