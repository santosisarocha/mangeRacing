package com.MangeRacing.demo.models.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class CarrinhoDTO {
    private UUID frente;
    private UUID motor;
    private UUID rodaFrente;
    private UUID rodaTraseira;
    private UUID user;
}
