package com.MangeRacing.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FrenteIMG frente;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MotorIMG motor;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RodaFrenteIMG rodaFrente;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RodaTraseiraIMG rodaTraseira;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;


}
