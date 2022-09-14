package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AuthRepositoryTest {

    @Autowired
    AuthorityRepository underTest;

    @Test
    public void createAuthTest(){
        //GIVEN
        String EXPECTED_TITLE = "READ";
        Authority auth = new Authority(EXPECTED_TITLE);

        //WHEN
        underTest.save(auth);
        Authority foundAuthority = underTest.findById(1l).get();


        assertThat(foundAuthority.getTitle()).isEqualTo(EXPECTED_TITLE);

    }
}
