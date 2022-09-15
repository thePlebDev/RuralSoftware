package elliott.software.RuralSoftware.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "users")//todo: hashCode and equals
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<Authority>();

    public User(){
    }
    public User(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }


    //GETTERS
    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public Long getId(){
        return this.id;
    }
    public Set<Authority> getAuthorities(){
        return this.authorities;
    }

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setId(Long id){
        this.id = id;
    }

    //UTILITY
    public void addAuth(Authority auth){
        this.authorities.add(auth);
        auth.getUsers().add(this);
    }
    public void removeAuth(Authority auth){
        this.authorities.remove(auth);
        auth.getUsers().remove(this);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(username, other.getUsername());
    }
}
