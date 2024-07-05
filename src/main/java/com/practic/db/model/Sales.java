package com.practic.db.model;

import com.practic.db.DTO.ProductDTO;
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
@Table(name = "sale")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sale",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductDTO>productDTOList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(id, sales.id) && Objects.equals(number, sales.number) && Objects.equals(warehouse, sales.warehouse) && Objects.equals(productDTOList, sales.productDTOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, warehouse, productDTOList);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", warehouse=" + warehouse +
                ", productDTOList=" + productDTOList +
                '}';
    }
}
