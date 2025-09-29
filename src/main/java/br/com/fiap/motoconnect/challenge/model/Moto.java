package br.com.fiap.motoconnect.challenge.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_moto", uniqueConstraints = @UniqueConstraint(columnNames = "placa"))
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false, length = 7, unique = true)
    private String placa;

    @Column(nullable = false, length = 15)
    private String status;

    @ManyToOne
    @JoinColumn(name = "rfid_id", foreignKey = @ForeignKey(name = "fk_moto_rfid"))
    private Rfid rfid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_moto_usuario"))
    private Usuario usuario;
}
