package restApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminResource {

    @RequestMapping(value = Uris.STATE, method = RequestMethod.GET)
    public String start() {
        return "{\"response\":\"OK " + Uris.VERSION + "\"}";
    }

}
