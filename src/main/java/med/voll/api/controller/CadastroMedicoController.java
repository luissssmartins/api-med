package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.entity.Medico;
import med.voll.api.records.medico.MedicoRecord;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro/medico")
public class CadastroMedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void handleCadastro(@RequestBody MedicoRecord medicoRecord)
    {
        repository.save(new Medico(medicoRecord));
    }
}
