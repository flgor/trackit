package io.trackit.domain;

import javax.persistence.*;

@Entity
public class UrlConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private TrackitUser trackitUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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