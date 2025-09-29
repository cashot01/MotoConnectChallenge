package br.com.fiap.motoconnect.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_moto", uniqueConstraints = @UniqueConstraint(columnNames = "placa"))
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String modelo;

    @Column(nullable = false, length = 7)
    private String placa;

    @Column(nullable = false, length = 15)
    private String status;

    @ManyToOne
    @JoinColumn(name="rfid_id")
    private Rfid rfid;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;
}
