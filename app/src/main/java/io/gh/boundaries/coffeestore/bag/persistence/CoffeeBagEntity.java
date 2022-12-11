package io.gh.boundaries.coffeestore.bag.persistence;

import io.gh.boundaries.coffeestore.bag.domain.RoastingProfile;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity(name = "coffee_bag")
@AllArgsConstructor
@ToString
public class CoffeeBagEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "roasting_profile", nullable = false)
    private RoastingProfile roastingProfile;

    @Column(name = "roasting_date", nullable = false)
    private LocalDate roastingDate;

    @Column(name = "roasting_vendor", nullable = false)
    private String roastingVendor;

    @Column(name = "weight_code", nullable = false)
    private String weightCode;

    @Column(name = "weight_text", nullable = false)
    private String weightText;

    @Column(name = "weight_value", nullable = false)
    private BigDecimal weightValue;

    private CoffeeBagEntity() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CoffeeBagEntity that = (CoffeeBagEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
