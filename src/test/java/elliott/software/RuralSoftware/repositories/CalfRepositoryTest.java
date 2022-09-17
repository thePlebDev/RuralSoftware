package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Calf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CalfRepositoryTest {

    @Autowired
    private CalfRepository calfRepository;


    @Test
    public void getAllCalvesTest(){
        //GIVEN
        int EXPECTED_SIZE = 3;
        Calf calf1 = new Calf();
        Calf calf2 = new Calf();
        Calf calf3 = new Calf();

        //WHEN
        calfRepository.save(calf1);
        calfRepository.save(calf2);
        calfRepository.save(calf3);

        List<Calf> allCalves = calfRepository.findAll();


        //THEN
        assertThat(allCalves.size()).isEqualTo(EXPECTED_SIZE);


    }
}
