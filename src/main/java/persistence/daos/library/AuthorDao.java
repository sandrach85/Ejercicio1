package persistence.daos.library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistence.entities.library.Author;
import persistence.entities.library.Style;

public interface AuthorDao extends JpaRepository<Author, Integer> {

	List<Author> findByStyle(Style style);
   
	@Query("select a.name from Author a where a.style.name= ?1")
	List<String> findNameByStyleName(String styleName);
	
	@Query("select distinct a.name from Book b join b.authorList a")
	List<String> findNameByAnyBook();
	
	@Query("select a.name from Book b join b.authorList a join b.themeList t where t.name = ?1")
	List<String> findNameByThemeName(String themeName);
}
