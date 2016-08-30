package io.trackit.repository;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlConfigRepository extends JpaRepository<UrlConfig, Long> {
    List<UrlConfig> findByTrackitUser(TrackitUser trackitUser);
}