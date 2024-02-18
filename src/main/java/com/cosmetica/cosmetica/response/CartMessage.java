package com.cosmetica.cosmetica.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartMessage {
    String message;
    Boolean status;
}
