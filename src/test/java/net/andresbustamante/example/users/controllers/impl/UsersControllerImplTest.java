package net.andresbustamante.example.users.controllers.impl;

import net.andresbustamante.example.users.UserType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UsersControllerImplTest {

    @Value("${test.server.url}")
    private String serverUrl;

    @Test
    void createUser() {
        UserType user = new UserType();
        user.setFirstName("John");
        user.setSurname("Doe");
        user.setEmail("john.doe@email.com");
        user.setPassword("changeit");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> response = restTemplate.postForEntity(serverUrl, user, Integer.class);

        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertTrue(response.getBody() > 0);
        assertNotNull(response.getHeaders().getLocation());
    }
}