package sellhancommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sellhancommerce.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
	public User findByUsername(String username);
}

