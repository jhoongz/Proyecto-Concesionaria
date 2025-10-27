package com.example.Concesionaria.clients;

import com.example.Concesionaria.dtos.GetRandomUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class RandomUserClient {

    private final WebClient webClient;

    @Value("${baseUrlRandomUser}")
    private String randomUserUrl;

    public RandomUserClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(this.randomUserUrl).build();
    }

    public GetRandomUserResponse getRandomUsersByQuantity(Long value) {

        URI uri = UriComponentsBuilder
                .fromUriString("https://randomuser.me/api/")
                .queryParam("results", value)
                .queryParam("nat", "es")
                .build()
                .toUri();

        System.out.println("URI generada: " + uri);

        GetRandomUserResponse response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(GetRandomUserResponse.class)
                .block();

        if (response == null || response.getResults() == null) {
            return null;
        }
        return response;
    }
}


/*
@Component
public class RandomUserClient {

    private final WebClient webClient;

    // Inyectamos el valor en el constructor correctamente
    public RandomUserClient(WebClient.Builder builder,
                            @Value("${baseUrlRandomUser}") String randomUserUrl) {
        this.webClient = builder
                .baseUrl(randomUserUrl)
                .build();
    }

    public GetRandomUserResponse getRandomUsersByQuantity(Long value) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api") // 👈 importante, el endpoint correcto de randomuser.me
                        .queryParam("results", value)
                        .queryParam("nat", "es")
                        .build())
                .retrieve()
                .bodyToMono(GetRandomUserResponse.class)
                .block();
    }
}
*/