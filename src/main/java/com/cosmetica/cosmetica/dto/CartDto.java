package com.cosmetica.cosmetica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long userId;
    private Long productId;
    private Integer quantity;
}
