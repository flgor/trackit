package io.trackit.helper;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;

public class TrackitUserCreator {

    private final String userName;
    private final String password;

    private final TrackitUserRepository trackitUserRepository;

    public TrackitUserCreator(String userName, String password, TrackitUserRepository trackitUserRepository) {
        this.userName = userName;
        this.password = password;
        this.trackitUserRepository = trackitUserRepository;
    }

    public TrackitUser create() {
        TrackitUser trackitUser = new TrackitUser();
        trackitUser.setUserName(userName);
        trackitUser.setPassword(password);
        return trackitUserRepository.saveAndFlush(trackitUser);
    }


}