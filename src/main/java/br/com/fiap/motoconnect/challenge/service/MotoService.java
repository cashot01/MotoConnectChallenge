package br.com.fiap.motoconnect.challenge.service;

import br.com.fiap.motoconnect.challenge.model.Moto;
import br.com.fiap.motoconnect.challenge.repository.MotoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final MotoRepository repository;

    public MotoService(MotoRepository repository) {
        this.repository = repository;
    }

    public List<Moto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Moto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Moto salvar(Moto moto) {
        return repository.save(moto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
