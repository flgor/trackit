package io.trackit.repository;

import io.trackit.domain.TrackitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackitUserRepository extends JpaRepository<TrackitUser, Long> {
    TrackitUser findByUserName(String userName);

    TrackitUser findById(Long id);
}
