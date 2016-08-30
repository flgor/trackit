package io.trackit.controller.rest;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.dto.CreateUrlConfigDto;
import io.trackit.repository.UrlConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        urlConfig.setUrl(createUrlConfigDto.getUrl());
        TrackitUser trackitUser = new TrackitUser();
        trackitUser.setId(createUrlConfigDto.getTrackitUserId());
        urlConfig.setTrackitUser(trackitUser);

        urlConfigRepository.save(urlConfig);
    }
}
