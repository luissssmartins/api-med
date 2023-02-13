package med.voll.api.records.paciente;

import med.voll.api.records.endereco.EnderecoRecord;
public record PacienteRecord(String nome, String dataDeNascimento, String idade, String cpf, EnderecoRecord enderecoRecord) {
}
