package demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() throws ServiceException{
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) throws ServiceException{
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

    @GetMapping("/adults")
    public List<User> getAdultUser() throws ServiceException{
        return userService.getUsersWithAgeOlderThan(17);
    }

    @GetMapping("/search/email/{email}")
    public User searchUserWithEmail(@PathVariable("email") String email) throws ServiceException{
        return userService.getUserWithEmail(email);
    }

    @GetMapping("/search/email")
    public List<User> searchUserWithEmailAndAge(@RequestParam("email") String email, @RequestParam("age") int age){
        return userService.getUserWithEmailandAge(email, age);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> SearchUserWithAgeBetweenMinMax(@PathVariable("min") int min, @PathVariable("max") int max){
        return userService.getUsersWithAgeBetween(min, max);
    }

    @GetMapping("/search/year/{year}")
    public List<User> searchUsersInAgivenYear(@PathVariable("year") int year){
        return userService.getUsersByMembershipYear(year);
    }
    @DeleteMapping("/users/{email}")
    public ResponseEntity<User> deleteUserByEmail(@PathVariable String email)  throws ServiceException{
        User deletedUser = userService.removeUser(email);
        if (deletedUser != null) {
            return ResponseEntity.ok(deletedUser);
        } else {
            return ResponseEntity.ok().build();
        }
    }
}


