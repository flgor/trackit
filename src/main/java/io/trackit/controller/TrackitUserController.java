package io.trackit.controller;


import io.trackit.domain.TrackitUser;
import io.trackit.dto.CreateTrackitUserDto;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trackitUser")
public class TrackitUserController {


    @Autowired
    private TrackitUserRepository trackitUserRepository;

    @PostMapping
    public void createTrackitUser(@RequestBody CreateTrackitUserDto createTrackitUserDto) {
        TrackitUser trackitUser = new TrackitUser();

        trackitUser.setEmail(createTrackitUserDto.getEmail());
        trackitUser.setUserName(createTrackitUserDto.getUserName());
        trackitUserRepository.save(trackitUser);
    }
}

