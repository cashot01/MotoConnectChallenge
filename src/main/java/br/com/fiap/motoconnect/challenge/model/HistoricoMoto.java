package br.com.fiap.motoconnect.challenge.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_historico_moto")
public class HistoricoMoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String parte;

    @Column(nullable = false, length = 500)
    private String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "moto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_historico_moto"))
    private Moto moto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_historico_usuario"))
    private Usuario usuario;
}
