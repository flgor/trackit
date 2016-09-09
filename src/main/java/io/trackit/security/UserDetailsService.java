package io.trackit.security;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;
import org.codehaus.groovy.transform.tailrec.TailRecursiveASTTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService {

    @Autowired
    TrackitUserRepository trackitUserRepository;

    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        TrackitUser trackitUser = trackitUserRepository.findByUserName(username);
        if(trackitUser == null){
            throw new UsernameNotFoundException("This username does not exist");
        }

        return (UserDetails) new CustomUserDetails(trackitUser);
    }
}