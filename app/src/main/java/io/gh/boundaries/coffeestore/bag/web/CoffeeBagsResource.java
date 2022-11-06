package io.gh.boundaries.coffeestore.bag.web;

import io.gh.boundaries.coffeestore.web.AllBags200Response;
import io.gh.boundaries.coffeestore.web.BagsApi;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeBagsResource implements BagsApi {
    @Override
    public ResponseEntity<AllBags200Response> allBags() {
        var body = new AllBags200Response() {
            {
                data(List.of());
            }
        };

        return ResponseEntity.ok(body);
    }
}
