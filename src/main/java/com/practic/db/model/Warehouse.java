package com.practic.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(id, warehouse.id) && Objects.equals(nameOfProduct, warehouse.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfProduct);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                '}';
    }
}
