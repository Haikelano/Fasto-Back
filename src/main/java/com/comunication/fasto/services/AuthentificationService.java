package com.comunication.fasto.services;

import com.comunication.fasto.model.Collections;
import com.comunication.fasto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Arrays;
import javax.transaction.Transactional;
@Service
public class AuthentificationService implements UserDetailsService {
    @Autowired
   private UsersRepository usersRepository;


    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Collections collections = usersRepository.findByUsername(username);

   if(collections == null){
       throw new UsernameNotFoundException("User not found");
   }
   List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
   return new org.springframework.security.core.userdetails.User(collections.getUsername(), collections.getPassword(), authorities);
    /*return UserPrincipal.build(collections);*/
    }



}