package finsys.api.domain.lancamento;

import finsys.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "lancamento")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    private BigDecimal valor;

    private Boolean corrente;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    public Lancamento(DadosCadastroLancamento dados) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.corrente = true;
        this.categoria = dados.categoria();
        this.pessoa = dados.pessoa();
        this.tipo = dados.tipo();
        this.observacao = dados.observacao();
    }

    public void atualizarInformacoes(DadosAtualizacaoLancamento dados) {
        if(descricao != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataPagamento() != null) {
            this.dataPagamento = dados.dataPagamento();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.corrente() != null) {
            this.corrente = dados.corrente();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.pessoa() != null) {
            this.pessoa = dados.pessoa();
        }
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }

    }

    public void excluir() {
        this.corrente = false;
    }
}
