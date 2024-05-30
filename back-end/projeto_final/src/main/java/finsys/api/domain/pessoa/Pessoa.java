package finsys.api.domain.pessoa;

import finsys.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {

        if(dados.nome() != null) {
            this.nome = dados.nome();
        }

        if(dados.ativo() != null) {
            this.ativo = dados.ativo();
        }

        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }

    public Pessoa(Pessoa pessoa) {
        this.id = pessoa.getId();
    }

}
