package io.trackit.services.delete;

import io.trackit.domain.TrackitUser;

abstract class DeleteUserByName extends DeleteOneUser{
    @Override
    void deleteUserByName(String userName) {
       TrackitUser trackitUser = trackitUserRepository.findByUserName(userName);
        deleteUserById(trackitUser.getId());
    }
}