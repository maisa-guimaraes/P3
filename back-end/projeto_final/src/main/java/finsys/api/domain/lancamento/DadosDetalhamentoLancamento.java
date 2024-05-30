package finsys.api.domain.lancamento;

import finsys.api.domain.categoria.Categoria;
import finsys.api.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoLancamento(
        Long id,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        Boolean corrente,
        TipoLancamento tipo,
        Categoria categoria,
        Pessoa pessoa,
        String observacao
) {

    public DadosDetalhamentoLancamento(Lancamento lancamento) {
        this(lancamento.getId(),
             lancamento.getDescricao(),
             lancamento.getDataVencimento(),
             lancamento.getDataPagamento(),
             lancamento.getValor(),
             lancamento.getCorrente(),
             lancamento.getTipo(),
             lancamento.getCategoria(),
             lancamento.getPessoa(),
             lancamento.getObservacao());
    }

}
