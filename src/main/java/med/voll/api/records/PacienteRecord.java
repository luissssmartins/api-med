package med.voll.api.records;

public record PacienteRecord(String nome, String dataDeNascimento, String idade, String cpf, EnderecoRecord enderecoRecord) {
}
