package persistence.daos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistence.entities.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer> {

	List<UnRelatedEntity> findByNickIgnoreCase(String nick);
	
	UnRelatedEntity findById(int id);
	
	
	//Paginacion
	List<UnRelatedEntity> findByIdGreaterThan(int id, Pageable pageable);
	
	//JPQL
	@Query("select u from other_name_for_unrelatedentity u")
	List<UnRelatedEntity> findAll();
	
	//SQL
	@Query(value="SELECT * FROM other_name_for_unrelatedentity", nativeQuery=true)
	List<UnRelatedEntity> findAllSQL();
	
}
