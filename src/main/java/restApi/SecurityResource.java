package restApi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("authenticated")//Opcion alternativa a las rutas http
@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.SECURITY)
public class SecurityResource {

    @RequestMapping(value = Uris.USER, method = RequestMethod.GET)
    public String user() {
        return "OK. Acceso permitido al recurso user";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")//Opcion alternativa a las rutas http
    @RequestMapping(value = Uris.MANAGER, method = RequestMethod.GET)
    public String manager() {
        return "OK. Acceso permitido al recurso manager";
    }

    @RequestMapping(value = Uris.ADMIN, method = RequestMethod.GET)
    public String admin() {
        return "OK. Acceso permitido al recurso admin";
    }
    
	@RequestMapping(value = Uris.SECURITYURIS, method = RequestMethod.GET)
	public boolean securityUris() {
		return true;
	}
	
	@RequestMapping(value = Uris.SECURITYANNOTATION, method = RequestMethod.GET)
	@PreAuthorize("hasRole('PLAYER')")
	public boolean securityAnnotationMethod() {
		return true;
	}
}
