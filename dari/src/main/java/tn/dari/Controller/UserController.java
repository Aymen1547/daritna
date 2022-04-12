package tn.dari.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.Model.User;
import tn.dari.Service.UserService;

@RestController
@RequestMapping(path = {"/user"})
public class UserController {
@Autowired
UserService userService;

@PostMapping("/register")
public @ResponseBody ResponseEntity<User> register(@RequestBody User userData) throws Exception {
   return userService.register( userData);
    
}

@PostMapping("/changepassword/{id}") 
public @ResponseBody ResponseEntity<String> updatePassword(@PathVariable long id,@RequestBody String password) throws Exception {
    return userService.updatePassword( id,password);
     
 }

 @PutMapping("/update") 
public @ResponseBody ResponseEntity<User> update(@RequestBody User userData) throws Exception {
    return userService.updateUser( userData);
     
 }

@GetMapping("/get")
public @ResponseBody List<User> find() throws Exception {
   return userService.findAll( );
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable long id){

    return userService.deleteUser(id);
}

}
