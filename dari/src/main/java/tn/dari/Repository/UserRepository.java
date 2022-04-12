package tn.dari.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.Model.User;




@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    
}