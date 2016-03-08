package restApi;

import java.util.GregorianCalendar;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restApi.exceptions.MalformedHeaderException;
import restApi.exceptions.NotFoundUserIdException;
import restApi.exceptions.UnauthorizedException;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminResource {

    @RequestMapping(value = Uris.STATE, method = RequestMethod.GET)
    public String start() {
        return "{\"response\":\"OK " + Uris.VERSION + "\"}";
    }

    @RequestMapping(value = Uris.ECHO + Uris.ID, method = RequestMethod.GET)
    public String echo(@RequestHeader(value = "token", required = false) String token, @PathVariable(value = "id") int id,
            @RequestParam(defaultValue = "Non") String param) {
        String response = "{\"id\":%d,\"token\":\"%s\",\"param\":\"%s\"}";
        return String.format(response, id, token, param);
    }

    @RequestMapping(value = Uris.BODY, method = RequestMethod.POST)
    public Wrapper body(@RequestBody Wrapper wrapper) {
        return wrapper;
    }
    
    @RequestMapping(value = Uris.ERROR + Uris.ID, method = RequestMethod.GET)
    public Wrapper error(@RequestHeader(value = "token") String token, @PathVariable(value = "id") int id) throws NotFoundUserIdException,
            UnauthorizedException, MalformedHeaderException {
        if (id == 0) {
            throw new NotFoundUserIdException("id:" + id);
        }
        if (token.equals("kk")) {
            throw new MalformedHeaderException("token:" + token);
        }
        if (token.equals("Basic kk")) {
            throw new UnauthorizedException("token:" + token);
        }
        return new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
    }
    
    @RequestMapping(value = Uris.SECURITY, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String securityAnnotation(){
        return "{\"response\":\"Security\"}";
    }
 
}
