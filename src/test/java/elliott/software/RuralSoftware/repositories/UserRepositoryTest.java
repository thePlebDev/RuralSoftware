package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Authority;
import elliott.software.RuralSoftware.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void userCreationTest(){
        //GIVEN
        String EXPECTED_USERNAME = "bob";
        User user = new User(EXPECTED_USERNAME,"meat@ball.com","fdsafda");


        //WHEN
        userRepository.save(user);
       User foundUser = userRepository.findById(1L).get();

        //THEN
        assertThat(foundUser.getUsername()).isEqualTo(EXPECTED_USERNAME);

    }

    @Test
    public void findByAuthorityTest(){
        //GIVEN
        String EXPECTED_USERNAME = "bob";
        String AUTH_TITLE = "READ";
        User user = new User(EXPECTED_USERNAME,"meat@ball.com","fdsafda");
        Authority auth = new Authority(AUTH_TITLE);

        //WHEN
        authorityRepository.save(auth);
        Authority foundAuth = authorityRepository.findByTitle(AUTH_TITLE).get();

        user.addAuth(foundAuth);
        userRepository.save(user);

        List<User> readUsers = userRepository.findByAuthorities(foundAuth);

        assertThat(readUsers.size()).isEqualTo(1);



    }

}
