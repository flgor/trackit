package io.trackit.repository;

import io.trackit.ApplicationTests;
import io.trackit.domain.TrackitUser;
import io.trackit.helper.TrackitUserCreator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TrackitUserRepositoryIntegrationTests extends ApplicationTests {

    public static final String USER_NAME = "testUserName";

    protected TrackitUser trackitUser;

    @Autowired
    private TrackitUserRepository trackitUserRepository;

    @Before
    public void setUp() throws Exception {
        trackitUserRepository.deleteAll();
        trackitUser = new TrackitUserCreator(USER_NAME, trackitUserRepository).create();
    }

    @Test
    public void getUserByEmail() {
        TrackitUser user = trackitUserRepository.findByUserName(USER_NAME);
        assertThat(user.getUserName()).isEqualTo(USER_NAME);
    }
}
