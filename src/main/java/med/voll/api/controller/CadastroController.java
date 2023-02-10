package med.voll.api.controller;

import med.voll.api.records.MedicoRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @PostMapping
    public void handleCadastro(@RequestBody MedicoRecord medicoRecord)
    {
        System.out.println(medicoRecord);
    }
}
