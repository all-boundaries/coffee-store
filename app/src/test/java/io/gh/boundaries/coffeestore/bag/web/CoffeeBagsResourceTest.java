package io.gh.boundaries.coffeestore.bag.web;

import io.gh.boundaries.coffeestore.bag.domain.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.gh.boundaries.coffeestore.bag.web.RoastingProfileMapping.roastingProfileResponseFrom;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CoffeeBagsResource.class)
class CoffeeBagsResourceTest {
    private static final Faker faker = new Faker();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CoffeeBags coffeeBags;

    @Test
    void returnAllKnownCoffeeBags() throws Exception {
        var coffeeBag = new CoffeeBag(
                faker.name().name(),
                faker.harryPotter().quote(),
                new Roasting(
                        RoastingProfile.Light,
                        faker.date().past(2, TimeUnit.DAYS).toLocalDateTime().toLocalDate(),
                        faker.internet().url()),
                new Weight("GRM", "g", new BigDecimal(faker.number().randomNumber(2, true))));

        when(coffeeBags.all()).thenReturn(List.of(coffeeBag));

        mockMvc.perform(get("/bags").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].name").value(coffeeBag.name()))
                .andExpect(jsonPath("$.data[0].description").value(coffeeBag.description()))
                .andExpect(jsonPath("$.data[0].roasting.profile")
                        .value(roastingProfileResponseFrom(coffeeBag.roasting().profile())
                                .getValue()))
                .andExpect(jsonPath("$.data[0].roasting.date")
                        .value(coffeeBag.roasting().date().toString()))
                .andExpect(jsonPath("$.data[0].roasting.roaster")
                        .value(coffeeBag.roasting().roasterUrl()))
                .andExpect(jsonPath("$.data[0].weight.unitCode")
                        .value(coffeeBag.weight().unitCode()))
                .andExpect(jsonPath("$.data[0].weight.unitText")
                        .value(coffeeBag.weight().unitText()))
                .andExpect(jsonPath("$.data[0].weight.value")
                        .value(coffeeBag.weight().value()));
    }

    @Test
    void returnsEmptyWhenNoCoffeeBagsExists() throws Exception {
        when(coffeeBags.all()).thenReturn(List.of());

        mockMvc.perform(get("/bags").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.data").isArray());
    }
}
