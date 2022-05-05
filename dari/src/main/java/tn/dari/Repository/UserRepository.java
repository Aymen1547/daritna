package tn.dari.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.Model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
