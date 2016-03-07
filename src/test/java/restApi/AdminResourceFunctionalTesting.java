package restApi;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import config.TestsApiConfig;
import restApi.Uris;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class AdminResourceFunctionalTesting {

    private static final String URL_API = "http://localhost:8080/Ejercicio1.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testState() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API + Uris.ADMINS + Uris.STATE).build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        System.out.println("Response: " + response);
        assertEquals("{\"response\":\"OK " + Uris.VERSION + "\"}", response);
    }

    @Test
    public void testEcho() {
        // Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "toooken");

        // Params
        MultiValueMap<String, String> params = new HttpHeaders();
        params.add("param", "paaaaram");
        params.add("other", "ooooother");

        // Uri
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.ECHO).path(Uris.ID).queryParams(params)
                .buildAndExpand(666).encode().toUri();
        System.out.println("URI: " + uri);

        RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        String response = new RestTemplate().exchange(requestEntity, String.class).getBody();
        System.out.println("Response: " + response);
        assertEquals("{\"id\":666,\"token\":\"toooken\",\"param\":\"paaaaram\"}", response);
    }

 
    @Test
    public void testBodyStringList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.BODY).path(Uris.STRING_LIST).build().encode()
                .toUri();
        String json = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class).getBody();
        System.out.println(json);
        List<String> response = Arrays.asList(new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()),
                String[].class).getBody());
        System.out.println(response);
    }

}
