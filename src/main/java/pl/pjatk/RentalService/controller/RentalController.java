package pl.pjatk.RentalService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;
import pl.pjatk.RentalService.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RestTemplate restTemplate){
        this.rentalService = new RentalService(restTemplate);
    }

    @PatchMapping("/takeMovie/{id}")
    public ResponseEntity takeMovie(@PathVariable Long id){
        try {
            rentalService.findMovie(id);
            return ResponseEntity.ok().build();
    } catch (HttpClientErrorException ex){
            return  renting(ex);
        }
    }

    @PatchMapping("/returnMovie/{id}")
        public ResponseEntity returnMovie(@PathVariable Long id){
        try {
            rentalService.returnMovie(id);
            return ResponseEntity.ok().build();
    } catch (HttpClientErrorException ex) {
            return renting(ex);
    }
    }

    private ResponseEntity renting(HttpClientErrorException ex) {
        switch (ex.getStatusCode()) {
            case NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            case INTERNAL_SERVER_ERROR:
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
            default:
                return ResponseEntity.status(504).build();
        }
    }


}
