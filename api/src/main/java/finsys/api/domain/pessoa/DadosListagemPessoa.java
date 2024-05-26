package finsys.api.domain.pessoa;

public record DadosListagemPessoa(
        Long id,
        String nome,
        Boolean ativo) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(),
             pessoa.getNome(),
             pessoa.getAtivo());
    }

}
