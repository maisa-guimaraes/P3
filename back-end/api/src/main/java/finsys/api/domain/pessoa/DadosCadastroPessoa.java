package finsys.api.domain.pessoa;

import finsys.api.domain.endereco.DadosEndereco;

public record DadosCadastroPessoa(
        String nome,
        Boolean ativo,
        DadosEndereco endereco
) {
}
