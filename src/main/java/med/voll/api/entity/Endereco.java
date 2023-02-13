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

    public void update(EnderecoRecord endereco) {

        if (endereco.logradouro() == null) {
            throw new NullPointerException();
        }

        if (endereco.bairro() == null) {
            throw new NullPointerException();
        }

        if (endereco.cep() == null) {
            throw new NullPointerException();
        }

        if (endereco.numero() == null) {
            throw new NullPointerException();
        }

        if (endereco.complemento() == null) {
            throw new NullPointerException();
        }

        if (endereco.cidade() == null) {
            throw new NullPointerException();
        }

        if (endereco.uf() == null) {
            throw new NullPointerException();
        }

        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }
}
