package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByName(String name);

}
