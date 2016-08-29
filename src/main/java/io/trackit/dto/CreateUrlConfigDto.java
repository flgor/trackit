package io.trackit.dto;

import io.trackit.domain.TrackitUser;

public class CreateUrlConfigDto {
    private String url;
    private TrackitUser trackitUser;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrackitUser getTrackitUser() {
        return trackitUser;
    }

    public void setTrackitUser(TrackitUser trackitUser) {
        this.trackitUser = trackitUser;
    }
}
