package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Especialidade;
import med.voll.api.records.medico.MedicoRecord;
import med.voll.api.records.medico.UpdateMedicoRecord;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoRecord record) {
        this.nome = record.nome();
        this.email = record.email();
        this.telefone = record.telefone();
        this.crm = record.crm();
        this.especialidade = record.especialidade();
        this.endereco = new Endereco(record.endereco());
    }

    public void update(UpdateMedicoRecord updateMedicoRecord) {

        /*
        if (updateMedicoRecord.nome() == null) {
            throw new NullPointerException("O nome do medico nao pode estar nulo.");
        }

        if (updateMedicoRecord.telefone() == null) {
            throw new NullPointerException("O telefone do medico nao pode estar nulo.");
        }

        if (updateMedicoRecord.endereco() == null) {
            throw new NullPointerException("Um ou mais campos do endereco nao podem estar nulos.");
        }
         */

        //this.nome = updateMedicoRecord.nome();
        //this.telefone = updateMedicoRecord.telefone();
        //this.endereco.update(updateMedicoRecord.endereco());

        if (updateMedicoRecord.nome() != null)
            this.nome = updateMedicoRecord.nome();

        if (updateMedicoRecord.telefone() != null)
            this.telefone = updateMedicoRecord.telefone();

        if (updateMedicoRecord.endereco() != null)
            this.endereco.update(updateMedicoRecord.endereco());
    }
}
