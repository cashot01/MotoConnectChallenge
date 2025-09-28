package br.com.fiap.motoconnect.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_historico_moto")
public class HistoricoMoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String parte;
    @Column(nullable = false, length = 500)
    private String descricao;
    @ManyToOne
    @JoinColumn(name="moto_id", nullable = false)
    private Moto moto;
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name="data_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();
    // getters e setters
}
