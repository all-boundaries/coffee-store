package io.gh.boundaries.coffeestore.bag.persistence;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeBagsRepository extends CrudRepository<CoffeeBagEntity, UUID> {}
