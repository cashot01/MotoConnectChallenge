package br.com.fiap.motoconnect.challenge.service;

import br.com.fiap.motoconnect.challenge.model.HistoricoMoto;
import br.com.fiap.motoconnect.challenge.repository.HistoricoMotoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoMotoService {

    private final HistoricoMotoRepository repository;

    public HistoricoMotoService(HistoricoMotoRepository repository) {
        this.repository = repository;
    }

    public List<HistoricoMoto> listarTodos() {
        return repository.findAll();
    }

    public List<HistoricoMoto> listarPorMoto(Long motoId) {
        return repository.findByMotoId(motoId);
    }

    public Optional<HistoricoMoto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public HistoricoMoto salvar(HistoricoMoto historico) {
        return repository.save(historico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
