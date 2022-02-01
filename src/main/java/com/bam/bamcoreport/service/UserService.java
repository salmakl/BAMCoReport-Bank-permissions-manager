package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.dto.services.MapDto;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapDto<Users, UserDto> userMapping;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  /*  @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user=userRepository.findByUsername(username);
        if (user == null){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        else{
            log.info("user found {}",username);
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),user.get().getPassword(),authorities);
    }*/

    public List<UserDto> getUsers() {
        List<Users> users= userRepository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public Users newUser(Users user) {
        Optional<Users> username = userRepository.findByUsername(user.getUsername());
        if (username.isPresent()) {
            log.error("username taken");
            throw new IllegalStateException("username taken");
        }
       return userRepository.save(user);

    }

    public void deleteUser(Long userId) {

        boolean exists =  userRepository.existsById(userId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        userRepository.deleteById(userId);

    }


}
