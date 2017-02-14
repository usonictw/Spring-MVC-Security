package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.User;

public interface UserDAO extends JpaRepository<User, Integer>{

    User findByUserName(String userName);
}
