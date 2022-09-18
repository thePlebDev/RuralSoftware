package elliott.software.RuralSoftware.models;



import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Calf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tagNumber;
    private String description;
    private String CCIANumber;
    private Date dateBorn;
    private int weight;
    @ManyToOne
    @JoinColumn
    private User user;

    @Enumerated(EnumType.STRING)
    private CalfStatus status;

    public Calf(){}
    public Calf(String tagNumber,String description,String CCIANumber,int weight,CalfStatus calfStatus){
        this.tagNumber = tagNumber;
        this.description = description;
        this.CCIANumber = CCIANumber;
        this.dateBorn = new Date();
        this.weight = weight;
        this.status = calfStatus;
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getDescription(){
        return this.description;
    }
    public String getTagNumber(){return this.tagNumber;}
    public String getCCIANumber(){return this.CCIANumber;}
    public String getDateBorn(){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(this.dateBorn);
        return date;
    }
    public int getWeight(){return this.weight;}
    public CalfStatus getStatus(){return this.status;}

    //SETTERS
    public void setTagNumber(String tagNumber){
        this.tagNumber = tagNumber;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCCIANumber(String CCIANumber){
        this.CCIANumber = CCIANumber;
    }
    public void setDateBorn(Date newDateBorn){
        this.dateBorn = newDateBorn;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setStatus(CalfStatus status){this.status = status;}
    public void setUser(User user){
        this.user = user;
    }

    //UTILITY

}
