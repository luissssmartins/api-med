package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.records.endereco.EnderecoRecord;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

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
