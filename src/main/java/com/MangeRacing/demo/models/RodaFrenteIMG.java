package com.MangeRacing.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "rodaFrenteIMG")
public class RodaFrenteIMG {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 500, nullable = false)
    private String imagem;

    @Column(length = 150, nullable = false)
    private String title;

}
