package elliott.software.RuralSoftware.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Calf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    public Date getDateBorn(){return this.dateBorn;}
    public int getWeight(){return this.weight;}

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

    //
}
