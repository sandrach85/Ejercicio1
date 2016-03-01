package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.PersonaEntity;

public interface PersonaDao  extends JpaRepository<PersonaEntity, Integer>{

}
