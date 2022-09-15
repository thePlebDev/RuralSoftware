package elliott.software.RuralSoftware.security.util;

import elliott.software.RuralSoftware.models.Authority;
import elliott.software.RuralSoftware.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public void run(String... args) throws Exception {
        this.authorityRepository.save(new Authority("READ"));
    }
}
