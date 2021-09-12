package pl.springboot.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {

    private long id;
    private String name;

    public Set<User> user = new HashSet<User>();

    public Role() {

    }

    public Role(String name) {
        this.name = name;       
    }

    public Role(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL)
    @JsonBackReference(value= "roleId")
    public Set<User> getUser() {
        return user;
    }
    public void setUser(Set<User> user) {
        this.user = user;
    }
    

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }

}
