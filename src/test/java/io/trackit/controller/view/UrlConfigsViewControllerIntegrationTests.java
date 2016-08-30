package io.trackit.controller.view;

import io.trackit.ApplicationTests;
import io.trackit.domain.TrackitUser;
import io.trackit.helper.TrackitUserCreator;
import io.trackit.repository.TrackitUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UrlConfigsViewControllerIntegrationTests extends ApplicationTests {

    private TrackitUser trackitUser;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TrackitUserRepository trackitUserRepository;

    @Before
    public void setUp() {
        trackitUserRepository.deleteAll();
        trackitUser = new TrackitUserCreator("userName", trackitUserRepository).create();
    }

    @Test
    public void getUrlConfigsView() throws Exception {
        mvc.perform(get("/view/configs?userId=" + trackitUser.getId())
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());
    }
}
