package med.voll.api.repository;

import med.voll.api.jpa.MedicoJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoJpa, Long> {

}
