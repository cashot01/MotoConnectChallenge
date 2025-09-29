package br.com.fiap.motoconnect.challenge.service;

import br.com.fiap.motoconnect.challenge.model.Usuario;
import br.com.fiap.motoconnect.challenge.repository.UsuarioRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario register(OAuth2User principal) {
        var usuario = usuarioRepository.findByEmail(principal.getAttributes().get("email").toString());
        return usuario.orElseGet(() -> usuarioRepository.save(new Usuario(principal)));
    }
}
