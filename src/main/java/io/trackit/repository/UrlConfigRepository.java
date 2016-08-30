package io.trackit.repository;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlConfigRepository extends JpaRepository<UrlConfig, Long> {
    List<UrlConfig> findByTrackitUser(TrackitUser trackitUser);
}