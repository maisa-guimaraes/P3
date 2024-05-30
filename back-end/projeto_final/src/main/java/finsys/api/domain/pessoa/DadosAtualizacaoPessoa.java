package finsys.api.domain.pessoa;

import finsys.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(

        @NotNull
        Long id,

        String nome,

        Boolean ativo,

        DadosEndereco endereco

) {
}
