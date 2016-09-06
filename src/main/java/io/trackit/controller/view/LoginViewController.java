package io.trackit.controller.view;

import io.trackit.domain.TrackitUser;
import io.trackit.dto.CreateTrackitUserDto;
import io.trackit.dto.LoginDto;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/view/login")
public class LoginViewController {

    @Autowired
    TrackitUserRepository trackitUserRepository;

    @GetMapping
    public String displayLoginPage(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping
    @GetMapping
    public String login(@ModelAttribute LoginDto loginDto, ModelMap modelMap) {
        TrackitUser trackitUser = trackitUserRepository.findByUserName(loginDto.getUserName());
        if(loginDto.getPassword().equals(trackitUser.getPassword())){
            return "redirect:/view/configs?userId=" + trackitUser.getId();
        } else {
            return "home";
        }
    }
}
