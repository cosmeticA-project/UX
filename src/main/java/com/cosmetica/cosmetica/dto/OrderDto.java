package com.cosmetica.cosmetica.dto;

import com.cosmetica.cosmetica.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;

    private User user;

    private String address;

    private Timestamp orderDate;
}
