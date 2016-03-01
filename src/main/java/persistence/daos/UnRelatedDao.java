package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer> {


}
