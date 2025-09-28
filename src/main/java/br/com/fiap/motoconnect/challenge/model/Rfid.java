package br.com.fiap.motoconnect.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_rfid")
public class Rfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome_area", nullable = false, length = 100)
    private String nomeArea;
    @Column(nullable = false, precision = 9, scale = 6)
    private Double latitude;
    @Column(nullable = false, precision = 9, scale = 6)
    private Double longitude;
    // getters e setters
}
