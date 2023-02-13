package med.voll.api.records.medico;

import med.voll.api.entity.Medico;
import med.voll.api.enums.Especialidade;

public record MedicosRecord(String nome, String email, String crm, Especialidade especialidade) {

    public MedicosRecord(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
