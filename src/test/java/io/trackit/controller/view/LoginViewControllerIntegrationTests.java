package io.trackit.controller.view;

import io.trackit.ApplicationTests;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginViewControllerIntegrationTests extends ApplicationTests {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void getLoginView() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/view/login", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
