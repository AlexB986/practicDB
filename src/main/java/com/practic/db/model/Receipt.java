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
@Getter
@Setter
@Entity(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(id, receipt.id) && Objects.equals(number, receipt.number) && Objects.equals(warehouse, receipt.warehouse) && Objects.equals(productEntityList, receipt.productEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, warehouse, productEntityList);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", warehouse=" + warehouse +
                ", productDTOList=" + productEntityList +
                '}';
    }
}
