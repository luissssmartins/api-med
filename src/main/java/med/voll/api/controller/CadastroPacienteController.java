package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.entity.Paciente;
import med.voll.api.records.paciente.PacienteRecord;
import med.voll.api.records.paciente.PacientesRecord;
import med.voll.api.records.paciente.UpdatePacienteRecord;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro/paciente")
public class CadastroPacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void handleCadastro(@RequestBody @Valid PacienteRecord pacienteRecord)
    {
        pacienteRepository.save(new Paciente(pacienteRecord));
    }

    @GetMapping
    public Page<PacientesRecord> handlePacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable)
    {
        return pacienteRepository.findAllByAtivoTrue(pageable).map(PacientesRecord::new);

    }

    @PutMapping
    @Transactional
    public void handleUpdate(@RequestBody @Valid UpdatePacienteRecord record)
    {
       Paciente paciente = pacienteRepository.getReferenceById(record.id());
       paciente.update(record);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void handleDelete(@PathVariable Long id)
    {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.inactive();
    }
}
