package io.trackit.services.delete;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.services.delete.DeleteOneUser;

import java.util.List;

abstract class DeleteUserById extends DeleteOneUser {
    @Override
    void deleteUserById(Long id) {
        TrackitUser trackitUser = trackitUserRepository.findById(id);
        List<UrlConfig> urlConfigs = urlConfigRepository.findByTrackitUser(trackitUser);
        for(UrlConfig urlConfig : urlConfigs){
            urlConfigRepository.delete(urlConfig);
        }
        trackitUserRepository.delete(trackitUser);
    }
}