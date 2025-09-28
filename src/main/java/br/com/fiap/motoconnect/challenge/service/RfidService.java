package br.com.fiap.motoconnect.challenge.service;

import br.com.fiap.motoconnect.challenge.model.Rfid;
import br.com.fiap.motoconnect.challenge.repository.RfidRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RfidService {

    private final RfidRepository repository;

    public RfidService(RfidRepository repository) {
        this.repository = repository;
    }

    public List<Rfid> listarTodos() {
        return repository.findAll();
    }

    public Optional<Rfid> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Rfid salvar(Rfid rfid) {
        return repository.save(rfid);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
