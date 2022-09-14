package elliott.software.RuralSoftware.security.services;

import elliott.software.RuralSoftware.models.User;
import elliott.software.RuralSoftware.repositories.UserRepository;
import elliott.software.RuralSoftware.security.models.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = ()-> new UsernameNotFoundException("Problem during authentication");
        User u = this.userRepository.findByUsername(username).orElseThrow(s);
        return new SecurityUser(u);
    }
}
