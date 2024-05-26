package finsys.api.domain.pessoa;

import finsys.api.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(
        Long id,
        String nome,
        Boolean ativo,
        Endereco endereco) {

    public DadosDetalhamentoPessoa (Pessoa pessoa){
        this(pessoa.getId(),
             pessoa.getNome(),
             pessoa.getAtivo(),
             pessoa.getEndereco());
    }

}
