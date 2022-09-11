package com.memrevatan.security.jwt;

import com.memrevatan.data.entity.UserEntity;
import com.memrevatan.data.repository.UserRepository;
import com.memrevatan.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Log4j2
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);

        if(user == null){
            log.error("Böyle bir kullanici yoktur.");
            throw new UsernameNotFoundException("Boyle bir kullanici yoktur. " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
    }

    //bcryptEncoder ==> password mask
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(userDto.getPassword());
        return userRepository.save(userEntity);
    }
}
