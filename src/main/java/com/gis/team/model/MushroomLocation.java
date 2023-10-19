package com.gis.team.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MushroomLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(precision = 19, scale = 15)
    private BigDecimal x;
    @Column(precision = 19, scale = 15)
    private BigDecimal y;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MushroomLocation that = (MushroomLocation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public MushroomLocation(String name, BigDecimal x, BigDecimal y, String description) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MushroomLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", description='" + description + '\'' +
                '}';
    }
}
