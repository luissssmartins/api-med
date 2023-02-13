package med.voll.api.records.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.records.endereco.EnderecoRecord;
public record PacienteRecord(

        @NotBlank
        String nome,

        @NotBlank
        String idade,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        EnderecoRecord endereco) {
}
