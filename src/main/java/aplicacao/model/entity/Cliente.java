package aplicacao.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull
    @CPF
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @Column(nullable = false, length = 60)
    private String cidade;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}