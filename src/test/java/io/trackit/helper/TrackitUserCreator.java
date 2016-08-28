package io.trackit.helper;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;

public class TrackitUserCreator {

    private final String userName;

    private final TrackitUserRepository trackitUserRepository;

    public TrackitUserCreator(String userName, TrackitUserRepository trackitUserRepository) {
        this.userName = userName;
        this.trackitUserRepository = trackitUserRepository;
    }

    public TrackitUser create() {
        TrackitUser trackitUser = new TrackitUser();
        trackitUser.setUserName(userName);
        return trackitUserRepository.saveAndFlush(trackitUser);
    }


}