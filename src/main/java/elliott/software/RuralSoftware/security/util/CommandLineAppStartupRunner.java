package elliott.software.RuralSoftware.security.util;

import elliott.software.RuralSoftware.models.Authority;
import elliott.software.RuralSoftware.models.User;
import elliott.software.RuralSoftware.repositories.AuthorityRepository;
import elliott.software.RuralSoftware.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
         this.authorityRepository.save(new Authority("READ"));
        Authority foundAuth = authorityRepository.findByTitle("READ").get();
        User user = new User("bob","bob@bobamilc.om",passwordEncoder.encode("12345"));
        user.addAuth(foundAuth);
        userRepository.save(user);

    }
}
