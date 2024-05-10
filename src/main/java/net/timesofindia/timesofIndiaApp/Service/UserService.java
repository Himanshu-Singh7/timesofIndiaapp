package net.timesofindia.timesofIndiaApp.Service;

import net.timesofindia.timesofIndiaApp.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //Create
    boolean createUser(User user);
    // Get All User
    public List<User> getAll();
    // Get User  By Id
    public Optional<User> findById(Long userId);
    // Delete user
    public void deleteById(Long userId);
   // Find By Username For Update
    public User findByUserName(String userName);
}
