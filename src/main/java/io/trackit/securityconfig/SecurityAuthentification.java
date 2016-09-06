package io.trackit.securityconfig;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class SecurityAuthentification {
    @Autowired
    TrackitUserRepository trackitUserRepository;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

    }
}
