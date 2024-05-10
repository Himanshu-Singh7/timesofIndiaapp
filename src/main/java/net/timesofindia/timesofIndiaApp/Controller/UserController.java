package net.timesofindia.timesofIndiaApp.Controller;
import net.timesofindia.timesofIndiaApp.Entity.User;
import net.timesofindia.timesofIndiaApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserService userService;


   @GetMapping
   public ResponseEntity<?> getAllUser(){
       List<User> allUser = userService.getAll();
       if(allUser != null && !allUser.isEmpty()){
           return new ResponseEntity<>(allUser , HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping("/save")
   public ResponseEntity<User> createUser(@RequestBody User user){
       try {
           userService.createUser(user);
           return new ResponseEntity<>(user,HttpStatus.CREATED);
       }catch (Exception e){

           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }

  @GetMapping("/userId/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable Long userId){
      Optional<User> userById = userService.findById(userId);

      if(userById.isPresent()){
          return new ResponseEntity<>(userById.get(), HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  @DeleteMapping("/userId/{userId}")
  public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
      userService.deleteById(userId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


  @PutMapping("/{userName}")
  public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
      User byUserName = userService.findByUserName(userName);
      if(byUserName != null){
          byUserName.setUserName(user.getUserName());
          byUserName.setPassword(user.getPassword());
          userService.createUser(byUserName);
          return new ResponseEntity<>(byUserName, HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
