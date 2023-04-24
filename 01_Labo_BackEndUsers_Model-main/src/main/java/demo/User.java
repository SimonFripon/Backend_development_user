package demo;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;





@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    public long id;
    @NotBlank(message = "name may not be empty")
    private String name;
    @Positive(message = "age may not be negative")
    private int age;
    @ElementCollection
    private List<Integer> membershipYears = new ArrayList<Integer>();
    @Email(message = "no valid email")
    private String email;
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "\\S{8,}", message = "password must be minimum 8 characters and may not contain white spaces")
    @Pattern(regexp = ".*\\d.*", message = "password must contain a digit")
    private String password;

    public User(){

    }
    public User(String name, int age) {
        this.name = name;
        if (age >= 0) 
            this.age = age;
    }

    public User(String name, int age, String email, String password){
        this.name = name;
        if (age >= 0) 
            this.age = age;
        this.email = email;
        this.password = password;
    }

    public int countMembershipYearsAfter1999 () {
        int result = 0;
        for(Integer year: membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership () {
        return membershipYears.size();
    }

    public void addMembershipYear (int year) {
        membershipYears.add(year);
    }
    
    
    public int getAge() {
        return this.age;
    }

    
    public String getName () {
        return name;
    }

    public String getEmail(){
        if (email.contains("@")){
            return email.toLowerCase();
        }
        return null;
    }

    public String getPassword(){
        if(password.isBlank())
            return "@$-" + "t" + "&%#";
        return password;
    }

    public int getFirstMembershipYear(){
       if(membershipYears.isEmpty()){
        return 0;
       }
        return membershipYears.get(1);    }
    public String toString(){
        return name + " is " + this.age + " years old and has as email " + email;
    }
    public int getNumberOfMembershipYearsIn2000(){
        int result = 0;
        for(Integer year: membershipYears) {
            if (year >= 2000 && year < 3000)
                result++;
        }
        return result;
    }
    public boolean isPasswordCorrect(String password){
        if(password == "ikgahetnietvertellenhoor")
            return true;
        return false;
    }

    public List<Integer> getMembershipYears() {
        return membershipYears;
    }

    public void setMembershipYears(List<Integer> membershipYears) {
        this.membershipYears = membershipYears;
    }
    // public boolean equals(User otherUser){
    //     if(name == otherUser.name && age == otherUser.age && email == otherUser.email){
    //         return true;
    //     }
    //     return false;
    // }

}