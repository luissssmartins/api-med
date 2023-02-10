package med.voll.api.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Especialidade;
import med.voll.api.records.MedicoRecord;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoJpa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome, email, crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoJpa endereco;

    public MedicoJpa(MedicoRecord record) {
        this.nome = record.nome();
        this.email = record.email();
        this.crm = record.crm();
        this.endereco = new EnderecoJpa(record.enderecoRecord());
    }
}
