package io.trackit.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TrackitUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    private String email;

    @OneToMany(mappedBy = "trackitUser", cascade = CascadeType.REMOVE)
    private Set<UrlConfig> urlConfigs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
