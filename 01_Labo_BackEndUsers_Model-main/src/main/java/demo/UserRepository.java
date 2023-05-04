package demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    public List<User> findUsersByAgeAfter(int age);
    public User findUserByEmail(String email);
    public User findUserByName(String name);
	public List<User> findAllByMembershipYearsContaining(int year);
	public List<User> findByAgeBetween(int min, int max);
	public List<User> findByEmailAndAge(String email, int age);
	public List<User> findAllByOrderByAgeDesc();

}
