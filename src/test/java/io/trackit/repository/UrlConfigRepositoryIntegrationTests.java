package io.trackit.repository;

import com.google.common.collect.Iterables;
import io.trackit.domain.UrlConfig;
import io.trackit.helper.UrlConfigCreator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlConfigRepositoryIntegrationTests extends TrackitUserRepositoryIntegrationTests {

    public static final String TEST_URL = "testUrl";

    @Autowired
    private UrlConfigRepository urlConfigRepository;

    @Before
    public void setUp() throws Exception {
        urlConfigRepository.deleteAll();
        super.setUp();
    }

    @Test
    public void getUrlConfigByUser() {
        new UrlConfigCreator(trackitUser, TEST_URL, urlConfigRepository).create();

        List<UrlConfig> urlConfigs = urlConfigRepository.findByTrackitUser(trackitUser);
        assertThat(urlConfigs).hasSize(1);

        UrlConfig urlConfig = Iterables.getOnlyElement(urlConfigs);
        assertThat(urlConfig.getUrl()).isEqualTo(TEST_URL);
    }

    @Test(expected = ConstraintViolationException.class)
    public void createUrlConfigWithNoUser() {
        UrlConfig urlConfig = new UrlConfig();
        urlConfig.setUrl(TEST_URL);
        urlConfigRepository.save(urlConfig);
    }
}
