package com.cosmetica.cosmetica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarteItemDto {
    private CartDto cart;
    private ProductDto product;
    private int quantity;
}
