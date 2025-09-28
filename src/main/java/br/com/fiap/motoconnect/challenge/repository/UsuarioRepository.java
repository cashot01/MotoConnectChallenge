package br.com.fiap.motoconnect.challenge.repository;

import br.com.fiap.motoconnect.challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
