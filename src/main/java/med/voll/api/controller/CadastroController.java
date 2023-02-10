package med.voll.api.controller;

import med.voll.api.jpa.MedicoJpa;
import med.voll.api.records.MedicoRecord;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void handleCadastro(@RequestBody MedicoRecord medicoRecord)
    {
        repository.save(new MedicoJpa(medicoRecord));
    }
}
