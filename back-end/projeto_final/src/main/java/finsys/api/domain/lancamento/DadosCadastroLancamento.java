package finsys.api.domain.lancamento;

import finsys.api.domain.categoria.Categoria;
import finsys.api.domain.pessoa.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLancamento(

        @NotBlank
        String descricao,

        LocalDate dataVencimento,

        LocalDate dataPagamento,

        @NotNull
        BigDecimal valor,

        Boolean corrente,

        TipoLancamento tipo,

        Categoria categoria,

        Pessoa pessoa,

        String observacao
) {
}
