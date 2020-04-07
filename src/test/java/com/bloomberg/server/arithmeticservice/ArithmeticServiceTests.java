package com.bloomberg.server.arithmeticservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
public class ArithmeticServiceTests {


        @Autowired
        private WebTestClient webClient;

        @Test
        void contextLoads() throws Exception {
            //Stubs
            stubFor(get(urlEqualTo("/operation"))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")));

            webClient
                    .post().uri("/operation")
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody();
                    //.jsonPath("$.headers.Hello").isEqualTo("World");
        }

        @Test
        void When_DelayedHttpBinDependency_Then_CallFallback() {
            stubFor(get(urlEqualTo("/delay/3"))
                    .willReturn(aResponse()
                            .withBody("no fallback")
                            .withFixedDelay(3000)));

            webClient
                    .get().uri("/delay/3")
                    .header("Host", "www.hystrix.com")
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .consumeWith(
                            response -> assertThat(new String(response.getResponseBody(), StandardCharsets.UTF_8))
                                    .isEqualTo("fallback requested!!!!"));
        }


}*/
