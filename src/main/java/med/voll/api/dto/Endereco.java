package med.voll.api.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.records.EnderecoRecord;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro, bairro, cep, numero, complemento, cidade, uf;

    public Endereco(EnderecoRecord record) {
        this.logradouro = record.logradouro();
        this.bairro = record.bairro();
        this.cep = record.cep();
        this.numero = record.numero();
        this.complemento = record.complemento();
        this.cidade = record.cidade();
        this.uf = record.uf();
    }
}
