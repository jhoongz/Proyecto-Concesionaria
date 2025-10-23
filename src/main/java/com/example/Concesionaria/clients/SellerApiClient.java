package com.example.Concesionaria.clients;

import com.example.Concesionaria.models.SellerApi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.Concesionaria.models.Seller;

import java.util.Collections;
import java.util.List;

@Component
public class SellerApiClient {

    private final WebClient webClient;


    @Value("${baseUrlRandomUser}")
    private String randomUserUrl;

    public SellerApiClient(WebClient.Builder builder, String randomUserUrl) {
        this.webClient = builder.baseUrl(randomUserUrl).build();
    }

    public List<SellerApi> fetchSellers(Long value) {
        ApiResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("results", value).queryParam("nat", "es").build())
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();

        if (response == null || response.getResults() == null) {
            return Collections.emptyList();
        }
        return response.getResults();
    }

    // Clases internas para mapear la respuesta parcial
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ApiResponse {
        private List<SellerApi> results;
        public List<SellerApi> getResults() { return results; }
        public void setResults(List<SellerApi> results) { this.results = results; }
    }
}


