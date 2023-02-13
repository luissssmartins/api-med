package med.voll.api.records.paciente;

import med.voll.api.entity.Paciente;

public record PacientesRecord(String nome, String idade, String cpf, String email) {

    public PacientesRecord(Paciente paciente) {
        this(paciente.getNome(), paciente.getIdade(), paciente.getCpf(), paciente.getEmail());
    }
}
