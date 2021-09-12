package pl.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.springboot.example.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{


}
