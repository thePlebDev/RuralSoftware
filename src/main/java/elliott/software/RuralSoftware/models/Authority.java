package elliott.software.RuralSoftware.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="AUTH_USER",
             joinColumns = @JoinColumn(name="AUTH_ID"),
             inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> users = new HashSet<>();

    public Authority(String title){
        this.title = title;
    }
    public Authority(){}


    //GETTERS
    public String getTitle(){
        return this.title;
    }
    public Set<User> getUsers(){
        return this.users;
    }
    public Long getId() {
        return id;
    }

    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }

    //UTILITY
    public void addUser(User user){
        this.users.add(user);
        user.getAuthorities().add(this);

    }
    public void removeUser(User user){
        this.users.remove(user);
        user.getAuthorities().remove(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Authority other = (Authority) obj;
        return Objects.equals(title, other.getTitle());
    }




}
