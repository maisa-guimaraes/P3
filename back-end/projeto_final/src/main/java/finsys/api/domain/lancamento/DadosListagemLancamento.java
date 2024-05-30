package finsys.api.domain.lancamento;

import finsys.api.domain.categoria.Categoria;
import finsys.api.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento(
        Long id,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        TipoLancamento tipo,
        Categoria categoria,
        Pessoa pessoa) {

    public DadosListagemLancamento(Lancamento lancamento) {
        this(lancamento.getId(),
             lancamento.getDataVencimento(),
             lancamento.getDataVencimento(),
             lancamento.getValor(),
             lancamento.getTipo(),
             lancamento.getCategoria(),
             lancamento.getPessoa());
    }

}
