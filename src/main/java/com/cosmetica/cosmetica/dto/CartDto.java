package com.cosmetica.cosmetica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private UserDto user;
    private Set<CarteItemDto> cartItems;
}
