package restApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.SERVLET_MAP +Uris.ADMINS)
public class PruebaResource {
   
    @RequestMapping(value = Uris.DIVISION , method = RequestMethod.GET)
    public String echo(@RequestParam(value = "dividendo" , required= true) int param1,@RequestParam(value = "divisor" , required= true) int param2) {
        return ""+(double)param1/param2;
    }
    
    @RequestMapping(value = Uris.FRACCION, method = RequestMethod.POST)
    public double body(@RequestBody Fraccion fraccion) {
        return fraccion.getNumerador()/fraccion.getDenomnador();
    }
    
    @RequestMapping(value = Uris.CALCULADORA3, method = RequestMethod.POST)
    public List<Double> bodyFraccionList(@RequestBody List<Fraccion> fracciones) {
       ArrayList<Double> resul = new ArrayList<Double>();
       for (int i =0; i<fracciones.size(); i++){
    	   double r= fracciones.get(i).getNumerador()/fracciones.get(i).getDenomnador();
    	   resul.add(r);
       }
        return resul;
    }
}

