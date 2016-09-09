package io.trackit.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class TrackitUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    private String email;

    @Size(min = 4, max = 20)
    private String password;

    public TrackitUser(TrackitUser trackitUser) {
        this.userName = trackitUser.getUserName();
        this.password = trackitUser.getPassword();
        this.email = trackitUser.getEmail();
        this.urlConfigs = trackitUser.getUrlConfigs();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Set<UrlConfig> getUrlConfigs() {
        return urlConfigs;
    }

    public void setUrlConfigs(Set<UrlConfig> urlConfigs) {
        this.urlConfigs = urlConfigs;
    }
}
