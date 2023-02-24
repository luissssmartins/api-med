package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.entity.Medico;
import med.voll.api.records.medico.MedicoRecord;
import med.voll.api.records.medico.MedicosRecord;
import med.voll.api.records.medico.UpdateMedicoRecord;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro/medico")
public class CadastroMedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void handleCadastro(@RequestBody @Valid MedicoRecord medicoRecord)
    {
        repository.save(new Medico(medicoRecord));
    }

    @GetMapping
    public Page<MedicosRecord> handleMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable)
    {
        return repository.findAllByAtivoTrue(pageable).map(MedicosRecord::new);
    }

    @PutMapping
    @Transactional
    public void handleUpdate(@RequestBody @Valid UpdateMedicoRecord updateMedicoRecord)
    {
        Medico medico = repository.getReferenceById(updateMedicoRecord.id());
        medico.update(updateMedicoRecord);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void handleDelete(@PathVariable Long id)
    {
        Medico medico = repository.getReferenceById(id);
        medico.inactive();
    }
}
