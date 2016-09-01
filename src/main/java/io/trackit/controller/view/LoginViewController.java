package io.trackit.controller.view;

import io.trackit.domain.TrackitUser;
import io.trackit.dto.CreateTrackitUserDto;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/view/login")
public class LoginViewController extends WebMvcConfigurerAdapter{

    @Autowired
    TrackitUserRepository trackitUserRepository;

    @GetMapping
    public String displayLoginPage(Model model){
        CreateTrackitUserDto createTrackitUserDto = new CreateTrackitUserDto();
        model.addAttribute("createTrackitUserDto", createTrackitUserDto);
        return "login";
    }

    @PostMapping
    @GetMapping
    public String login (@ModelAttribute CreateTrackitUserDto createTrackitUserDto, ModelMap modelMap){
        TrackitUser trackitUser = trackitUserRepository.findByUserName(createTrackitUserDto.getUserName());
        return "redirect:/view/configs?userId="+trackitUser.getId();
    }
}
