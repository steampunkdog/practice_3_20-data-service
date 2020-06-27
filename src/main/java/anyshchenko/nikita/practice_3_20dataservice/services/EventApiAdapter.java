package anyshchenko.nikita.practice_3_20dataservice.services;

import anyshchenko.nikita.practice_3_20dataservice.configuration.AppProperties;
import anyshchenko.nikita.practice_3_20dataservice.model.DataModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EventApiAdapter {

    private WebClient webClient;

    public EventApiAdapter(WebClient.Builder webClientBuilder, AppProperties appProperties) {
        this.webClient = webClientBuilder
//                .baseUrl("https://app.ticketmaster.com/discovery/v2/events.json")
                .baseUrl("https://app.ticketmaster.com/discovery/v2/events.json?apikey=" + appProperties.getApiKey())
                .build();
    }

    public Mono<DataModel> getData() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(DataModel.class);
    }
}
