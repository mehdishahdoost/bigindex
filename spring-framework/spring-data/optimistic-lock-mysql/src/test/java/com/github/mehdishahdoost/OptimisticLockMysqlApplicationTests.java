package com.github.mehdishahdoost;

import com.github.mehdishahdoost.controller.CommentRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Slf4j
@SpringBootTest(classes = OptimisticLockMysqlApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OptimisticLockMysqlApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int randomPort;

    @Test
    public void testLock() {
        String url = "http://localhost:" + randomPort + "/comment";
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                log.info("run");
                CommentRequest commentRequest = new CommentRequest(1, "salam");
                testRestTemplate.postForEntity(url, commentRequest, String.class);

            }).run();
        }
    }

}
