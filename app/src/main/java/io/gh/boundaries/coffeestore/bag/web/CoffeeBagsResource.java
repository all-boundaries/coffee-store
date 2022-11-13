package io.gh.boundaries.coffeestore.bag.web;

import io.gh.boundaries.coffeestore.bag.domain.CoffeeBags;
import io.gh.boundaries.coffeestore.web.*;
import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static io.gh.boundaries.coffeestore.bag.web.RoastingProfileMapping.roastingProfileResponseFrom;

@RestController
public class CoffeeBagsResource implements BagsApi {
    private final CoffeeBags coffeeBags;

    public CoffeeBagsResource(CoffeeBags coffeeBags) {
        this.coffeeBags = coffeeBags;
    }

    @Override
    public ResponseEntity<AllBags200Response> allBags() {
        var bags = coffeeBags.all().stream()
                .map(coffeeBag -> {
                    var response = new CoffeeBag();
                    response.name(coffeeBag.name());
                    response.description(coffeeBag.description());
                    response.roasting(new CoffeeBagRoasting() {
                        {
                            profile(roastingProfileResponseFrom(coffeeBag.roasting().profile()));
                            date(coffeeBag.roasting().date());
                            roaster(URI.create(coffeeBag.roasting().roasterUrl()));
                        }
                    });
                    response.weight(new CoffeeBagWeight() {
                        {
                            unitCode(coffeeBag.weight().unitCode());
                            unitText(coffeeBag.weight().unitText());
                            value(coffeeBag.weight().value());
                        }
                    });
                    return response;
                })
                .toList();

        return ResponseEntity.ok(new AllBags200Response() {
            {
                data(bags);
            }
        });
    }
}
