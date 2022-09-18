package elliott.software.RuralSoftware.products.services;

import elliott.software.RuralSoftware.models.Calf;
import elliott.software.RuralSoftware.models.User;
import elliott.software.RuralSoftware.repositories.CalfRepository;
import elliott.software.RuralSoftware.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalfService {

    private CalfRepository calfRepository;
    private UserRepository userRepository;


    @Autowired
    public CalfService(CalfRepository calfRepository, UserRepository userRepository){
        this.calfRepository = calfRepository;
        this.userRepository = userRepository;
    }



    public List<Calf> getAllCalvesByUser(String username){
        User foundUser = userRepository.findByUsername(username).get();
        return this.calfRepository.findByUser(foundUser);
    }


    public Calf saveCalf(Calf calf, String username){
        User foundUser = this.userRepository.findByUsername(username).get();
        calf.setDateBorn(new Date());
        foundUser.addCalf(calf);
        calf.setUser(foundUser);
        calfRepository.save(calf);
        return calf;
    }
}
