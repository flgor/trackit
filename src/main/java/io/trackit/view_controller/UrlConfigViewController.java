package io.trackit.view_controller;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.repository.TrackitUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Set;

@Controller
public class UrlConfigViewController extends WebMvcConfigurerAdapter {

    @Autowired
    TrackitUserRepository trackitUserRepository;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @GetMapping
    public String createUrlConfigViewController(@PathVariable Long userId, ModelMap modelMap) {
        TrackitUser trackitUser = trackitUserRepository.findById(userId);
        Set<UrlConfig> urlConfigs = trackitUser.getUrlConfigs();
        modelMap.addAttribute("urlConfigs", urlConfigs);
        return "urlconfig_view";
    }

}
