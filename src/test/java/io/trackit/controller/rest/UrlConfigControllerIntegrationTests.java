package io.trackit.controller.rest;

import com.google.common.collect.Iterables;
import io.trackit.ApplicationTests;
import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.dto.CreateUrlConfigDto;
import io.trackit.helper.TrackitUserCreator;
import io.trackit.repository.TrackitUserRepository;
import io.trackit.repository.UrlConfigRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UrlConfigControllerIntegrationTests extends ApplicationTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private TrackitUser trackitUser;

    @Autowired
    private UrlConfigRepository urlConfigRepository;

    @Autowired
    private TrackitUserRepository trackitUserRepository;

    @Before
    public void setUp() {
        trackitUserRepository.deleteAll();
        trackitUser = new TrackitUserCreator("userName", trackitUserRepository).create();
    }

    @Test
    public void createUrlConfig() throws Exception {
        CreateUrlConfigDto createUrlConfigDto = createCreateUrlConfigDto();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8080/urlConfig", createUrlConfigDto, null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<UrlConfig> urlConfigs = urlConfigRepository.findByTrackitUser(trackitUser);
        assertThat(urlConfigs).hasSize(1);

        UrlConfig actualUrlConfig = Iterables.getOnlyElement(urlConfigs);
        assertThat(actualUrlConfig.getUrl()).isEqualTo(createUrlConfigDto.getUrl());
    }

    private CreateUrlConfigDto createCreateUrlConfigDto() {
        CreateUrlConfigDto createUrlConfigDto = new CreateUrlConfigDto();
        createUrlConfigDto.setUrl("testUrl");
        createUrlConfigDto.setUrl("urlConfig");
        createUrlConfigDto.setTrackitUserId(trackitUser.getId());
        return createUrlConfigDto;
    }

}
