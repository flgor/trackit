package io.trackit.repository;

import io.trackit.domain.TrackitUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackitUserRepository extends JpaRepository<TrackitUser, Long> {
    TrackitUser findByUserName(String userName);
}
