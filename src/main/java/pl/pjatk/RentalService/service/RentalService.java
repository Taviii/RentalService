package pl.pjatk.RentalService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;

import java.util.Optional;

@Service
public class RentalService {

    private final RestTemplate restTemplate;
    String fooResourceUrl = "http://localhost:8081/rental";

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<Movie> findMovie(Long id) throws HttpClientErrorException {
        try {
            return Optional.of(this.restTemplate.getForObject(fooResourceUrl + "/rental/" + id, Movie.class));
        } catch (final HttpClientErrorException ex) {
            var statusCode = ex.getStatusCode();
            if (statusCode.value() == 404)
                return Optional.empty();
            throw ex;
        }
    }

    public void takeMovie(Long id) throws RestClientException {
        this.restTemplate.getForObject(fooResourceUrl + "/rental/" + id + "/isA/false", Movie.class);
    }

    public void returnMovie(Long id) throws RestClientException {
        this.restTemplate.getForObject(fooResourceUrl + "/rental/" + id + "/isA/true", Movie.class);
    }

}
