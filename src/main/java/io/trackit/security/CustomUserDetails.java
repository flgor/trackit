package io.trackit.security;

import io.trackit.domain.TrackitUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class CustomUserDetails extends TrackitUser implements UserDetails{

    public CustomUserDetails(TrackitUser trackitUser){
        super(trackitUser);
    }



    @Override
    public Collection getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public boolean isAccountNonExpiered() {
        return false;
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
