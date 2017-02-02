package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{

}
