package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// User bert = new User("Bert", 20, "bert@ucll.be", "abc");
 		// bert.addMembershipYear(2000);
		// User bertII = new User("Bert", 20, "bert@ucll.be", "abc");
		// bertII.addMembershipYear(2001);
 		// User bertIII = new User("Bert", 20, "bert@ucll.be", "xyz");
 		// bertIII.addMembershipYear(2003);
 		// User chris = new User("Chris", 20, "bert@ucll.be", "abc");
 		// chris.addMembershipYear(2000);
 		// System.out.println(bert.equals(bertII)); // returns true
 		// System.out.println(bert.equals(bertIII)); // returns true
 		// System.out.println(bert.equals(chris)); // returns false
	}

}