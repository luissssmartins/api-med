package med.voll.api.records.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.records.endereco.EnderecoRecord;

public record UpdateMedicoRecord(

        @NotNull
        Long id,

        String nome,

        String telefone,

        @Valid
        EnderecoRecord endereco) {

}
