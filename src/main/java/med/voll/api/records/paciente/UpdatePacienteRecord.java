package med.voll.api.records.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.records.endereco.EnderecoRecord;

public record UpdatePacienteRecord(
        @NotNull
        Long id,

        String nome,

        String telefone,

        @Valid
        EnderecoRecord endereco) {
}
