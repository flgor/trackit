package io.trackit.controller.view;

import io.trackit.ApplicationTests;
import io.trackit.domain.TrackitUser;
import io.trackit.helper.TrackitUserCreator;
import io.trackit.repository.TrackitUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlConfigsViewControllerIntegrationTests extends ApplicationTests {

    private TrackitUser trackitUser;
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private TrackitUserRepository trackitUserRepository;

    @Before
    public void setUp() {
        trackitUserRepository.deleteAll();
        trackitUser = new TrackitUserCreator("userName", "password", trackitUserRepository).create();
    }

    @Test
    public void getUrlConfigsView() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/view/configs?userId=" + trackitUser.getId(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
