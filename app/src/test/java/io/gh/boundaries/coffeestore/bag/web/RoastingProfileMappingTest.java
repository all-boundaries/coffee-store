package io.gh.boundaries.coffeestore.bag.web;

import static io.gh.boundaries.coffeestore.bag.web.RoastingProfileMapping.roastingProfileResponseFrom;
import static org.assertj.core.api.Assertions.assertThat;

import io.gh.boundaries.coffeestore.bag.domain.RoastingProfile;
import io.gh.boundaries.coffeestore.web.CoffeeBagRoasting;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RoastingProfileMappingTest {
    @ParameterizedTest
    @MethodSource("profileMap")
    void name(RoastingProfile profile, CoffeeBagRoasting.ProfileEnum profileInResponse) throws Exception {
        assertThat(roastingProfileResponseFrom(profile)).isEqualTo(profileInResponse);
    }

    public static Stream<Arguments> profileMap() {
        return Stream.of(
                Arguments.of(RoastingProfile.Light, CoffeeBagRoasting.ProfileEnum.LIGHT),
                Arguments.of(RoastingProfile.Medium, CoffeeBagRoasting.ProfileEnum.MEDIUM),
                Arguments.of(RoastingProfile.MediumDark, CoffeeBagRoasting.ProfileEnum.MEDIUM_DARK),
                Arguments.of(RoastingProfile.Dark, CoffeeBagRoasting.ProfileEnum.DARK));
    }
}
