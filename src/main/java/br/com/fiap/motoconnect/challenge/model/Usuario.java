package br.com.fiap.motoconnect.challenge.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String avatarUrl;


    public Usuario(OAuth2User principal) {
        this.nome = principal.getAttributes().get("name").toString();
        this.email = principal.getAttributes().get("email").toString();
        this.avatarUrl = principal.getAttributes().get("avatar_url").toString();
    }
}
