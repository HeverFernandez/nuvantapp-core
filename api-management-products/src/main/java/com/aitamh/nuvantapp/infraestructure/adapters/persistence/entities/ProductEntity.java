package com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities;

import com.aitamh.nuvantapp.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"codigo"}),
                @UniqueConstraint(columnNames = {"codigo_barra"})
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false)
    private CategoryEntity categoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unit_measure", nullable = false)
    private UnitMeasureEntity unitMeasure;

    @Column(name = "purchase_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "sale_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "min_stock", nullable = false)
    private Integer minStock;

    private String barcode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "igv_affection", nullable = false)
    private Boolean igvAffection;

    @Column(length = 100)
    private String brand;

    @Column(length = 100)
    private String supplier;

    // ====== AUDITORÍA ======
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDate creationDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @PrePersist
    void onCreate() {
        this.creationDate = LocalDate.now();
        this.status = Status.ACTIVO;
    }

    @PreUpdate
    void onUpdate() {
        this.updateDate = LocalDate.now();
    }
}