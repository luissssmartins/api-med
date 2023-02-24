package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.records.paciente.PacienteRecord;
import med.voll.api.records.paciente.UpdatePacienteRecord;

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

    private String idade;

    private String email;

    private String cpf;

    private String telefone;


    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(PacienteRecord record) {
        this.nome = record.nome();
        this.idade = record.idade();
        this.email = record.email();
        this.cpf = record.cpf();
        this.telefone = record.telefone();
        this.endereco = new Endereco(record.endereco());
        this.ativo = true;
    }

    public void update(UpdatePacienteRecord updatePacienteRecord) {

        if (updatePacienteRecord.nome() != null)
            this.nome = updatePacienteRecord.nome();

        if (updatePacienteRecord.telefone() != null)
            this.telefone = updatePacienteRecord.telefone();

        if (updatePacienteRecord.endereco() != null)
            this.endereco.update(updatePacienteRecord.endereco());
    }

    public void inactive() {
        this.ativo = false;
    }
}
