package net.timesofindia.timesofIndiaApp.Service.Impl;
import net.timesofindia.timesofIndiaApp.Entity.User;
import net.timesofindia.timesofIndiaApp.Repository.UserRepository;
import net.timesofindia.timesofIndiaApp.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public boolean createUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            logger.error("hjdsgfasffas");
            logger.warn("hjsfgasfasas");
            logger.info("hgjsdggasvd");
            logger.debug("hqgwfffsfghf");
            logger.debug("shgfsadasdd");
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
