package med.voll.api.records;

import med.voll.api.enums.Especialidade;

public record MedicoRecord(String nome, String email, String crm, Especialidade especialidade, EnderecoRecord enderecoRecord) {
}
