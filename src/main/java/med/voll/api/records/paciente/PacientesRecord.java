package med.voll.api.records.paciente;

import med.voll.api.entity.Paciente;

public record PacientesRecord(Long id, String nome, String idade, String cpf, String email) {

    public PacientesRecord(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getIdade(), paciente.getCpf(), paciente.getEmail());
    }
}
