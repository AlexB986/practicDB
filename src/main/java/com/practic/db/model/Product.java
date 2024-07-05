package com.practic.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String articles;
    private String nameOfProduct;
    private Double sale;
    private Double lastPurchasePrice;
    private Double lastSalePrice;
    private LocalDateTime coming;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(articles, product.articles) && Objects.equals(nameOfProduct, product.nameOfProduct) && Objects.equals(sale, product.sale) && Objects.equals(lastPurchasePrice, product.lastPurchasePrice) && Objects.equals(lastSalePrice, product.lastSalePrice) && Objects.equals(coming, product.coming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articles, nameOfProduct, sale, lastPurchasePrice, lastSalePrice, coming);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", articles='" + articles + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", sale=" + sale +
                ", lastPurchasePrice=" + lastPurchasePrice +
                ", lastSalePrice=" + lastSalePrice +
                ", coming=" + coming +
                '}';
    }
}