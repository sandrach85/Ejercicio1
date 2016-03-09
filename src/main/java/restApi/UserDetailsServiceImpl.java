package restApi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import persistence.daos.UserDao;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@PostConstruct
	public void poblate(){
		userDao.save(new persistence.entities.User("u2", "PLAYER"));
	}
	
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		if ("user".equals(username)) {
			return this.userBuilder(username, "123456", "USER");
		} else if ("u1".equals(username)) {
			return this.userBuilder(username, "123456", "PLAYER");
		} else if ("manager".equals(username)) {
			return this.userBuilder(username, "123456", "MANAGER");
		} else if ("admin".equals(username)) {
			return this.userBuilder(username, "123456", "USER", "MANAGER", "ADMIN");
		} else if(userDao.findByName(username).getName()!=null){
			return this.userBuilder(username, "123456",userDao.findByName(username).getRol());
		}else{
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

	private User userBuilder(String username, String password, String... roles) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return new User(username, new BCryptPasswordEncoder().encode("123456"), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}
}
