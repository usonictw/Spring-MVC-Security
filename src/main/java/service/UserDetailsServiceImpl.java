package service;

import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import pojo.Role;
import pojo.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService}
 * @author Vladimir Mishchenko
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUserName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (Role r : user.getRoleSet()){
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                grantedAuthorities);
    }
}
