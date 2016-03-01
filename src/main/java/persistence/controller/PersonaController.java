package persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.PersonaDao;
import persistence.entities.CocheEntity;
import persistence.entities.PersonaEntity;

@Controller
public class PersonaController {
	
	@Autowired
	private PersonaDao personaDao;
	
	public void process()
	{
		CocheEntity coche = new CocheEntity ("M1234PP", "Renault");
		PersonaEntity persona = new PersonaEntity("Sandra", coche);
		personaDao.save(persona);
		
		System.out.println("CocheEntity" + personaDao.findOne(persona.getId()));
	}

}
