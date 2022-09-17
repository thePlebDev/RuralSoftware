package elliott.software.RuralSoftware.products.services;

import elliott.software.RuralSoftware.models.Calf;
import elliott.software.RuralSoftware.repositories.CalfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalfService {

    private CalfRepository calfRepository;


    @Autowired
    public CalfService(CalfRepository calfRepository){
        this.calfRepository = calfRepository;
    }



    public List<Calf> getAllCalves(){
        return this.calfRepository.findAll();
    }
}
