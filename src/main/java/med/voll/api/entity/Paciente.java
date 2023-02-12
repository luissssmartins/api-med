package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.records.PacienteRecord;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataDeNascimento;
    private String idade;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteRecord record) {
        this.nome = record.nome();
        this.dataDeNascimento = record.dataDeNascimento();
        this.idade = record.idade();
        this.cpf = record.cpf();
        this.endereco = new Endereco(record.enderecoRecord());
    }
}
