package io.trackit.controller;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.dto.CreateTrackitUserDto;
import io.trackit.dto.CreateUrlConfigDto;
import io.trackit.repository.UrlConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urlConfig")
public class UrlConfigController {

    @Autowired
    private UrlConfigRepository urlConfigRepository;

    @PostMapping
    public void createTrackitUser(@RequestBody CreateUrlConfigDto createUrlConfigDto){
        UrlConfig urlConfig = new UrlConfig();
        urlConfig.setTrackitUser(createUrlConfigDto.getTrackitUser());
        urlConfig.setUrl(createUrlConfigDto.getUrl());
        urlConfigRepository.save(urlConfig);
    }
}
