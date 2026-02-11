package com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductRequest(
        @NotBlank(message = "El código es obligatorio")
        @Size(min = 3, max = 50, message = "El código debe tener entre 3 y 50 caracteres")
        String code,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 3, max = 150, message = "El nombre debe tener entre 3 y 150 caracteres")
        String name,

        @Size(max = 500, message = "La descripción no debe superar 500 caracteres")
        String description,

        @NotNull(message = "La categoría es obligatoria")
        Long category,

        @NotNull(message = "El precio de compra es obligatorio")
        @DecimalMin(value = "0.00", inclusive = false, message = "El precio de compra debe ser mayor a 0")
        @Digits(integer = 10, fraction = 2, message = "Formato de precio inválido")
        BigDecimal purchasePrice,

        @NotNull(message = "El precio de venta es obligatorio")
        @DecimalMin(value = "0.00", inclusive = false, message = "El precio de venta debe ser mayor a 0")
        @Digits(integer = 10, fraction = 2, message = "Formato de precio inválido")
        BigDecimal salePrice,

        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,

        @NotNull(message = "El stock mínimo es obligatorio")
        @Min(value = 0, message = "El stock mínimo no puede ser negativo")
        Integer minStock,

        String barcode,

        @NotNull(message = "La unidad de medida es obligatoria")
        Long unitMeasurement,

        @FutureOrPresent(message = "La fecha de vencimiento no puede ser pasada")
        LocalDate expirationDate,

        Boolean igvAffection,

        @Size(max = 100, message = "La marca no debe superar 100 caracteres")
        String brand,

        String supplier
) {
}
