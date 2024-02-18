package com.cosmetica.cosmetica.dto;

import com.cosmetica.cosmetica.model.Order;
import com.cosmetica.cosmetica.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Long orderDetailId;

    private Order order;

    private Product product;

    private Integer quantity;
}
