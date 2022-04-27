package tn.dari.Service;

import tn.dari.Model.User;
import tn.dari.Exception.domain.EmailExistException;
import tn.dari.Exception.domain.UserNotFoundException;
import tn.dari.Exception.domain.UsernameExistException;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}

