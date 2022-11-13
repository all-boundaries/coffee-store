package io.gh.boundaries.coffeestore.bag.web;

import io.gh.boundaries.coffeestore.bag.domain.RoastingProfile;
import io.gh.boundaries.coffeestore.web.CoffeeBagRoasting;

import java.util.Map;

public class RoastingProfileMapping {
    private static final Map<RoastingProfile, CoffeeBagRoasting.ProfileEnum> roastingProfile2Response = Map.of(
            RoastingProfile.Light, CoffeeBagRoasting.ProfileEnum.LIGHT,
            RoastingProfile.Medium, CoffeeBagRoasting.ProfileEnum.MEDIUM,
            RoastingProfile.MediumDark, CoffeeBagRoasting.ProfileEnum.MEDIUM_DARK,
            RoastingProfile.Dark, CoffeeBagRoasting.ProfileEnum.DARK);

    public static CoffeeBagRoasting.ProfileEnum roastingProfileResponseFrom(RoastingProfile profile) {
        return roastingProfile2Response.get(profile);
    }
}
