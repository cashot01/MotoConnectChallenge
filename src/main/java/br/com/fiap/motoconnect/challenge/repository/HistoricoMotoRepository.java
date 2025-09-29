package br.com.fiap.motoconnect.challenge.repository;

import br.com.fiap.motoconnect.challenge.model.HistoricoMoto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoricoMotoRepository extends JpaRepository<HistoricoMoto, Long> {
    List<HistoricoMoto> findByMotoId(Long motoId);
}

