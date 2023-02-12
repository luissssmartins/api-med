package med.voll.api.jpa;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.records.EnderecoRecord;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoJpa {

    private String logradouro, bairro, cep, numero, complemento, cidade, uf;

    public EnderecoJpa(EnderecoRecord record) {
        this.logradouro = record.logradouro();
        this.bairro = record.bairro();
        this.cep = record.cep();
        this.numero = record.numero();
        this.complemento = record.complemento();
        this.cidade = record.cidade();
        this.uf = record.uf();
    }
}
