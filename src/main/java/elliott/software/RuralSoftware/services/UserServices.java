package elliott.software.RuralSoftware.services;

import elliott.software.RuralSoftware.models.Authority;
import elliott.software.RuralSoftware.models.User;
import elliott.software.RuralSoftware.repositories.AuthorityRepository;
import elliott.software.RuralSoftware.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserServices(UserRepository userRepository,
                        BCryptPasswordEncoder passwordEncoder,
                        AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    public void createBasicUser(User user){

        user.setPassword(encryptPassword(user.getPassword()));
        user.addAuth(getReadAuthority());

        userRepository.save(user);
    }

    //UTILITY METHODS BELOW
    //TODO:NEED TO HANDLE THE NULL CASE
    private Authority getReadAuthority(){
        return authorityRepository.findByTitle("READ").get();
    }
    private String encryptPassword(String oldPassword){
        return this.passwordEncoder.encode(oldPassword);
    }
}
