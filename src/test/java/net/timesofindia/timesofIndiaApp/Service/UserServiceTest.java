package net.timesofindia.timesofIndiaApp.Service;
import net.timesofindia.timesofIndiaApp.Entity.User;
import net.timesofindia.timesofIndiaApp.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testAdd(User user ){
        assertTrue(userService.createUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "3,3,6",
            "4,4,8"
    })
    public void test(int a , int b , int expected){
        assertEquals(expected , a + b);
    }
}
