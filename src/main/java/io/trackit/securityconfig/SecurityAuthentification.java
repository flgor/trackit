package io.trackit.securityconfig;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class SecurityAuthentification implements UserDetailsService{
    @Autowired
    TrackitUserRepository trackitUserRepository;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TrackitUser trackitUser = trackitUserRepository.findByUserName(userName);
        if(trackitUser == null){
            throw new UsernameNotFoundException("Could not find user" + userName);
        }
        return new CustomUserDetails(trackitUser);
    }

    private final static class CustomUserDetails extends TrackitUser implements UserDetails {

        private CustomUserDetails(TrackitUser trackitUser){
            super(trackitUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getUsername() {
            return getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
