package tn.dari.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.dari.Repository.UserRepository;
import tn.dari.Model.User;

@Service
public class UserService {
    

    @Autowired 
    UserRepository userRepo ;

public User getUser(Long id){
    Optional<User> user = userRepo.findById(id);
    if(user.isPresent()){
        user.get().setPassword(null);
        return user.get();
    }else{
        System.out.println("not found");
        return null;
    }
}


public List<User> findAll(){
    List<User> x = userRepo.findAll();
    for (User a : x) {
        a.setPassword(null);
    }

    return x;
}

public ResponseEntity<User> register(User user)
            throws Exception {

            User newUser = new User( null,user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),user.getPassword() ,
            user.getJoinDate(), LocalDate.now(), LocalDate.now(), user.getRole(), user.isNotLocked());

            userRepo.save(newUser);
            return new ResponseEntity<User>( newUser,HttpStatus.OK);

    }

    public ResponseEntity<String> updatePassword(Long id,String newPassword)
    throws Exception {
    User oldUser = this.getUser(id);

     oldUser.setPassword(newPassword);

    userRepo.save(oldUser);
    return new ResponseEntity<String>("ok",HttpStatus.OK);

}

    public ResponseEntity<User> updateUser(User user)
            throws Exception {
                System.out.print(user.getUserId());
            User oldUser = this.getUser(user.getId());

             oldUser = new User(user.getUserId(),user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),oldUser.getPassword() ,
             user.getJoinDate(), LocalDate.now(), LocalDate.now(), user.getRole(), true);

            userRepo.save(oldUser);
            return new ResponseEntity<User>( oldUser,HttpStatus.OK);

    }


    public ResponseEntity<String> deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return new ResponseEntity<String>( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>( HttpStatus.CONFLICT);
        }

    }
}
