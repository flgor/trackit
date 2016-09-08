package io.trackit.services.delete;

import io.trackit.repository.TrackitUserRepository;
import io.trackit.repository.UrlConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DeleteOneUser {
    @Autowired
    protected TrackitUserRepository trackitUserRepository;

    @Autowired
    protected UrlConfigRepository urlConfigRepository;

    abstract void deleteUserById(Long id);
    abstract void deleteUserByName(String userName);
}