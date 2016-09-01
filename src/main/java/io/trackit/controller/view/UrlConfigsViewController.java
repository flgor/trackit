package io.trackit.controller.view;

import io.trackit.domain.TrackitUser;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/view/configs")
public class UrlConfigsViewController extends WebMvcConfigurerAdapter {

    @Autowired
    TrackitUserRepository trackitUserRepository;

    @GetMapping
    public String configsView(@RequestParam(name = "userId") Long userId, ModelMap modelMap) {
        TrackitUser trackitUser = trackitUserRepository.findById(userId);
        modelMap.addAttribute("urlConfigs", trackitUser.getUrlConfigs());
        return "url_configs";
    }
}
