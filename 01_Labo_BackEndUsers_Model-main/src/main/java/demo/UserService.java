package demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() { }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) throws ServiceException{
        List<User> users = userRepository.findUsersByAgeAfter(age);
        if (users.isEmpty()) {
            throw new ServiceException("users", "no users with age " + age + " found");
        }
        return users;
    }


    public User getOldestUser() throws ServiceException{
        List<User> users = userRepository.findAllByOrderByAgeDesc();
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }else{
            throw new ServiceException("users", "no oldest user found");
        }
    }

    public User getUserWithName(String name) {
        return userRepository.findUserByName(name);
    }

    public User addUser(User user) throws ServiceException {
        if (getUserWithEmail(user.getEmail()) != null)
            throw new ServiceException("email", "email already taken");
        userRepository.save(user);
        return user;
    }

    public User getUserWithEmail(String email) throws ServiceException{
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new ServiceException("user", "no user found with email: " + email);
        }
        return user;
    }

    public User removeUser(String email) throws ServiceException{
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            userRepository.delete(user);
            return user;
        } else {
            throw new ServiceException("user", "user with this email does not exist");
        }
    }
    
    public List<User> getUsersByMembershipYear(int year) {
        return userRepository.findAllByMembershipYearsContaining(year);
    }

    public List<User> getUsersWithAgeBetween(int min, int max){
        return userRepository.findByAgeBetween(min, max);
    }
    
    public List<User> getUserWithEmailandAge(String email, int age){
        return userRepository.findByEmailAndAge(email, age);
    }

    
}
