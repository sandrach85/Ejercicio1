package restApi;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import config.TestsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class PruebaResourceFuncionalTesting {

    private static final String URL_API = "http://localhost:8080/Ejercicio1.0.0.1-SNAPSHOT"  + Uris.SERVLET_MAP;


    
    @Test
    public void testEcho() {
        // Header
        HttpHeaders headers = new HttpHeaders();

        // Params
        MultiValueMap<String, String> params = new HttpHeaders();
        params.add("dividendo", "6");
        params.add("divisor", "3");

        // Uri
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.DIVISION).queryParams(params)
                .buildAndExpand().encode().toUri();
        System.out.println("URI: " + uri);

        RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        double response = new RestTemplate().exchange(requestEntity, double.class).getBody();
        System.out.println("Response: " + response);
        assertTrue(response==2.0);
    }
    
    @Test
    public void testBody(){
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.FRACCION).build().encode().toUri();
        Fraccion fraccion = new Fraccion(6, 3);
        
        RequestEntity<Fraccion> requestEntity = new RequestEntity<>(fraccion, HttpMethod.POST, uri);

        String json = new RestTemplate().exchange(requestEntity, String.class).getBody();
        System.out.println(json);
        double response = new RestTemplate().exchange(requestEntity, Double.class).getBody();
        System.out.println(response);
        assertTrue(response==2.0);
    }

    
    @Test
    public void testBodyWrapperList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.CALCULADORA3).build().encode().toUri();
        Fraccion fraccion1 = new Fraccion(6, 3);
        Fraccion fraccion2 = new Fraccion(6, 3);
        Fraccion fraccion3 = new Fraccion(6, 3);
 
        RequestEntity<List<Fraccion>> requestEntity = new RequestEntity<>(Arrays.asList(fraccion1,fraccion2,fraccion3), HttpMethod.POST, uri);
        List<Double> response = Arrays.asList(new RestTemplate().exchange(requestEntity, Double[].class).getBody());
        System.out.println(response);
    }
}
